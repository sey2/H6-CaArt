package org.softeer_2nd.caArt.model.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.softeer_2nd.caArt.model.data.BudgetRange
import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.model.data.SurveyQuestion
import org.softeer_2nd.caArt.model.data.state.LifestyleDetailState
import org.softeer_2nd.caArt.model.network.RecommandApiService
import javax.inject.Inject

class RecommendRepository @Inject constructor(
    private val service: RecommandApiService
) {

    private var personaList: List<Persona>? = null

    private val _budgetRange = MutableStateFlow(BudgetRange(4200, 6900, 300))
    val budgetRange: StateFlow<BudgetRange> = _budgetRange

    suspend fun fetchLifestyleSurveyQuestions(): List<SurveyQuestion>? {
        val data = service.getSurveyQuestion().data ?: return null
        return listOf(data.age)
    }

    suspend fun fetchPersonaList(): List<Persona>? {
        personaList = service.getPersonaList().data ?: return null
        personaList?.forEach {
            it.coverLetter = it.coverLetter.replace("\\n", "\n")
        }
        return personaList
    }

    suspend fun fetchAdditionalLifestyleSurveyQuestion(): List<SurveyQuestion>? {
        val data = service.getAdditionalSurveyQuestion().data ?: return null
        val questions = mutableListOf<SurveyQuestion>()
        val budgetQuestion = SurveyQuestion(
            question = data.budget.question,
            keyword = data.budget.keyword,
            null
        )
        questions.apply {
            add(data.experience)
            add(data.family)
            add(data.purpose)
            add(data.value)
            add(budgetQuestion)
        }
        _budgetRange.value =
            BudgetRange(data.budget.minBudget, data.budget.maxBudget, data.budget.budgetUnit)
        return questions
    }

    suspend fun fetchLifestyleDetail(personaId: Int): LifestyleDetailState? {
        return service.getLifestyleDetail(personaId).data
    }


}