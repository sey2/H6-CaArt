package org.softeer_2nd.caArt.model.network

import org.softeer_2nd.caArt.model.data.Option
import retrofit2.http.GET

interface OptionApiService {

    @GET("/options/basics")
    fun getOptionList(): CaArtResponse<List<Option>>
}