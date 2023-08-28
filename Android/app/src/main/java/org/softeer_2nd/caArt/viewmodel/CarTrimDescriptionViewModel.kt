package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.model.data.Compositions
import org.softeer_2nd.caArt.model.repository.CarTrimRepository
import javax.inject.Inject

@HiltViewModel
class CarTrimDescriptionViewModel @Inject constructor(
    val repository: CarTrimRepository
) : ViewModel() {

    private val _composition = MutableLiveData<Compositions>()
    val composition: LiveData<Compositions> = _composition

    fun getCompositions() {
        viewModelScope.launch {
            _composition.value = repository.fetchComposition()
        }
    }
}
