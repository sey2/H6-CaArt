package org.softeer_2nd.caArt.view.bindingAdapter

import android.widget.ImageView
import androidx.core.content.ContextCompat
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