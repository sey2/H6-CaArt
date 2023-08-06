package org.softeer_2nd.caArt.dataBindingAdapters

import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.utils.dp2px


@BindingAdapter("android:layout_marginEnd")
fun View.setMarginEnd(marginEnd: Float) {
    val lp = layoutParams as? ViewGroup.MarginLayoutParams
    lp?.marginEnd = marginEnd.dp2px(context)
    layoutParams = lp
}

@BindingAdapter("android:layout_marginStart")
fun View.setMarginStart(marginStart: Float) {
    val lp = layoutParams as? ViewGroup.MarginLayoutParams
    lp?.marginStart = marginStart.dp2px(context)
    layoutParams = lp
}
