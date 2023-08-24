package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.model.data.Compositions
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.repository.CarTrimRepository
import javax.inject.Inject

@HiltViewModel
class CarTrimChoiceViewModel @Inject constructor(
    val repository: CarTrimRepository
) : ViewModel() {

    private val _trims = MutableLiveData<List<Trim>>()
    val trims: LiveData<List<Trim>> = _trims

    private val _composition = MutableLiveData<Compositions>()
    val composition: LiveData<Compositions> = _composition

    private var _trimChoiceDescription = MutableLiveData("")
    val trimChoiceDescription: LiveData<String> = _trimChoiceDescription

    private var _isToolTipVisible = MutableLiveData(true)
    val isToolTipVisible: LiveData<Boolean> = _isToolTipVisible

    fun getTrims() {
        viewModelScope.launch {
            _trims.value = repository.fetchTrims()
        }
    }

    fun getCompositions() {
        viewModelScope.launch {
            _composition.value = repository.fetchComposition()
            _trimChoiceDescription.value = composition.value?.carEngines?.get(0)?.description
        }
    }

    fun setTrimChoiceDescription(newDescription: String) {
        _trimChoiceDescription.value = newDescription
    }

    fun setIsToolTipVisible(visibility: Boolean) {
        _isToolTipVisible.value = visibility
    }

    fun findMatchedTrimIndices(selectedTrim: Trim): Int {
        return trims.value?.indexOfFirst { it.trimName ==  selectedTrim.trimName} ?: 0
    }
}
