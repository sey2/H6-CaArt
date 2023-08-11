package org.softeer_2nd.caArt.retrofit

data class CaArtResponse<T> (
    val success:Boolean,
    val statusCode:Int,
    val message:String,
    val data:T?
)