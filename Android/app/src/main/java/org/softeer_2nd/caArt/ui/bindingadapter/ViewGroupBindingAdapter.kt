package org.softeer_2nd.caArt.ui.bindingadapter

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.viewmodel.CarTrimChoiceViewModel

@SuppressLint("ClickableViewAccessibility")
@BindingAdapter("toolTipVisibility", "engineBodyOptionId", requireAll = true)
fun NestedScrollView.setTooltipVisibility(
    viewModel: CarTrimChoiceViewModel,
    engineBodyOptionId: Int,
) {
    val engineBodyOption = findViewById<View>(engineBodyOptionId)

    this.setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_DOWN && viewModel.isToolTipVisible.value == true) {
            val x = event.x.toInt()
            val y = event.y.toInt()
            viewModel.setIsToolTipVisible(isPointInsideView(x, y, engineBodyOption))
        }
        return@setOnTouchListener false
    }
}

private fun isPointInsideView(x: Int, y: Int, view: View): Boolean {
    val location = IntArray(2)
    view.getLocationOnScreen(location)
    val viewX = location[0]
    val viewY = location[1]
    return (x > viewX && x < viewX + view.width && y > viewY && y < viewY + view.height)
}

