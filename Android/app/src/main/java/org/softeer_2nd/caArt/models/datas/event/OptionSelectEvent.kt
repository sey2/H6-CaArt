package org.softeer_2nd.caArt.models.datas.event

import org.softeer_2nd.caArt.models.datas.Option

data class OptionSelectEvent(
    val option: Option,
    val isSelected: Boolean
)
