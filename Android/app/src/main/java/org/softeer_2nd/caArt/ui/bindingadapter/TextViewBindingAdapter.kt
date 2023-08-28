package org.softeer_2nd.caArt.ui.bindingadapter

import android.animation.ValueAnimator
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.util.TypedValue
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.util.StringFormatter.setFormattedPrice
import org.softeer_2nd.caArt.util.StringFormatter.toIntOrNullWithComma
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
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    highlightColor?.let {
        spannableString.setSpan(
            ForegroundColorSpan(highlightColor),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    highlightSpSize?.let {
        spannableString.setSpan(
            AbsoluteSizeSpan(it, true),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
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

@BindingAdapter("spanPercentage", "spanText")
fun TextView.setSpanColorText(percentage: Int?, text: String?) {
    if (percentage != null && text != null) {
        val fullText = "$percentage$text"
        val spannable = SpannableString(fullText)
        val color = context.resources.getColor(R.color.active_blue, context.theme)

        spannable.setSpan(
            ForegroundColorSpan(color),
            0,
            percentage.toString().length + 1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        this.text = spannable
    }
}

fun TextView.animatePriceChange(newPrice: Long?) {
    val oldPrice = text.toString().toIntOrNullWithComma()
    val targetPrice = newPrice?.toInt() ?: 0
    val valueAnimator = ValueAnimator.ofInt(oldPrice ?: 0, targetPrice)
    valueAnimator.duration = 1000
    valueAnimator.addUpdateListener { animator ->
        text = "${animator.animatedValue}".setFormattedPrice().trim()
    }
    valueAnimator.start()
}