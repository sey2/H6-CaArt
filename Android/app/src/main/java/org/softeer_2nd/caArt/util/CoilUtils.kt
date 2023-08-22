package org.softeer_2nd.caArt.util

import coil.ImageLoader
import org.softeer_2nd.caArt.CaArtApplication

object CoilUtils {
    val imageLoader: ImageLoader by lazy {
        ImageLoader.Builder(CaArtApplication.getApplicationContext())
            .build()
    }
}
