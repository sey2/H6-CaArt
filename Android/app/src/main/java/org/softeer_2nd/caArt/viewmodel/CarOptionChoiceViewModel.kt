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
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.OptionTag
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

    private val _optionList = MutableLiveData<List<Option>>()
    val optionList: LiveData<List<Option>> = _optionList

    private val _situationalOptions = MutableLiveData<List<Option?>>()
    val situationalOptions: LiveData<List<Option?>> = _situationalOptions

    private val _situationalOptionViewState =MutableLiveData<SituationalOptionViewState>()
    val situationalOptionViewState:LiveData<SituationalOptionViewState> = _situationalOptionViewState

    private val _tabState = MutableLiveData<Int>(ADDITIONAL_OPTION_PAGE)
    val tabState: LiveData<Int> = _tabState

    private val _displayType = MutableLiveData<Int>(OPTION_LIST)
    val displayType: LiveData<Int> = _displayType

    val totalOptionCount = optionRepository.totalOptionCount.asLiveData()
    val isLastPage = optionRepository.isLastPage.asLiveData()


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
                _selectedTag.value = tagList[0]
            }
        }
    }

    private fun requestAdditionalOptionList(
        tagId: Int?,
    ) {
        viewModelScope.launch {
            val optionList = optionRepository.fetchFirstAdditionalOptionList(tagId)?:return@launch
            withContext(Dispatchers.Main) {
                if (displayType.value == OPTION_LIST) {
                    _optionList.value = optionList
                } else {
                    val situationOptionList: MutableList<Option?> = MutableList(
                        SITUATIONAL_OPTION_MAX
                    ) { null }
                    for (i in 0 until min(optionList.size, SITUATIONAL_OPTION_MAX)) {
                        situationOptionList[i] = optionList[i]
                    }
                    _situationalOptionViewState.value=SituationalOptionViewState(
                        selectedTag.value?.tagImage?:"",
                        situationOptionList.toList(),
                    )
                }
            }
        }
    }

    private fun requestDefaultOptionList(
        tagId: Int?
    ) {
        viewModelScope.launch {
            val optionList = optionRepository.fetchFirstDefaultOptionList(tagId)?:return@launch
            withContext(Dispatchers.Main) {
                _optionList.value = optionList
            }
        }
    }

    fun setTabState(tabState: Int) {
        _tabState.value = tabState
        if (tagList.value != null) selectTag(tagList.value!![0])

        if (tabState == DEFAULT_OPTION_PAGE) _tagList.value = optionRepository.getTagList()
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
            withContext(Dispatchers.Main) {
                val additionalList =
                    if (tabState.value == ADDITIONAL_OPTION_PAGE) optionRepository.fetchNextAdditionalOptionList(tagId)?:return@withContext
                    else optionRepository.fetchNextDefaultOptionList(tagId)?:return@withContext
                val updateList = optionList.value?.toMutableList() ?: mutableListOf()
                updateList.addAll(additionalList)
                _optionList.value = updateList
            }
        }
    }
}