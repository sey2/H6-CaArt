package org.softeer_2nd.caArt.model.data.state

import org.softeer_2nd.caArt.model.data.Cover
import org.softeer_2nd.caArt.model.data.dto.Interview
import org.softeer_2nd.caArt.model.data.dto.Profile

data class LifestyleDetailState(
    val cover: Cover,
    val interviews: List<Interview>,
    val personaId: Int,
    val profile: Profile,
    val recommendation: RecommendationState,
    val tags: List<String>
)