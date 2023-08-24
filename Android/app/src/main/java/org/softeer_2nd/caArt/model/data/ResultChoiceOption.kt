package org.softeer_2nd.caArt.model.data

data class ResultChoiceOption(
    val optionTitle: String,
    val topOptionTitle: String,
    val topOptionImgUrl: String?,
    val topOptionPrice: Long?,
    val topOptionToolTipText: String = "",
    val bottomOptionTitle: String,
    val bottomOptionImgUrl: String?,
    val bottomOptionPrice: Long?,
    val bottomOptionToolTipText: String = ""
)