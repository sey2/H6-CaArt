package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.SurveyQuestion

data class AdditionalSurveyQuestionResponse(
    val budget: Budget,
    val experience: SurveyQuestion,
    val family: SurveyQuestion,
    val purpose: SurveyQuestion,
    val value: SurveyQuestion
)