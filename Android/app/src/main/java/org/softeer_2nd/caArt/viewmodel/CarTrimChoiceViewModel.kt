package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.model.repository.CarTrimRepository
import javax.inject.Inject

@HiltViewModel
class CarTrimChoiceViewModel @Inject constructor(
    val repository: CarTrimRepository
) : ViewModel() {

    init {
        getTrims()
    }

    private val _engineSelectionButtonText =
        MutableLiveData<Pair<String, String>>(Pair("디젤 2.2", "가솔린 3.8"))
    val engineSelectionButtonText: LiveData<Pair<String, String>> = _engineSelectionButtonText

    private val _bodySelectionButtonText = MutableLiveData<Pair<String, String>>(Pair("7인승", "8인승"))
    val bodySelectionButtonText: LiveData<Pair<String, String>> = _bodySelectionButtonText

    private val _drivenSelectionButtonText =
        MutableLiveData<Pair<String, String>>(Pair("2WD", "4WD"))
    val drivenSelectionButtonText: LiveData<Pair<String, String>> = _drivenSelectionButtonText


    fun getTrims() {
        viewModelScope.launch {
            val list = repository.fetchTrims()
        }
    }
}
