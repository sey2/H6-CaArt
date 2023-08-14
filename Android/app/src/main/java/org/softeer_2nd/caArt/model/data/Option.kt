package org.softeer_2nd.caArt.model.data

data class Option(
    val name: String,
    val group: String? = null,
    val price: Int,
    val description: String,
    val isDefaultOption: Boolean,
    val url: String,
    val subOption: List<Option>? = null
)
