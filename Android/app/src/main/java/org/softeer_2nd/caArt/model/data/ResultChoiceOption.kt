package org.softeer_2nd.caArt.model.data

data class ResultChoiceOption(
    val optionTitle: String,
    val topOptionTitle: String,
    val topOptionImgUrl: String,
    val topOptionPrice: String,
    val topOptionToolTipText: String = "",
    val bottomOptionTitle: String,
    val bottomOptionImgUrl: String,
    val bottomOptionPrice: String,
    val bottomOptionToolTipText: String = ""
)