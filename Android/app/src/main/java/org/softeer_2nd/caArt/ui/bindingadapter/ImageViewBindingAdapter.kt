package org.softeer_2nd.caArt.ui.bindingadapter

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.decode.SvgDecoder
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import org.softeer_2nd.caArt.ui.custom.DynamicOptionFloatingImageView
import org.softeer_2nd.caArt.ui.transformation.BlurTransformation
import org.softeer_2nd.caArt.util.CoilUtils
import org.softeer_2nd.caArt.util.dp2px


@BindingAdapter("url", "circleCrop", "radius", "blurRadius", "blurSampling", requireAll = false)
fun ImageView.setImageSrcWithUrl(
    url: String?,
    isCircleCrop: Boolean = false,
    radius: Float? = null,
    blurRadius: Int? = null,
    blurSampling: Float? = null
) {

    load(url, CoilUtils.imageLoader) {
        Log.d("test","$url")
        scale(coil.size.Scale.FILL)
        if (isCircleCrop) transformations(CircleCropTransformation())
        if (blurRadius != null || blurSampling != null) {
            transformations(BlurTransformation(context, blurRadius, blurSampling))
        }

        radius?.let {
            transformations(
                RoundedCornersTransformation(
                    radius.dp2px(context).toFloat()
                )
            )
        }
    }
}

@BindingAdapter("svgUrl")
fun ImageView.setImageSrcWithSvgUrl(svgUrl: String?) {
    load(svgUrl) {

        decoderFactory { result, options, _ ->
            SvgDecoder(result.source, options)
        }
        size(24f.dp2px(context), 24f.dp2px(context))
    }
}

@BindingAdapter("app:tint")
fun ImageView.setTint(color: Int) {
    setColorFilter(color)
}

@BindingAdapter("url")
fun DynamicOptionFloatingImageView.setImageSrcWithUrl(url: String?) {
    setImage(url)
}
