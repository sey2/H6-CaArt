package org.softeer_2nd.caArt.util

import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.CaArtApplication
import java.util.concurrent.atomic.AtomicInteger

object ImageUtils {
    val imageLoader: ImageLoader by lazy {
        ImageLoader.Builder(CaArtApplication.getApplicationContext())
            .memoryCache {
                MemoryCache.Builder(CaArtApplication.getApplicationContext())
                    .maxSizePercent(0.5)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(CaArtApplication.getApplicationContext().cacheDir.resolve("org_caArt"))
                    .maxSizePercent(0.5)
                    .build()
            }
            .build()
    }

    fun preloadImages(urls: List<String>, onImageLoaded: (Int) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val successfulLoads: AtomicInteger = AtomicInteger(0)

            urls.forEachIndexed { index, url ->
                val request = ImageRequest.Builder(CaArtApplication.getApplicationContext())
                    .data(url)
                    .build()

                val result = imageLoader.execute(request)
                if (result is SuccessResult) {
                    successfulLoads.incrementAndGet()
                }

                val loadProgress = (successfulLoads.get().toFloat() / urls.size * 100).toInt()

                onImageLoaded(loadProgress)
            }
        }
    }
}
