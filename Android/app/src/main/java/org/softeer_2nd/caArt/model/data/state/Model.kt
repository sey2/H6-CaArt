package org.softeer_2nd.caArt.model.data.state

import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.data.WheelDrive

data class Model(
    val bodyType: BodyType,
    val engine: Engine,
    val modelName: String,
    val modelPrice: Int,
    val trim: Trim,
    val wheelDrive: WheelDrive
)