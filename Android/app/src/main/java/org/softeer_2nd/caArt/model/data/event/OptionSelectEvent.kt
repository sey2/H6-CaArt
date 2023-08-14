package org.softeer_2nd.caArt.model.data.event

import org.softeer_2nd.caArt.model.data.Option

data class OptionSelectEvent(
    val option: Option,
    val isSelected: Boolean
)
