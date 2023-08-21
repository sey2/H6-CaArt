package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.ChoiceColorItem

data class InteriorColor(
    val colorId: Int,
    val colorName: String,
    val colorImage: String,
    val colorPrice: Int,
    val adoptionRate: Int,
    val preview: String
)

fun List<InteriorColor>.toChoiceColorItems(): List<ChoiceColorItem> {
    return this.map { color ->
        ChoiceColorItem(imgUrl = color.colorImage)
    }
}
