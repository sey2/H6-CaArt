package org.softeer_2nd.caArt.model.data
data class ChoiceColorItem(
    val tag: String = "",
    val colorName: String,
    val colorPrice: Long,
    val imgUrl: String = "",
    val isExteriorColor: Boolean,
    val trimName: String = "",
)