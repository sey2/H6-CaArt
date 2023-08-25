package org.softeer_2nd.caArt.model.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import org.softeer_2nd.caArt.model.data.Answer
import org.softeer_2nd.caArt.model.data.BudgetRange
import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.model.data.SurveyQuestion
import org.softeer_2nd.caArt.model.data.state.LifestyleDetailState
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResultDTO
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResultDTO.Companion.toState
import org.softeer_2nd.caArt.model.data.state.RecommendCompleteResultState
import org.softeer_2nd.caArt.model.network.RecommendApiService
import javax.inject.Inject
import kotlin.math.exp

class RecommendRepository @Inject constructor(
    private val service: RecommendApiService
) {

    private var personaList: List<Persona>? = null

    private val _budgetRange = MutableStateFlow(BudgetRange(4200, 6900, 300))
    val budgetRange: StateFlow<BudgetRange> = _budgetRange

    suspend fun fetchLifestyleSurveyQuestions(): List<SurveyQuestion>? {
        val data = service.getSurveyQuestion().data ?: return null
        return listOf(data.age, data.persona)
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

    suspend fun fetchRecommendResult(personaId: Int, age: String): RecommendCompleteResultDTO? {

        //TODO 서버 변경 이후 ageId->ageCode로변경
        val data = service.getRecommendationResultByLifestyle(personaId, age).data
        return data
    }

    suspend fun fetchRecommendResult(
        age: String,
        experience: String,
        family: String,
        purpose: String,
        value: String,
        budget: Int
    ): RecommendCompleteResultState? {

        val data = service.getRecommendationResultByAdditionalQuestions(
            age = age,
            experience = experience,
            family = family,
            purpose = purpose,
            value = value,
            budget = budget
        ).data
        return data?.toState()
    }

}