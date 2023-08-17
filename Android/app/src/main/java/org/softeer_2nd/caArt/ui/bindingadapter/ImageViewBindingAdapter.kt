package org.softeer_2nd.caArt.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.size.Scale

@BindingAdapter("url")
fun ImageView.setUrl(url: String?) {

    load(url) {
        scale(Scale.FILL)
    }
}

@BindingAdapter("app:tint")
fun ImageView.setTint(color: Int) {
    setColorFilter(color)
}