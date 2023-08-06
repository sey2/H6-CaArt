package org.softeer_2nd.caArt.dataBindingAdapters

import android.util.TypedValue
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.R

@BindingAdapter("detailIndicatorSelected")
fun setSelectedDetailIndicatorStyle(textView: TextView, selected: Boolean) {
    val styleId =
        if (selected) R.style.SelectedDetailIndicatorTextStyle else R.style.DetailIndicatorTextStyle
    textView.setTextAppearance(styleId)
}

@BindingAdapter("android:textSize")
fun TextView.setTextSizeWithFloat(size:Float){
    this.setTextSize(TypedValue.COMPLEX_UNIT_SP,size)
}
