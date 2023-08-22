package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    fun selectPersona(persona: Persona) {
        _selectedPersona.value = persona
    }

    fun requestSurveyQuestion() {
        viewModelScope.launch {
            val questions = repository.fetchLifestyleSurveyQuestions() ?: return@launch
            withContext(Dispatchers.Main) {
                val temp = questions.toMutableList()
                temp.add(SurveyQuestion("페르소나 질문", "키워드", null))
                setProcessData(temp)
                setLastProcess(questions.size + 1)
                startProcess()
            }
        }
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
}