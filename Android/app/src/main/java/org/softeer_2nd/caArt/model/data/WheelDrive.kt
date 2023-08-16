package org.softeer_2nd.caArt.model.data

import com.google.gson.annotations.SerializedName

data class WheelDrive(
    @SerializedName("wheelDriveName") override val itemName: String,
    @SerializedName("wheelDriveImage") override val imageUrl: String,
    @SerializedName("wheelDrivePrice") val wheelDrivePrice: Int,
    override val description: String,
    override val summary: String
) : TrimDescription {
    override val maxPower: String? get() = null
    override val maxTorque: String? get() = null
}