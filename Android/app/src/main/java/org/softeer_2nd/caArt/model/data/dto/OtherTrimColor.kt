package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.ChoiceColorItem

data class OtherTrimColor(
    val colorId: Int,
    val colorName: String,
    val colorImage: String,
    val trimId: Int,
    val trimName: String,
    val trimPrice: Int
)

fun List<OtherTrimColor>.toChoiceColorItems(): List<ChoiceColorItem> {
    return this.map { otherTrimColor ->
        ChoiceColorItem(
            tag = otherTrimColor.colorName,
            imgUrl = otherTrimColor.colorImage
        )
    }
}