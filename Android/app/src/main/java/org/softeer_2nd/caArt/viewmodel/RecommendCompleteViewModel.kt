package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResultDTO
import org.softeer_2nd.caArt.model.data.state.RecommendCompleteResultState
import org.softeer_2nd.caArt.model.repository.RecommendRepository
import javax.inject.Inject

@HiltViewModel
class RecommendCompleteViewModel @Inject constructor(private val repository: RecommendRepository) :
    ViewModel() {

    private val _resultState=MutableLiveData<RecommendCompleteResultState>()
    val resultState: LiveData<RecommendCompleteResultState> = _resultState

    private val _additionalQuestionRecommendResultState=MutableLiveData<RecommendCompleteResultState>()
    val additionalQuestionRecommendResultState: LiveData<RecommendCompleteResultState> = _additionalQuestionRecommendResultState


    fun requestRecommendCompleteResult(personaId: Int,age:String) {

        viewModelScope.launch {
            val state=repository.fetchRecommendResult(personaId,age)?:return@launch
            withContext(Dispatchers.Main){
                _resultState.value=state
            }
        }
    }

    fun requestRecommendCompleteResultByAdditionalQuestions(
        age: String,
        experience: String,
        family: String,
        purpose: String,
        value: String,
        budget: Int
    ){
        viewModelScope.launch {
            val state=repository.fetchRecommendResult(age,experience, family, purpose, value, budget)?:return@launch
            withContext(Dispatchers.Main){
                _additionalQuestionRecommendResultState.value=state
            }
        }
    }
}