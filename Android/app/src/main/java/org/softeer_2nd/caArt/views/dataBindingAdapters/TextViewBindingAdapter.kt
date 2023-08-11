package org.softeer_2nd.caArt.views.dataBindingAdapters

import android.util.TypedValue
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.R
import java.text.NumberFormat
import java.util.Locale

@BindingAdapter("detailIndicatorSelected")
fun setSelectedDetailIndicatorStyle(textView: TextView, selected: Boolean) {
    val styleId =
        if (selected) R.style.SelectedDetailIndicatorTextStyle else R.style.DetailIndicatorTextStyle
    textView.setTextAppearance(styleId)
}

@BindingAdapter("android:textSize")
fun TextView.setTextSizeWithFloat(size: Float) {
    this.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
}

@BindingAdapter("formattedPrice")
fun TextView.setFormattedPrice(price: Int) {
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
    val formattedPrice = formatter.format(price)
    text = context.getString(R.string.formatted_price, formattedPrice)
}
