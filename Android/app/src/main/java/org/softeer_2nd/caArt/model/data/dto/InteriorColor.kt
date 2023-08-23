package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.ChoiceColorItem

data class InteriorColor(
    val colorId: Int,
    val colorName: String,
    val colorImage: String,
    val colorPrice: Long,
    val adoptionRate: Int,
    val preview: String
)

fun List<InteriorColor>.toChoiceColorItems(): List<ChoiceColorItem> {
    return this.map { color ->
        ChoiceColorItem(
            "",
            color.colorName,
            color.colorPrice,
            imgUrl = color.colorImage
        )
    }
}
