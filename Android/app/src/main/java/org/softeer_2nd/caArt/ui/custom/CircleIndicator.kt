package org.softeer_2nd.caArt.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.utils.dp2px
import kotlin.math.max

class CircleIndicator(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var dotCount: Int
    private var defaultDotRadius: Float
    private var selectedDotRadius: Float
    private var selectedDotIndex: Int = 0
    private var dotPadding: Int

    private var defaultDotPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.gray_700)
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private var selectedDotPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.active_blue)
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CircleIndicator,
            0, 0
        ).apply {
            try {
                dotCount = getInt(R.styleable.CircleIndicator_dotCount, 5)
                defaultDotRadius = getFloat(R.styleable.CircleIndicator_defaultDotRadius, 8f)
                selectedDotRadius = getFloat(R.styleable.CircleIndicator_selectedDotRadius, 10f)
                dotPadding = getFloat(R.styleable.CircleIndicator_dotPadding, 8f).dp2px(context)
                val initialSelectedIndex = getInt(R.styleable.CircleIndicator_selectedDotIndex, 0)

                if (initialSelectedIndex in 0 until dotCount - 1) selectedDotIndex =
                    initialSelectedIndex
                val defaultColorRes =
                    getResourceId(R.styleable.CircleIndicator_defaultDotColor, R.color.gray_700)
                val selectedColorRes =
                    getResourceId(R.styleable.CircleIndicator_selectedDotColor, R.color.active_blue)

                defaultDotPaint = Paint().apply {
                    color = ContextCompat.getColor(context, defaultColorRes)
                    style = Paint.Style.FILL
                    isAntiAlias = true
                }

                selectedDotPaint = Paint().apply {
                    color = ContextCompat.getColor(context, selectedColorRes)
                    style = Paint.Style.FILL
                    isAntiAlias = true
                }
            } finally {
                recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val defaultRadiusPx = defaultDotRadius.dp2px(context)
        val selectedRadiusPx = selectedDotRadius.dp2px(context)
        val desiredHeight = max(selectedRadiusPx, defaultRadiusPx) * 2
        val desiredWidth =
            dotPadding * (dotCount - 1) + defaultDotRadius.toInt() * 2 * (dotCount - 1) + selectedDotRadius.toInt() * 2

        val width = resolveSize(desiredWidth, widthMeasureSpec)
        val height = resolveSize(desiredHeight, heightMeasureSpec)

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val centerY = height / 2f
        for (index in 0 until dotCount) {
            var offset = dotPadding * index + 2 * (defaultDotRadius * (index - 1))
            offset += if (index > selectedDotIndex) selectedDotRadius * 2
            else defaultDotRadius * 2
            if (index == selectedDotIndex) canvas?.drawCircle(
                offset + selectedDotRadius,
                centerY,
                selectedDotRadius,
                selectedDotPaint
            )
            else canvas?.drawCircle(
                offset + defaultDotRadius,
                centerY,
                defaultDotRadius,
                defaultDotPaint
            )
        }
    }

    fun setSelectedDotIndex(index: Int) {
        if (index !in 0 until 5) return
        selectedDotIndex = index
        requestLayout()
    }

    fun setDotCount(count: Int) {
        dotCount = count
        invalidate()
    }

}