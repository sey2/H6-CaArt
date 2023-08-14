package org.softeer_2nd.caArt.model.network

import retrofit2.http.GET

interface TrimApiService {

    @GET("/trims")
    suspend fun getTrimList(): CaArtResponse<TrimList>//Call<CaArtResponse<List<Trim>>>
}