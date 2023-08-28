package org.softeer_2nd.caArt.model.data.state

import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.ResultChoiceOption

data class RecommendCompleteResultState(
    val model: Model,
    val resultOptions: List<ResultChoiceOption>,
    val palisadeImage: String,
    val recommendationCard: RecommendationCardState?,
    val totalPrice: Long
)