package org.softeer_2nd.caArt.view.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun ImageView.setImageSrcWithUrl(url: String?) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .into(this)
}