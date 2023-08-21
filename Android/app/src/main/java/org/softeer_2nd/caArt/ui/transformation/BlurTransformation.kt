package org.softeer_2nd.caArt.ui.transformation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Paint
import androidx.core.graphics.applyCanvas
import androidx.core.graphics.createBitmap
import coil.size.Size
import coil.transform.Transformation
import com.google.android.renderscript.Toolkit

class BlurTransformation @JvmOverloads constructor(
    private val context: Context,
    radius: Int? = DEFAULT_RADIUS,
    sampling: Float? = DEFAULT_SAMPLING
) : Transformation {

    private val radius: Int
    private val sampling: Float

    init {
        this.radius = radius ?: DEFAULT_RADIUS
        this.sampling = sampling ?: DEFAULT_SAMPLING
        require(this.radius in 0..25) { "radius must be in [0, 25]." }
        require(this.sampling > 0) { "sampling must be > 0." }
    }

    override val cacheKey = "${BlurTransformation::class.java.name}-$radius-$sampling"

    override suspend fun transform(input: Bitmap, size: Size): Bitmap {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)

        val scaledWidth = (input.width / sampling).toInt()
        val scaledHeight = (input.height / sampling).toInt()
        val output = createBitmap(scaledWidth, scaledHeight)
        output.applyCanvas {
            scale(1 / sampling, 1 / sampling)
            drawBitmap(input, 0f, 0f, paint)
        }

        return Toolkit.blur(output, radius)
    }

    private companion object {
        private const val DEFAULT_RADIUS = 5
        private const val DEFAULT_SAMPLING = 1f
    }
}