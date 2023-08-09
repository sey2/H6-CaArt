package org.softeer_2nd.caArt.dataClasses.event

import org.softeer_2nd.caArt.dataClasses.Option

data class OptionSelectEvent(
    val option: Option,
    val isSelected: Boolean
)
