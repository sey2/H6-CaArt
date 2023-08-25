package org.softeer_2nd.caArt.model.network

import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.model.data.dto.AdditionalSurveyQuestionResponse
import org.softeer_2nd.caArt.model.data.dto.SurveyQuestionResponse
import org.softeer_2nd.caArt.model.data.state.LifestyleDetailState
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResultDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

sealed interface RecommendApiService {

    @GET("/lifestyles/questions")
    suspend fun getSurveyQuestion(): CaArtResponse<SurveyQuestionResponse>

    @GET("/personas")
    suspend fun getPersonaList(): CaArtResponse<List<Persona>>

    @GET("/lifestyles/questions/additional")
    suspend fun getAdditionalSurveyQuestion(): CaArtResponse<AdditionalSurveyQuestionResponse>

    @GET("/personas/{personaId}")
    suspend fun getLifestyleDetail(
        @Path("personaId") personaId: Int
    ): CaArtResponse<LifestyleDetailState>

    @GET("personas/{personaId}/recommendation")
    suspend fun getRecommendationResultByLifestyle(
        @Path("personaId") personaId: Int,
        @Query("age") ageId: String

    ): CaArtResponse<RecommendCompleteResultDTO>

    @GET("lifestyles/recommendation")
    suspend fun getRecommendationResultByAdditionalQuestions(
        @Query("age") age: String,
        @Query("experience") experience: String,
        @Query("family") family: String,
        @Query("purpose") purpose: String,
        @Query("value") value: String,
        @Query("budget") budget: Int
    ): CaArtResponse<RecommendCompleteResultDTO>
}