package org.softeer_2nd.caArt.model.data

import com.google.gson.annotations.SerializedName

data class Option(
    val optionId: Int = 0,
    @SerializedName("description") private val unFormattedDescription: String? = null,
    val optionImage: String = "",
    val optionName: String = "-",
    val optionPrice: Long? = null,
    val position: Position? = null,
    val subOptions: List<Option>? = null,
    val summary: String? = null,
    val tags: List<String>? = null,
    val recommendationMessage: String? = null,
    val badge: String? = null,
    val adoptionRate: Int? = null,
) {

    val description: String?
        get() {
            return if (unFormattedDescription.isNullOrEmpty() || unFormattedDescription == "null") null
            else unFormattedDescription
        }

    override fun equals(other: Any?): Boolean {
        return if (other !is Option) false
        else optionId == other.optionId
    }

    override fun hashCode(): Int {
        return optionId
    }

}