package org.softeer_2nd.caArt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarTrimChoiceViewModel() : ViewModel() {

    private val _engineSelectionButtonText = MutableLiveData<Pair<String, String>>(Pair("디젤 2.2", "가솔린 3.8"))
    val engineSelectionButtonText: LiveData<Pair<String, String>> = _engineSelectionButtonText

    private val _bodySelectionButtonText = MutableLiveData<Pair<String, String>>(Pair("7인승","8인승"))
    val bodySelectionButtonText: LiveData<Pair<String, String>> = _bodySelectionButtonText

    private val _drivenSelectionButtonText =  MutableLiveData<Pair<String, String>>(Pair("2WD","4WD"))
    val drivenSelectionButtonText: LiveData<Pair<String, String>> = _drivenSelectionButtonText
}
