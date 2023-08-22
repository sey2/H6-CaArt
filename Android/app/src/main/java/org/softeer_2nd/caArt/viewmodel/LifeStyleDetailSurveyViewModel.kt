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

    val selectedExperienceAnswer: Answer? get() = if (selectedAnswerList.isNotEmpty()) selectedAnswerList[0] else null
    val selectedFamilyAnswer: Answer? get() = if (selectedAnswerList.size > 2) selectedAnswerList[1] else null
    val selectedPurposeAnswer: Answer? get() = if (selectedAnswerList.size > 3) selectedAnswerList[2] else null
    val selectedValueAnswer: Answer? get() = if (selectedAnswerList.size > 4) selectedAnswerList[3] else null

    private lateinit var selectedAnswerList: MutableList<Answer?>

    private val _selectedAnswer = MutableLiveData<Answer>()
    val selectedAnswer: LiveData<Answer> = _selectedAnswer

    val budgetRange: LiveData<BudgetRange> = repository.budgetRange.asLiveData()

    fun requestAdditionalSurveyQuestion() {
        viewModelScope.launch {
            val questions = repository.fetchAdditionalLifestyleSurveyQuestion() ?: return@launch
            withContext(Dispatchers.Main) {
                setProcessData(questions)
                setLastProcess(questions.size)
                selectedAnswerList = MutableList(questions.size) { null }
                startProcess()
            }
        }
    }

    override fun next() {
        super.next()
        if (processData.isNotEmpty() && !processData[currentProcessIndex].answers.isNullOrEmpty())
            selectAnswer(processData[currentProcessIndex].answers!![0])
    }

    fun selectAnswer(selectedAnswer: Answer) {
        _selectedAnswer.value = selectedAnswer
        if (selectedAnswerList.size > currentProcessIndex) {
            selectedAnswerList[currentProcessIndex] = selectedAnswer
        }
    }
}