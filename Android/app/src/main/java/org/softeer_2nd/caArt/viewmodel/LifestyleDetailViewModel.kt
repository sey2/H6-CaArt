package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.model.data.state.LifestyleDetailState
import org.softeer_2nd.caArt.model.repository.RecommandRepository
import javax.inject.Inject

@HiltViewModel
class LifestyleDetailViewModel @Inject constructor(private val repository: RecommandRepository) :
    ViewModel() {

    private val _lifestyleDetailState = MutableLiveData<LifestyleDetailState>()
    val lifestyleDetailState: LiveData<LifestyleDetailState> = _lifestyleDetailState

    fun requestLifeStyleState(personaId: Int) {
        viewModelScope.launch {
            val result = repository.fetchLifestyleDetail(personaId) ?: return@launch
            _lifestyleDetailState.value = result
        }
    }

}