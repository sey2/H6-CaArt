package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.Answer
import org.softeer_2nd.caArt.model.data.BudgetRange
import org.softeer_2nd.caArt.model.data.SurveyQuestion
import org.softeer_2nd.caArt.model.repository.RecommendRepository
import javax.inject.Inject

@HiltViewModel
class LifeStyleDetailSurveyViewModel @Inject constructor(private val repository: RecommendRepository) :
    ProcessViewModel<SurveyQuestion>() {

    val selectedExperienceAnswer: Answer? get() = if (selectedAnswerList?.isNotEmpty() == true) selectedAnswerList!![0] else null
    val selectedFamilyAnswer: Answer?
        get() = if ((selectedAnswerList?.size ?: 0) > 2) selectedAnswerList!![1] else null
    val selectedPurposeAnswer: Answer?
        get() = if ((selectedAnswerList?.size ?: 0) > 3) selectedAnswerList!![2] else null
    val selectedValueAnswer: Answer?
        get() = if ((selectedAnswerList?.size ?: 0) > 4) selectedAnswerList!![3] else null

    private var selectedAnswerList: MutableList<Answer?>? = null

    private val _selectedAnswer = MutableLiveData<Answer>()
    val selectedAnswer: LiveData<Answer> = _selectedAnswer

    val budgetRange: LiveData<BudgetRange> = repository.budgetRange.asLiveData()

    fun requestAdditionalSurveyQuestion() {
        viewModelScope.launch {
            val questions = repository.fetchAdditionalLifestyleSurveyQuestion() ?: return@launch
            withContext(Dispatchers.Main) {
                setProcessData(questions)
                setLastProcess(questions.size)
                selectedAnswerList = selectedAnswerList ?: MutableList(questions.size) { null }
                if (currentProcessIndex < 0) startProcess()
            }
        }
    }

    override fun next() {
        super.next()
        if (processData.isNotEmpty() && !processData[currentProcessIndex].answers.isNullOrEmpty())
            selectAnswer(processData[currentProcessIndex].answers!![0])
    }

    fun selectAnswer(selectedAnswer: Answer) {
        selectedAnswerList?.let {
            _selectedAnswer.value = selectedAnswer
            if (it.size > currentProcessIndex) {
                it[currentProcessIndex] = selectedAnswer
            }
        }
    }
}