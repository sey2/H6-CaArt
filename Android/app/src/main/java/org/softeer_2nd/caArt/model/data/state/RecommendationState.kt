package org.softeer_2nd.caArt.model.data.state

import org.softeer_2nd.caArt.model.data.Option

data class RecommendationState(
    val model: RecommendationModelState,
    val options: List<Option>
)