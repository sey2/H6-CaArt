package org.softeer_2nd.caArt.models.networks

data class CaArtResponse<T> (
    val success:Boolean,
    val statusCode:Int,
    val message:String,
    val data:T?
)