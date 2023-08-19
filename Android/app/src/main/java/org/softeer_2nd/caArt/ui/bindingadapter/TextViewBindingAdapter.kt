package org.softeer_2nd.caArt.ui.bindingadapter

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
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
fun TextView.setFormattedPrice(price: Long) {
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
    val formattedPrice = formatter.format(price)
    text = context.getString(R.string.formatted_price, formattedPrice)
}

@BindingAdapter(value = ["highlightText", "highlightColor", "highlightSpSize"], requireAll = false)
fun TextView.setHighlightText(
    targetString: String?,
    highlightColor: Int? = null,
    highlightSpSize: Int? = null
) {
    if (targetString == null) return

    val spannableString = SpannableStringBuilder(text)
    val start = text.indexOf(targetString)
    val end = start + targetString.length

    targetString.let {
        spannableString.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    highlightColor?.let {
        spannableString.setSpan(ForegroundColorSpan(highlightColor), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    highlightSpSize?.let {
        spannableString.setSpan(AbsoluteSizeSpan(it, true), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    this.text = spannableString
}

@BindingAdapter("underlineText")
fun TextView.setUnderlineText(text: String?) {
    text?.let {
        val spannableString = SpannableString(it)
        spannableString.setSpan(UnderlineSpan(), 0, it.length, 0)
        this.text = spannableString
    }
}

@BindingAdapter("spanColorText")
fun TextView.setSpanColorText(text: String?) {
    text?.let {
        val spannable = SpannableString(it)
        val color = context.resources.getColor(R.color.active_blue, context.theme)
        spannable.setSpan(
            ForegroundColorSpan(color),
            0,
            3,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        this.text = spannable
    }
}
