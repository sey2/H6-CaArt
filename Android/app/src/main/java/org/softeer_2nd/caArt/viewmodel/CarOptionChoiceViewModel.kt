package org.softeer_2nd.caArt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.OptionTag
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
    }

    private val _tagList = MutableLiveData<List<OptionTag>>()
    val tagList: LiveData<List<OptionTag>> = _tagList

    private val _selectedTag = MutableLiveData<OptionTag>()
    val selectedTag: LiveData<OptionTag> = _selectedTag

    private val _optionList = MutableLiveData<List<Option>>()
    val optionList: LiveData<List<Option>> = _optionList

    private val _situationalOptions = MutableLiveData<List<Option?>>()
    val situationalOptions: LiveData<List<Option?>> = _situationalOptions

    private val _tabState = MutableLiveData<Int>(ADDITIONAL_OPTION_PAGE)
    val tabState: LiveData<Int> = _tabState

    private val _displayType = MutableLiveData<Int>(OPTION_LIST)
    val displayType: LiveData<Int> = _displayType


    fun selectTag(tag: OptionTag) {
        _selectedTag.value = tag
        val tagId = if (selectedTag.value?.tagId == 8) null else selectedTag.value?.tagId
        if (tabState.value == ADDITIONAL_OPTION_PAGE) requestAdditionalOptionList(
            tagId, 1, 1, 1, 1
        )
        else requestDefaultOptionList(tagId, 1, 1, 1, 1)
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
        trimId: Int,
        engineId: Int,
        bodyTypeId: Int,
        wheelDriveId: Int
    ) {
        viewModelScope.launch {
            val optionList = optionRepository.fetchAdditionalOptionList(
                tagId,
                trimId,
                engineId,
                bodyTypeId,
                wheelDriveId
            )
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
                    _situationalOptions.value = situationOptionList.toList()
                }
            }
        }
    }

    private fun requestDefaultOptionList(
        tagId: Int?,
        trimId: Int,
        engineId: Int,
        bodyTypeId: Int,
        wheelDriveId: Int
    ) {
        viewModelScope.launch {
            val optionList = optionRepository.fetchDefaultOptionList(
                tagId,
                trimId,
                engineId,
                bodyTypeId,
                wheelDriveId
            )
            withContext(Dispatchers.Main) {
                _optionList.value = optionList
            }
        }
    }

    fun setTabState(tabState: Int) {
        _tabState.value = tabState
        if (tagList.value != null) _selectedTag.value = tagList.value!![0]
        if (tabState == DEFAULT_OPTION_PAGE) _tagList.value = optionRepository.getTagList()
        else _tagList.value = optionRepository.getAdditionalTagList()

        checkAndUpdateDisplayType()
    }

    fun checkAndUpdateDisplayType() {
        if (tabState.value == ADDITIONAL_OPTION_PAGE && (selectedTag.value?.tagId != 8)) {
            _displayType.value = OPTION_IMAGE
        } else {
            _displayType.value = OPTION_LIST
        }
    }

    fun requestNextPage() {

    }
}