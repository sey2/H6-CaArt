package org.softeer_2nd.caArt.model.data

import com.google.gson.annotations.SerializedName

data class BodyType(
    @SerializedName("bodyTypeName") override val itemName: String,
    @SerializedName("bodyTypeImage") override val imageUrl: String,
    override val description: String,
    override val summary: String,
    @SerializedName("bodyTypePrice") val bodyTypePrice: Long? = null,
) : TrimDescription {
    override val maxPower: String? get() = null
    override val maxTorque: String? get() = null
}