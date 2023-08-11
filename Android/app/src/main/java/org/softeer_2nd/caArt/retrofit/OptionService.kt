package org.softeer_2nd.caArt.retrofit

import org.softeer_2nd.caArt.dataClasses.Option
import retrofit2.Response
import retrofit2.http.GET

interface OptionService {

    @GET("/options/basics")
    fun getOptionList():CaArtResponse<List<Option>>
}