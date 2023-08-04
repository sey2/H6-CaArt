package org.softeer_2nd.caArt.dataBindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.R

object TextViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("detailIndicatorSelected")
    fun setSelectedDetailIndicatorStyle(textView: TextView, selected: Boolean) {
        val styleId =
            if (selected) R.style.SelectedDetailIndicatorTextViewStyle else R.style.DetailIndicatorTextViewStyle
        textView.setTextAppearance(styleId)
    }
}
