package org.softeer_2nd.caArt.model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.viewmodel.OptionDetailDialogViewModel

class OptionDetailDialogViewModelFactory(
    private val mainOption: Option,
    private val initialSelected: Boolean
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OptionDetailDialogViewModel::class.java)) {
            return OptionDetailDialogViewModel(mainOption, initialSelected) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}