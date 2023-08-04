package org.softeer_2nd.caArt.dataBindingAdapters

import android.view.View
import androidx.databinding.BindingAdapter

object BottomSheetBindingAdapter {
    @BindingAdapter("isVisible")
    fun View.isVisible(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}