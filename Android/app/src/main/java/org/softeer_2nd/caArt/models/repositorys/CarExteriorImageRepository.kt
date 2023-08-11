package org.softeer_2nd.caArt.models.repositorys

import android.content.Context

class CarExteriorImageRepository(private val context: Context): ImageRepository {
    override fun getCarImages(): List<Int> {
        return List(60) { id ->
            context.resources.getIdentifier("image_0${id + 1}", "drawable", context.packageName)
        }
    }
}
