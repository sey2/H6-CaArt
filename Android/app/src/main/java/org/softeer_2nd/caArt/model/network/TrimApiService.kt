package org.softeer_2nd.caArt.model.network

import org.softeer_2nd.caArt.model.data.Compositions
import org.softeer_2nd.caArt.model.data.Trim
import retrofit2.http.GET

interface TrimApiService {

    @GET("/trims")
    suspend fun getTrimList(): CaArtResponse<List<Trim>>

    @GET("/compositions")
    suspend fun getComposition(): CaArtResponse<Compositions>
}