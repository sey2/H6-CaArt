package org.softeer_2nd.caArt.view.custom

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat

import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.util.dp2px

class SelectLongButton(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatCheckBox(context, attrs) {

    private val blueColorStateList = ContextCompat.getColorStateList(context, R.color.blue)
    private val whiteColorStateList = ContextCompat.getColorStateList(context, R.color.white)

    init {
        setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check_circle_16, 0, 0, 0)
        text = context.getString(R.string.choice)
        typeface = context.resources.getFont(R.font.hyundaisanstextkrmedium)
        background = ContextCompat.getDrawable(
            context,
            R.drawable.shape_option_check_long_btn_bakcground_180_blue
        )
        compoundDrawablePadding = 8f.dp2px(context)
        setPadding(10f.dp2px(context), 0f.dp2px(context), 14f.dp2px(context), 0f.dp2px(context))
        if (isChecked) applyCheckedStyle() else applyDefaultStyle()
        minWidth = 69f.dp2px(context)
    }

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        if (checked) applyCheckedStyle() else applyDefaultStyle()
    }

    private fun applyCheckedStyle() {
        TextViewCompat.setCompoundDrawableTintList(
            this,
            whiteColorStateList
        )
        backgroundTintList = blueColorStateList
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }

    private fun applyDefaultStyle() {
        TextViewCompat.setCompoundDrawableTintList(
            this,
            blueColorStateList
        )
        backgroundTintList = null
        setTextColor(ContextCompat.getColor(context, R.color.blue))
    }

}