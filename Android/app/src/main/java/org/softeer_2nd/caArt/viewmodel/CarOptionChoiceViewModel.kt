package org.softeer_2nd.caArt.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.OptionTag
import org.softeer_2nd.caArt.model.repository.CarOptionRepository
import javax.inject.Inject

@HiltViewModel
class CarOptionChoiceViewModel @Inject constructor(private val optionRepository: CarOptionRepository) :
    ViewModel() {

    private val _tagList = MutableLiveData<List<OptionTag>>()
    val tagList = _tagList

    private val _selectedTag = MutableLiveData<OptionTag>()
    val selectedTag = _selectedTag

    fun selectTag(tag: OptionTag) {
        _selectedTag.value=tag
    }

    fun requestTagList(){
        viewModelScope.launch {
            val tagList=optionRepository.fetchOptionTags()
            withContext(Dispatchers.Main){
                _tagList.value=tagList
                _selectedTag.value=tagList[0]
            }
        }
    }
}