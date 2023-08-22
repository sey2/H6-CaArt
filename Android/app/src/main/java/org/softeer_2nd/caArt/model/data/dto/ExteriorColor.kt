package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.ChoiceColorItem

data class ExteriorColor(
    val colorId: Int,
    val colorName: String,
    val colorImage: String,
    val colorPrice: Long,
    val adoptionRate: Int,
    val previews: List<String>
)

fun List<ExteriorColor>.toChoiceColorItems(): List<ChoiceColorItem> {
    return this.map { exteriorColor ->
        ChoiceColorItem(
            "",
            exteriorColor.colorName,
            exteriorColor.colorPrice,
            imgUrl = exteriorColor.colorImage,
            true
        )
    }
}
