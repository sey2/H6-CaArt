package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.model.data.event.SurveyQuestion
import org.softeer_2nd.caArt.model.factory.DummyItemFactory

class LifeStyleSurveyViewModel : ProcessViewModel<SurveyQuestion>() {

    private val _personaList = MutableLiveData<List<Persona>>()
    val personaList: LiveData<List<Persona>> = _personaList

    private val _selectedPersona = MutableLiveData<Persona>()
    val selectedPersona: LiveData<Persona> = _selectedPersona

    init {
        val dummy = DummyItemFactory.createSurveyQuestionDummyItem()
        setProcessData(dummy)
        setLastProcess(dummy.size)
        startProcess()
        _personaList.value = DummyItemFactory.createLifestylePersonaListDummyItem()
    }

    fun selectPersona(persona: Persona) {
        _selectedPersona.value = persona
    }

}