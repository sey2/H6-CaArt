package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.BudgetRange
import org.softeer_2nd.caArt.model.data.SurveyQuestion
import org.softeer_2nd.caArt.model.repository.RecommendRepository
import javax.inject.Inject

@HiltViewModel
class LifeStyleDetailSurveyViewModel @Inject constructor(private val repository: RecommendRepository) :
    ProcessViewModel<SurveyQuestion>() {

    val budgetRange: LiveData<BudgetRange> = repository.budgetRange.asLiveData()

    fun requestAdditionalSurveyQuestion() {
        viewModelScope.launch {
            val questions = repository.fetchAdditionalLifestyleSurveyQuestion() ?: return@launch
            withContext(Dispatchers.Main) {
                setProcessData(questions)
                setLastProcess(questions.size)
                startProcess()
            }
        }
    }

}