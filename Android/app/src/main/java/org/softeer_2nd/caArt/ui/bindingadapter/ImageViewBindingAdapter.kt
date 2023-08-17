package org.softeer_2nd.caArt.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


@BindingAdapter("url")
fun ImageView.setImageSrcWithUrl(url: String?) {
    load(url){
        scale(coil.size.Scale.FILL)
    }
}

@BindingAdapter("app:tint")
fun ImageView.setTint(color: Int) {
    setColorFilter(color)
}