package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.softeer_2nd.caArt.model.data.BudgetRange
import org.softeer_2nd.caArt.model.data.event.SurveyQuestion
import org.softeer_2nd.caArt.model.factory.DummyItemFactory

class LifeStyleDetailSurveyViewModel : ProcessViewModel<SurveyQuestion>() {

    private val _budgetRange = MutableLiveData<BudgetRange>()
    val budgetRange: LiveData<BudgetRange> = _budgetRange

    init {
        val dummy = DummyItemFactory.createDetailSurveyQuestionDummyItem()
        setProcessData(dummy)
        setLastProcess(dummy.size)
        startProcess()
        _budgetRange.value = DummyItemFactory.createBudgetRangeDummyItem()
    }
}