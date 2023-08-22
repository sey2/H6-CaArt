package org.softeer_2nd.caArt.model.data

import com.google.gson.annotations.SerializedName
import org.softeer_2nd.caArt.model.data.dto.ExteriorColor
import org.softeer_2nd.caArt.model.data.dto.InteriorColor

data class ChoiceColorItem(
    val tag: String = "",
    val colorName: String,
    val colorPrice: Long,
    @SerializedName("colorImage") val imgUrl: String = "",
    @SerializedName("isExterior") val isExteriorColor: Boolean,
    val trimName: String = "",
) {
    companion object {
        fun ChoiceColorItem.toExteriorColor(): ExteriorColor =
            ExteriorColor(0, colorName, imgUrl, colorPrice, 0, emptyList())

        fun ChoiceColorItem.toInteriorColor(): InteriorColor =
            InteriorColor(0, colorName, imgUrl, colorPrice, 0, "")
    }
}