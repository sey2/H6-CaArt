package org.softeer_2nd.caArt.model.data.dto

data class ColorData(
    val exteriorColors: List<ExteriorColor>,
    val otherTrimExteriorColors: List<OtherTrimColor>,
    val interiorColors: List<InteriorColor>,
    val otherTrimInteriorColors: List<OtherTrimColor>
)
