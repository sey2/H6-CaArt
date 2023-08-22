package org.softeer_2nd.caArt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.Answer
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResultDTO
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResultDTO.Companion.toState
import org.softeer_2nd.caArt.model.data.state.RecommendCompleteResultState
import org.softeer_2nd.caArt.model.repository.RecommendRepository
import javax.inject.Inject

@HiltViewModel
class RecommendCompleteViewModel @Inject constructor(private val repository: RecommendRepository) :
    ViewModel() {

    private val _resultState = MutableLiveData<RecommendCompleteResultState>()
    val resultState: LiveData<RecommendCompleteResultState> = _resultState

    private val _answerList = MutableLiveData<List<String>>()
    val answerList: LiveData<List<String>> = _answerList

    var recommendResultData: RecommendCompleteResultDTO? = null
        private set

    fun requestRecommendCompleteResult(personaId: Int, age: String): Boolean {
        if (personaId < 0 || age.isEmpty()) return false
        viewModelScope.launch {
            val data = repository.fetchRecommendResult(personaId, age) ?: return@launch
            withContext(Dispatchers.Main) {
                _resultState.value = data.toState()
                recommendResultData = data
            }
        }
        return true
    }

    fun requestRecommendCompleteResultByAdditionalQuestions(
        age: Answer,
        experience: Answer?,
        family: Answer?,
        purpose: Answer?,
        value: Answer?,
        budget: Int
    ): Boolean {
        if (experience == null || family == null || purpose == null || value == null) return false
        viewModelScope.launch {
            val state =
                repository.fetchRecommendResult(
                    age.code,
                    experience.code,
                    family.code,
                    purpose.code,
                    value.code,
                    budget
                ) ?: return@launch
            val answerList = listOf(
                age.answer,
                experience.answer,
                family.answer,
                purpose.answer,
                value.answer,
                "$budget 만원"
            )
            withContext(Dispatchers.Main) {
                _resultState.value = state
                _answerList.value = answerList
            }
        }

        return true
    }

}