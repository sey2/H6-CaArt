package org.softeer_2nd.caArt.model.data

import com.google.gson.annotations.SerializedName

data class Engine(
    @SerializedName("engineId") override val id: Int?=1,
    @SerializedName("engineName") override val itemName: String,
    @SerializedName("engineImage") override val imageUrl: String,
    @SerializedName("enginePrice") val enginePrice: Long,
    override val description: String,
    override val summary: String,
    override val maxPower: String,
    override val maxTorque: String,
) : TrimDescription