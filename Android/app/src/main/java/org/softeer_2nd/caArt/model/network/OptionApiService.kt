package org.softeer_2nd.caArt.model.network

import org.softeer_2nd.caArt.model.data.AdditionalOptionResponseDTO
import org.softeer_2nd.caArt.model.data.DefaultOptionResponseDTO
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.OptionTag
import retrofit2.http.GET
import retrofit2.http.Query

interface OptionApiService {

    @GET("/tags")
    suspend fun getOptionTagList(): CaArtResponse<List<OptionTag>>

    @GET("/options/additional/list")
    suspend fun getAdditionalOptionList(
        @Query("tagId") tagId: Int? = null,
        @Query("trimId") trimId: Int,
        @Query("engineId") engineId: Int,
        @Query("bodyTypeId") bodyTypeId: Int,
        @Query("wdId") wheelDriveID: Int,
        @Query("offset") offset: Int = 0,
        @Query("pageSize") pageSize: Int = 8
    ): CaArtResponse<AdditionalOptionResponseDTO>

    @GET("/options/basic/list")
    suspend fun getDefaultOptionList(
        @Query("tagId") tagId: Int? = null,
        @Query("trimId") trimId: Int,
        @Query("engineId") engineId: Int,
        @Query("bodyTypeId") bodyTypeId: Int,
        @Query("wdId") wheelDriveID: Int,
        @Query("offset") offset: Int = 0,
        @Query("pageSize") pageSize: Int = 8
    ): CaArtResponse<DefaultOptionResponseDTO>

}