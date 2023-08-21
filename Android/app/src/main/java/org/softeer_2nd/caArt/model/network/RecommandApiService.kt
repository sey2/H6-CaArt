package org.softeer_2nd.caArt.model.network

import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.model.data.dto.AdditionalSurveyQuestionResponse
import org.softeer_2nd.caArt.model.data.dto.SurveyQuestionResponse
import org.softeer_2nd.caArt.model.data.state.LifestyleDetailState
import retrofit2.http.GET
import retrofit2.http.Path

sealed interface RecommandApiService {

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
}