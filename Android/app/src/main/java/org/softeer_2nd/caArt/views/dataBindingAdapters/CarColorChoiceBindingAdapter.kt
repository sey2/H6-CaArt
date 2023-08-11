package org.softeer_2nd.caArt.views.dataBindingAdapters

import android.annotation.SuppressLint
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.viewmodels.CarColorChoiceViewModel

@SuppressLint("ClickableViewAccessibility")
@BindingAdapter("onTouch", "images", "spinActive")
fun View.setOnTouchListener(
    viewModel: CarColorChoiceViewModel?,
    images: LiveData<List<Int>>?,
    spinActive: LiveData<Boolean>?
) {
    var downX = 0f
    setOnTouchListener { v, event ->
        spinActive?.value?.let { isSpinActive ->
            images?.value?.let { imageList ->
                viewModel?.let { vm ->
                    if (isSpinActive) {
                        when (event.action) {
                            MotionEvent.ACTION_DOWN -> {
                                downX = event.x
                                true
                            }

                            MotionEvent.ACTION_MOVE -> {
                                downX = handleActionMove(v, event.x, downX, imageList.size, vm)
                                true
                            }

                            else -> false
                        }
                    } else false
                }
            }
        } ?: false
    }
}

private fun handleActionMove(
    view: View,
    moveX: Float,
    downX: Float,
    imageSize: Int,
    viewModel: CarColorChoiceViewModel
): Float {
    val distance = downX - moveX
    val moveIndex = (distance / view.width * imageSize).toInt()

    viewModel.updateIndex(
        (((viewModel.spinCarImageIndex.value ?: 0) + moveIndex + imageSize) % imageSize)
    )

    return moveX
}

@BindingAdapter("spanColorText")
fun setSpanColorText(textView: TextView, text: String?) {
    text?.let {
        val spannable = SpannableString(it)
        val color = textView.context.resources.getColor(R.color.active_blue, textView.context.theme)
        spannable.setSpan(
            ForegroundColorSpan(color),
            0,
            3,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannable
    }
}

