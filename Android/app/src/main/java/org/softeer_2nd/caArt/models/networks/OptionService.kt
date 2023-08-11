package org.softeer_2nd.caArt.models.networks

import org.softeer_2nd.caArt.models.datas.Option
import retrofit2.http.GET

interface OptionService {

    @GET("/options/basics")
    fun getOptionList(): CaArtResponse<List<Option>>
}