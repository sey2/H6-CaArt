package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.Answer
import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.model.data.SurveyQuestion
import org.softeer_2nd.caArt.model.repository.RecommendRepository
import javax.inject.Inject

@HiltViewModel
class LifeStyleSurveyViewModel @Inject constructor(
    val repository: RecommendRepository
) : ProcessViewModel<SurveyQuestion>() {

    private val _personaList = MutableLiveData<List<Persona>>()
    val personaList: LiveData<List<Persona>> = _personaList

    private val _selectedPersona = MutableLiveData<Persona>()
    val selectedPersona: LiveData<Persona> = _selectedPersona

    private val _selectedAnswer = MutableLiveData<Answer>()
    val selectedAnswer: LiveData<Answer> = _selectedAnswer

    private lateinit var selectedAnswerList: MutableList<Answer?>

    val selectedAgeAnswer: Answer? get() = if (selectedAnswerList.isNotEmpty()) selectedAnswerList[0] else null

    val selectedPersonaId: Int? get() = selectedPersona.value?.personaId

    fun selectPersona(persona: Persona) {
        _selectedPersona.value = persona
    }

    fun requestSurveyQuestion() {
        viewModelScope.launch {
            val questions = repository.fetchLifestyleSurveyQuestions() ?: return@launch
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
            selectAnswer(processData[0].answers!![0])
    }

    fun requestPersonaList() {
        viewModelScope.launch {
            val personaList = repository.fetchPersonaList() ?: return@launch
            withContext(Dispatchers.Main) {
                _personaList.value = personaList
                selectPersona(personaList[0])
            }
        }
    }

    fun selectAnswer(selectedAnswer: Answer) {
        _selectedAnswer.value = selectedAnswer
        if (selectedAnswerList.size > currentProcessIndex) {
            selectedAnswerList[currentProcessIndex] = selectedAnswer
        }
    }

}