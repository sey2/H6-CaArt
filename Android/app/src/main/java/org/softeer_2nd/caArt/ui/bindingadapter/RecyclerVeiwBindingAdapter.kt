package org.softeer_2nd.caArt.ui.bindingadapter

import android.graphics.Rect
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.util.dp2px

@BindingAdapter(
    "itemMargin",
    "itemMarginStart",
    "itemMarginTop",
    "itemMarginEnd",
    "itemMarginBottom",
    requireAll = false
)
fun RecyclerView.setRecyclerItemMargin(
    itemMargin: Float? = null,
    itemMarginStart: Float? = null,
    itemMarginTop: Float? = null,
    itemMarginEnd: Float? = null,
    itemMarginBottom: Float? = null,
) {
    val margin = itemMargin?.dp2px(context)
    val marginStart = itemMarginStart?.dp2px(context)
    val marginTop = itemMarginTop?.dp2px(context)
    val marginEnd = itemMarginEnd?.dp2px(context)
    val marginBottom = itemMarginBottom?.dp2px(context)
    addItemDecoration(object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            margin?.let {
                outRect.left = margin
                outRect.top = margin
                outRect.right = margin
                outRect.bottom = margin
            }
            marginStart?.let { outRect.left = it }
            marginTop?.let { outRect.top = it }
            marginEnd?.let { outRect.right = it }
            marginBottom?.let { outRect.bottom = it }
        }
    })
}