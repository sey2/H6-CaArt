package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.state.OptionDetailDialogState
import org.softeer_2nd.caArt.model.data.state.SelectState

class OptionDetailDialogViewModel(
    private val mainOption: Option,
    private val initialSelected: Boolean
) : ViewModel() {

    private val _onSelectChangeEvent = MutableLiveData<Boolean>()
    val onSelectChangeEvent: LiveData<Boolean> = _onSelectChangeEvent

    private val _optionDetailDialogState = MutableLiveData<OptionDetailDialogState>()
    val optionDetailDialogState: LiveData<OptionDetailDialogState> = _optionDetailDialogState

    init {
        val optionList =
            if (mainOption.subOptions.isNullOrEmpty()) listOf(mainOption) else mainOption.subOptions

        _optionDetailDialogState.value = OptionDetailDialogState(
            mainOption = mainOption,
            optionList = optionList,
            isSelected = initialSelected
        )
    }

    fun changeSelected() {
        val changeResult =
            if (onSelectChangeEvent.value == null) {
                !initialSelected
            } else {
                !onSelectChangeEvent.value!!
            }

        _onSelectChangeEvent.value = changeResult
    }


    fun getSelectState() = SelectState(mainOption, onSelectChangeEvent.value ?: initialSelected)

}