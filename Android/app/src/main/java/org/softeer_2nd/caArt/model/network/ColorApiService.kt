package org.softeer_2nd.caArt.model.network

import org.softeer_2nd.caArt.model.data.dto.ColorData
import retrofit2.http.GET
import retrofit2.http.Query

interface ColorApiService {
    @GET("/colors")
    suspend fun getColorList(@Query("trimId") trimId: Int): CaArtResponse<ColorData>

}