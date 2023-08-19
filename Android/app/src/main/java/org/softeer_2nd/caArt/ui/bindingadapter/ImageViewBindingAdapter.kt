package org.softeer_2nd.caArt.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import org.softeer_2nd.caArt.ui.custom.DynamicOptionFloatingImageView


@BindingAdapter("url")
fun ImageView.setImageSrcWithUrl(url: String?) {
    load(url) {
        scale(coil.size.Scale.FILL)
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
