package org.softeer_2nd.caArt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarTrimChoiceViewModel() : ViewModel() {
    private val _engineSelectionLeftButtonText = MutableLiveData<String>("디젤 2.2")
    val engineSelectionLeftButtonText: LiveData<String> = _engineSelectionLeftButtonText

    private val _engineSelectionRightButtonText = MutableLiveData<String>("가솔린 3.8")
    val engineSelectionRightButtonText: LiveData<String> = _engineSelectionRightButtonText

    private val _bodySelectionLeftButtonText = MutableLiveData<String>("7인승")
    val bodySelectionLeftButtonText: LiveData<String> = _bodySelectionLeftButtonText

    private val _bodySelectionRightButtonText = MutableLiveData<String>("8인승")
    val bodySelectionRightButtonText: LiveData<String> = _bodySelectionRightButtonText

    private val _drivenSelectionLeftButtonText = MutableLiveData<String>("2WD")
    val drivenSelectionLeftButtonText: LiveData<String> = _drivenSelectionLeftButtonText

    private val _drivenSelectionRightButtonText = MutableLiveData<String>("4WD")
    val drivenSelectionRightButtonText: LiveData<String> = _drivenSelectionRightButtonText
}
