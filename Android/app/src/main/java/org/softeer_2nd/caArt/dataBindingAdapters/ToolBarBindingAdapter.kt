package org.softeer_2nd.caArt.dataBindingAdapters

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.R

class ToolBarBindingAdapter {
    @BindingAdapter("app:navigationIcon")
    fun Toolbar.setNavigationIcon(isHomeFragment: Boolean) {
        this.navigationIcon = if (isHomeFragment) {
            null
        } else {
            ContextCompat.getDrawable(context, R.drawable.ic_arrow_left_24)
        }
    }

    @BindingAdapter("android:backgroundTint")
    fun ImageView.setBackgroundTint(isHomeFragment: Boolean) {
        this.backgroundTintList = if (isHomeFragment) {
            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.white))
        } else {
            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
        }
    }
}