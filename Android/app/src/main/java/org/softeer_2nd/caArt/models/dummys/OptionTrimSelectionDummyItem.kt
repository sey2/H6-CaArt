package org.softeer_2nd.caArt.models.dummys

data class OptionTrimSelectionDummyItem(
    val model: String,
    val productKeyFeatures: String,
    val specifications: String,
    val price: String,
    val isLineVisibleGone: Boolean = false,
    var isChecked: Boolean = false,
)