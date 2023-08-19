package org.softeer_2nd.caArt.model.data

data class SurveyQuestion(
    val question: String,
    val keyword: String,
    val choices: List<Choice>?
)
