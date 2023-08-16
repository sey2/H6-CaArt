package org.softeer_2nd.caArt.viewmodel

import org.softeer_2nd.caArt.model.data.event.SurveyQuestion
import org.softeer_2nd.caArt.model.factory.DummyItemFactory

class LifeStyleSurveyViewModel : ProcessViewModel<SurveyQuestion>() {

    init {
        val dummy = DummyItemFactory.createSurveyQuestionDummyItem()
        setProcessData(dummy)
        setLastProcess(dummy.size)
        startProcess()
    }
}