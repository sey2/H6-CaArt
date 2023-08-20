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
