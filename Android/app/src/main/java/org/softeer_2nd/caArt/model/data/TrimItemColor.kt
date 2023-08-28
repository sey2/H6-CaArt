package org.softeer_2nd.caArt.model.data

import org.softeer_2nd.caArt.model.data.dto.ExteriorColor
import org.softeer_2nd.caArt.model.data.dto.InteriorColor

data class TrimItemColor(
    val colorId: Int,
    val colorName: String,
    val colorPrice: Long,
    val colorImage: String
)

fun TrimItemColor.toExteriorColor(): ExteriorColor {
    return ExteriorColor(colorId, colorName, colorImage, colorPrice, 60, listOf())
}

fun TrimItemColor.toInteriorColor(): InteriorColor {
    return InteriorColor(colorId, colorName, colorImage, colorPrice, 60, "")
}
