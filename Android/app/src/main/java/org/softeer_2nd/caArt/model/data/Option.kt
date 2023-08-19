package org.softeer_2nd.caArt.model.data

data class Option(
    val description: String,
    val optionId: Int,
    val optionImage: String,
    val optionName: String,
    val optionPrice: Long? = null,
    val position: Position? = null,
    val subOptions: List<Option>? = null,
    val summary: String? = null,
    val tags: List<String>? = null
)