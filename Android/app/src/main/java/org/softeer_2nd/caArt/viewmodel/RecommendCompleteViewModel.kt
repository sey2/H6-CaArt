package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.Answer
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResult
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResult.Companion.toState
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

    var recommendResultData: RecommendCompleteResult? = null
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
        maxBudget: Int,
        minBudget: Int
    ): Boolean {
        if (experience == null || family == null || purpose == null || value == null) return false
        viewModelScope.launch {
            val data =
                repository.fetchRecommendResult(
                    age.code,
                    experience.code,
                    family.code,
                    purpose.code,
                    value.code,
                    maxBudget,
                    minBudget
                ) ?: return@launch
            val answerList = listOf(
                age.answer,
                experience.answer,
                family.answer,
                purpose.answer,
                value.answer,
                "${maxBudget / 10000} 만원"
            )

            val state = data.toState()

            withContext(Dispatchers.Main) {
                _resultState.value = state
                _answerList.value = answerList
                recommendResultData = data
            }
        }
        return true
    }

}