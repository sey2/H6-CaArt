package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.ChoiceColorItem

data class OtherTrimColor(
    val colorId: Int,
    val colorName: String,
    val colorImage: String,
    val trimId: Int,
    val trimName: String,
    val trimPrice: Long,
    val preview: String
)

fun List<OtherTrimColor>.toChoiceColorItems(): List<ChoiceColorItem> {
    return this.map { otherTrimColor ->
        ChoiceColorItem(
            tag = otherTrimColor.trimName,
            colorName = otherTrimColor.colorName,
            trimPrice = otherTrimColor.trimPrice,
            imgUrl = otherTrimColor.colorImage,
            trimName = otherTrimColor.trimName,
            trimId = otherTrimColor.trimId,
            preview = otherTrimColor.preview
        )
    }
}