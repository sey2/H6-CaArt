package org.softeer_2nd.caArt.model.repository

import org.softeer_2nd.caArt.model.data.dto.ColorData
import org.softeer_2nd.caArt.model.network.ColorApiService
import org.softeer_2nd.caArt.util.ImageUtils
import javax.inject.Inject

class CarColorImageRepository @Inject constructor(private val service: ColorApiService) :
    BaseNetworkRepository() {

    suspend fun fetchColorList(trimId: Int): ColorData {
        return safeApiCall { service.getColorList(trimId) }.data!!
    }

    fun preloadExteriorImages(urls: List<String>?, onImageLoaded: (Int) -> Unit) {
        urls?.let { ImageUtils.preloadImages(it, onImageLoaded) }
    }
}
