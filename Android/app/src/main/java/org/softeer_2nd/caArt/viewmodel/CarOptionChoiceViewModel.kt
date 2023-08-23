package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.MutableSetLiveData
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.OptionTag
import org.softeer_2nd.caArt.model.data.state.SelectState
import org.softeer_2nd.caArt.model.data.state.SituationalOptionViewState
import org.softeer_2nd.caArt.model.repository.CarOptionRepository
import javax.inject.Inject
import kotlin.math.min

@HiltViewModel
class CarOptionChoiceViewModel @Inject constructor(private val optionRepository: CarOptionRepository) :
    ViewModel() {

    companion object {
        const val ADDITIONAL_OPTION_PAGE = 0
        const val DEFAULT_OPTION_PAGE = 1

        const val OPTION_LIST = 0
        const val OPTION_IMAGE = 1

        const val SITUATIONAL_OPTION_MAX = 4

        const val ALL_TAG_ID = 8
    }

    private val _tagList = MutableLiveData<List<OptionTag>>()
    val tagList: LiveData<List<OptionTag>> = _tagList

    private val _selectedTag = MutableLiveData<OptionTag>()
    val selectedTag: LiveData<OptionTag> = _selectedTag

    private val _optionListWithSelectStage = MutableLiveData<List<SelectState<Option>>>()
    val optionListWithSelectState: LiveData<List<SelectState<Option>>> = _optionListWithSelectStage

    private var optionList = listOf<Option>()
    private var situationalOptionList = listOf<Option?>()

    private val _situationalOptionViewState = MutableLiveData<SituationalOptionViewState>()
    val situationalOptionViewState: LiveData<SituationalOptionViewState> =
        _situationalOptionViewState

    private val _tabState = MutableLiveData<Int>(ADDITIONAL_OPTION_PAGE)
    val tabState: LiveData<Int> = _tabState

    private val _displayType = MutableLiveData<Int>(OPTION_LIST)
    val displayType: LiveData<Int> = _displayType

    private val _optionSelectEvent = MutableLiveData<SelectState<Int>>()
    val optionSelectEvent: LiveData<SelectState<Int>> = _optionSelectEvent

    private val _situationalOptionSelectEvent = MutableLiveData<SelectState<Int>>()
    val situationalOptionSelectEvent: LiveData<SelectState<Int>> = _situationalOptionSelectEvent

    val totalOptionCount = optionRepository.totalOptionCount.asLiveData()
    val isLastPage = optionRepository.isLastPage.asLiveData()

    private val _selectedOptionSet = MutableSetLiveData<Option>()
    val selectedOptionSet: LiveData<Set<Option>> = _selectedOptionSet

    private val _optionDetailDialogPopUpEvent = MutableLiveData<SelectState<Option>>()
    val optionDetailDialogPopUpEvent: LiveData<SelectState<Option>> = _optionDetailDialogPopUpEvent

    fun selectTag(tag: OptionTag) {
        _selectedTag.value = tag
        val tagId = if (selectedTag.value?.tagId == ALL_TAG_ID) null else selectedTag.value?.tagId
        if (tabState.value == ADDITIONAL_OPTION_PAGE) {
            requestAdditionalOptionList(tagId)
        } else {
            requestDefaultOptionList(tagId)
        }
        checkAndUpdateDisplayType()
    }

    fun requestTagList() {
        viewModelScope.launch {
            optionRepository.fetchOptionTags()
            val tagList = optionRepository.getAdditionalTagList()
            withContext(Dispatchers.Main) {
                _tagList.value = tagList
                selectTag(tagList[0])
            }
        }
    }

    private fun requestAdditionalOptionList(
        tagId: Int?,
    ) {
        viewModelScope.launch {
            optionList = optionRepository.fetchFirstAdditionalOptionList(tagId) ?: return@launch
            val optionListWithSelectState = optionList.map { option ->
                SelectState(option, _selectedOptionSet.contain(option))
            }

            if (displayType.value == OPTION_LIST) {
                withContext(Dispatchers.Main) {
                    _optionListWithSelectStage.value = optionListWithSelectState
                }
            } else {
                val situationOptionListWithSelectState: MutableList<SelectState<Option>?> =
                    MutableList(
                        SITUATIONAL_OPTION_MAX
                    ) { null }
                val situationOptionList: MutableList<Option?> = MutableList(
                    SITUATIONAL_OPTION_MAX
                ) { null }

                for (i in 0 until min(optionListWithSelectState.size, SITUATIONAL_OPTION_MAX)) {
                    situationOptionListWithSelectState[i] = optionListWithSelectState[i]
                    situationOptionList[i] = optionList[i]
                }
                situationalOptionList = situationOptionList.toList()
                withContext(Dispatchers.Main) {
                    _situationalOptionViewState.value = SituationalOptionViewState(
                        selectedTag.value?.tagImage ?: "",
                        situationOptionListWithSelectState
                    )
                }
            }
        }
    }

    private fun requestDefaultOptionList(
        tagId: Int?
    ) {
        viewModelScope.launch {
            optionList = optionRepository.fetchFirstDefaultOptionList(tagId) ?: return@launch
            val optionListWithSelectState = optionList.map { option ->
                SelectState(option, true)
            }
            withContext(Dispatchers.Main) {
                _optionListWithSelectStage.value = optionListWithSelectState
            }
        }
    }

    fun setTabState(tabState: Int) {
        _tabState.value = tabState
        if (tagList.value != null) selectTag(tagList.value!![0])

        if (tabState == DEFAULT_OPTION_PAGE) _tagList.value = optionRepository.getDefaultTagList()
        else _tagList.value = optionRepository.getAdditionalTagList()

        checkAndUpdateDisplayType()
    }

    fun checkAndUpdateDisplayType() {
        if (tabState.value == ADDITIONAL_OPTION_PAGE && (selectedTag.value?.tagId != ALL_TAG_ID)) {
            _displayType.value = OPTION_IMAGE
        } else {
            _displayType.value = OPTION_LIST
        }
    }

    fun requestNextPage() {
        val tagId = if (selectedTag.value?.tagId == ALL_TAG_ID) null else selectedTag.value?.tagId
        if (isLastPage.value == true) return
        viewModelScope.launch {
            val additionalList =
                if (tabState.value == ADDITIONAL_OPTION_PAGE) optionRepository.fetchNextAdditionalOptionList(
                    tagId
                ) ?: return@launch
                else optionRepository.fetchNextDefaultOptionList(tagId) ?: return@launch

            val additionalListWithSelectState = additionalList.map { option ->
                SelectState(option, _selectedOptionSet.contain(option))
            }
            optionList = optionList.toMutableList().apply {
                addAll(additionalList)
            }
            val updateList = optionListWithSelectState.value?.toMutableList() ?: mutableListOf()
            updateList.addAll(additionalListWithSelectState)
            withContext(Dispatchers.Main) {
                _optionListWithSelectStage.value = updateList
            }
        }
    }

    fun selectOption(option: Option?, result: Boolean? = null): Boolean {
        option ?: return false

        val isSelectable = result ?: !_selectedOptionSet.contain(option)

        if (isSelectable) {
            _selectedOptionSet.add(option)
        } else {
            _selectedOptionSet.remove(option)
        }

        when (displayType.value) {
            OPTION_LIST -> {
                val optionIndex = optionList.indexOf(option)
                _optionSelectEvent.value = SelectState(optionIndex, isSelectable)
            }

            OPTION_IMAGE -> {
                val optionIndex =
                    situationalOptionList.indexOf(option)
                if (optionIndex >= 0) _situationalOptionSelectEvent.value =
                    SelectState(optionIndex, isSelectable)
            }
        }

        return true
    }

    fun setSituationalOptionSelect(index: Int): Boolean {
        if (index < 0) return false
        val selectedOption = situationalOptionList[index]
        return selectOption(selectedOption)
    }

    fun setOptionDetailDialogPopUpEvent(option: Option) {
        _optionDetailDialogPopUpEvent.value =
            SelectState(option, _selectedOptionSet.contain(option))
    }

    fun selectDialogResultOption(option: SelectState<Option>) {
        selectOption(option.item, option.isSelected)
    }
}