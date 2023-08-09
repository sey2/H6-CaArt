package org.softeer_2nd.caArt.ui.custom

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat

import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.utils.dp2px

class SelectLongButton(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatCheckBox(context, attrs) {

    init {
        buttonDrawable = null
        setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check_circle_16, 0, 0, 0)
        text = context.getString(R.string.choice)
        typeface = context.resources.getFont(R.font.hyundaisanstextkrmedium)
        background = ContextCompat.getDrawable(
            context,
            R.drawable.shape_option_check_long_btn_bakcground_180_blue
        )
        compoundDrawablePadding = 8f.dp2px(context)
        setPadding(10f.dp2px(context), 0f.dp2px(context), 14f.dp2px(context), 0f.dp2px(context))
        buttonDrawable = null
        if (isChecked) setChecked() else setUnChecked()
        minWidth = 69f.dp2px(context)
    }

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        if (checked) setChecked() else setUnChecked()
    }

    private fun setChecked() {
        TextViewCompat.setCompoundDrawableTintList(
            this,
            ContextCompat.getColorStateList(context, R.color.white)
        )
        backgroundTintList = ContextCompat.getColorStateList(context, R.color.blue)
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }

    private fun setUnChecked() {
        TextViewCompat.setCompoundDrawableTintList(
            this,
            ContextCompat.getColorStateList(context, R.color.blue)
        )
        backgroundTintList = null
        setTextColor(ContextCompat.getColor(context, R.color.blue))
    }
}