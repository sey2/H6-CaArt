package org.softeer_2nd.caArt.views.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import org.softeer_2nd.caArt.R

class ExpandableView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    companion object {
        const val CONTRACT = 0
        const val EXPAND = 1
    }

    private var handleView: View? = null
    private var hiddenView: View? = null

    private var isExpanded = false

    private var iconImageView: ImageView? = null

    private var isRotateEffect = true

    private val rotateAnimation = RotateAnimation(
        0f,
        -180f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f
    ).apply {
        duration = 500
        fillAfter = true
    }

    private val rotateReverseAnimation = RotateAnimation(
        -180f,
        0f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f
    ).apply {
        duration = 500
        fillAfter = true
    }

    private val container = LinearLayout(context).apply {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        orientation = HORIZONTAL
    }

    init {
        orientation = VERTICAL

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ExpandableView,
            0, 0
        ).apply {
            try {
                val iconTint = getResourceId(R.styleable.ExpandableView_rotateIconTint, 0)
                val iconRes = getResourceId(R.styleable.ExpandableView_rotateIcon, 0)
                isRotateEffect = getBoolean(R.styleable.ExpandableView_isRotateEffect, true)
                if (iconRes != 0) {
                    iconImageView = ImageView(context).apply {
                        setImageResource(iconRes)
                        if (iconTint != 0) setColorFilter(ContextCompat.getColor(context, iconTint))
                        layoutParams =
                            LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                    }
                }
                isExpanded = getInt(R.styleable.ExpandableView_initialState, CONTRACT) == EXPAND
            } finally {
                recycle()
            }
        }

        setOnClickListener {
            isExpanded = !isExpanded
            if (isExpanded) setExpand() else setContract()
        }

    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        if (childCount < 2) {
            throw IllegalStateException("ExpandableView always need 2 children. now childCount is $childCount")
        }
        if (iconImageView == null && childCount > 2) {
            throw IllegalStateException("ExpandableView can host only 2 children")
        }

        handleView = getChildAt(0)
        hiddenView = getChildAt(1)?.apply {
            visibility = if (isExpanded) View.VISIBLE else View.GONE
        }

        if (iconImageView != null) {
            removeAllViews()
            addView(container)
            handleView?.layoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT).apply {
                weight = 1f
            }
            container.addView(handleView)
            container.addView(iconImageView)
            addView(hiddenView)
        }
    }

    private fun setContract() {
        if (isRotateEffect) iconImageView?.startAnimation(rotateReverseAnimation)
        hiddenView?.visibility = View.GONE
    }

    private fun setExpand() {
        if (isRotateEffect) iconImageView?.startAnimation(rotateAnimation)
        hiddenView?.visibility = View.VISIBLE
    }
}
