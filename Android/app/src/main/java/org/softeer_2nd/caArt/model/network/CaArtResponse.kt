package org.softeer_2nd.caArt.model.network

import org.softeer_2nd.caArt.model.data.Trim

data class CaArtResponse<T> (
    val success:Boolean,
    val statusCode:Int,
    val message:String,
    val data:T?
)

data class TrimList(
    val trims:List<Trim>
)