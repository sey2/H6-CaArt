package org.softeer_2nd.caArt.model.dummy

data class OptionTrimSelectionDummyItem(
    val model: String,
    val productKeyFeatures: String,
    val specifications: String,
    val price: String,
    val isLineVisibleGone: Boolean = false,
    var isChecked: Boolean = false,
)