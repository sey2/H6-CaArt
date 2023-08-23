package org.softeer_2nd.caArt.ui.bindingadapter

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import org.softeer_2nd.caArt.util.dp2px
import org.softeer_2nd.caArt.viewmodel.CarColorChoiceViewModel


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

@BindingAdapter("android:layout_marginTop")
fun View.setMarginTop(marginTop: Float) {
    val lp = layoutParams as? ViewGroup.MarginLayoutParams
    lp?.topMargin = marginTop.dp2px(context)
    layoutParams = lp
}

@BindingAdapter("layout_minus_marginTop")
fun View.setMinusMarginTop(marginTop: Float) {
    val lp = layoutParams as? ViewGroup.MarginLayoutParams
    lp?.topMargin = -(marginTop.dp2px(context))
    layoutParams = lp
}

@BindingAdapter("android:layout_marginBottom")
fun View.setMarginBottom(marginBottom: Float) {
    val lp = layoutParams as? ViewGroup.MarginLayoutParams
    lp?.bottomMargin = marginBottom.dp2px(context)
    layoutParams = lp
}

@BindingAdapter("layout_minus_marginBottom")
fun View.setMinusMarginBottom(marginBottom: Float) {
    val lp = layoutParams as? ViewGroup.MarginLayoutParams
    lp?.bottomMargin = -(marginBottom.dp2px(context))
    layoutParams = lp
}

@BindingAdapter("android:layout_gravity")
fun View.setLayoutGravity(gravity: Int) {
    val lp = layoutParams as? FrameLayout.LayoutParams
    lp?.gravity = gravity
}

@BindingAdapter("marginTopConditionally")
fun View.setMarginTopConditionally(isOtherColor: Boolean) {
    val layoutParams = layoutParams as ViewGroup.MarginLayoutParams
    if (isOtherColor) {
        layoutParams.topMargin = 28f.dp2px(context)
    } else {
        layoutParams.topMargin = 0
    }
    this.layoutParams = layoutParams
}

@SuppressLint("ClickableViewAccessibility")
@BindingAdapter("onTouch", "spinActive")
fun View.setOnTouchListener(
    viewModel: CarColorChoiceViewModel?,
    spinActive: LiveData<Boolean>?
) {
    val downX = Array(1) { 0f }

    if (spinActive?.value == false) return

    setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX[0] = event.x
                true
            }

            MotionEvent.ACTION_MOVE -> {
                val distance = downX[0] - event.x
                val threshold = width / 60.0f

                if (distance > threshold) {
                    viewModel?.updateIndex((viewModel.spinCarImageIndex.value ?: 0) + 1)
                    downX[0] = event.x
                } else if (distance < -threshold) {
                    viewModel?.updateIndex((viewModel.spinCarImageIndex.value ?: 0) - 1)
                    downX[0] = event.x
                }
                true
            }

            else -> false
        }
    }
}

@BindingAdapter("marginTop", "trueMargin", "falseMargin", requireAll = false)
fun View.setDynamicMarginTop(condition: Boolean, trueMarginDp: Float?, falseMarginDp: Float?) {
    val layoutParams = layoutParams as? ViewGroup.MarginLayoutParams ?: return

    val marginValue = if (condition) {
        trueMarginDp ?: 0f
    } else {
        falseMarginDp ?: 0f
    }

    layoutParams.topMargin = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        marginValue,
        resources.displayMetrics
    ).toInt()
}
