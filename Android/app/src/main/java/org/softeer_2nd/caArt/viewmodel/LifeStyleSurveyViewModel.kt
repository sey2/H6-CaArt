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

    private var selectedAnswerList: MutableList<Answer?>? = null

    var displayPersonaPageIndex = 0
        private set

    val selectedAgeAnswer: Answer? get() = if (!selectedAnswerList.isNullOrEmpty()) selectedAnswerList!![0] else null

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
                selectedAnswerList = selectedAnswerList ?: MutableList(questions.size) { null }
                if (currentProcessIndex < 0) startProcess()
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
                selectPersona(selectedPersona.value ?: personaList[0])
            }
        }
    }

    fun selectAnswer(selectedAnswer: Answer) {
        selectedAnswerList?.let {
            _selectedAnswer.value = selectedAnswer
            if (it.size > currentProcessIndex) {
                it[currentProcessIndex] = selectedAnswer
            }
        }
    }

    fun setDisplayPersonaPageIndex(position: Int) {
        displayPersonaPageIndex = position
    }

}