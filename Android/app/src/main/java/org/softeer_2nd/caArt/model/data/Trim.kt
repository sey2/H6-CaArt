package org.softeer_2nd.caArt.model.data

data class Trim(
    val description: String,
    val exteriorColors: List<Any>,
    val interiorColors: List<Any>,
    val mainOptions: List<Any>,
    val trimImage: String,
    val trimName: String,
    val trimPrice: Int
)