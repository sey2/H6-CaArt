package org.softeer_2nd.caArt.model.dummy

data class TrimDescriptionDummyItem(
    val handleText: String,
    val subText: String,
    val imgUrl: String,
    val description: String,
    val maxPower: String? = null,
    val maxTorque: String? = null
)