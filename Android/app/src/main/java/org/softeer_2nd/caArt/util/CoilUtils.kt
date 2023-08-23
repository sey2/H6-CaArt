package org.softeer_2nd.caArt.util

import coil.ImageLoader
import coil.request.CachePolicy
import coil.request.ImageRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.CaArtApplication

object CoilUtils {
    val imageLoader: ImageLoader by lazy {
        ImageLoader.Builder(CaArtApplication.getApplicationContext())
            .build()
    }

    fun preloadImages(urls: List<String>) {
        CoroutineScope(Dispatchers.IO).launch {
            urls.forEach { url ->
                val request = ImageRequest.Builder(CaArtApplication.getApplicationContext())
                    .data(url)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .build()
               imageLoader.enqueue(request)
            }
        }
    }
}
