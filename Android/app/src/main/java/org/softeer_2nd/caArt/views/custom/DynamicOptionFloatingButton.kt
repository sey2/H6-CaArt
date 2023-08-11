package org.softeer_2nd.caArt.views.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.core.content.ContextCompat
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.models.datas.Option
import org.softeer_2nd.caArt.databinding.LayoutDynamicOptionFloatingTooltipBinding
import org.softeer_2nd.caArt.utils.dp2px

class DynamicOptionFloatingButton(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatCheckBox(context, attrs) {

    private val binding =
        LayoutDynamicOptionFloatingTooltipBinding.inflate(LayoutInflater.from(context), null, false)
    val popupWindow = PopupWindow(
        binding.root,
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT,
        true
    )
    private var option: Option? = null

    companion object {
        const val TOP = 0
        const val BOTTOM = 1
    }

    init {
        initFloatingButton()
        binding.ivOptionFloatingOptionImage.clipToOutline = true
    }

    fun setOption(option: Option) {
        this.option = option
        binding.option = option
        isEnabled = true
    }

    fun setOnMoreIconClickListener(listener: OnClickListener) {
        binding.onMoreIconClickListener = listener
    }

    private fun show() {
        val xOffset = width / 2 - popupWindow.contentView.measuredWidth / 2
        val yOffset = -5
        popupWindow.showAsDropDown(this, xOffset, yOffset)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val diameter = 28f.dp2px(context)
        val fixedWidth = MeasureSpec.makeMeasureSpec(diameter, MeasureSpec.EXACTLY)
        val fixedHeight = MeasureSpec.makeMeasureSpec(diameter, MeasureSpec.EXACTLY)
        super.onMeasure(fixedWidth, fixedHeight)
    }

    private fun initFloatingButton() {

        background = ContextCompat.getDrawable(
            context,
            R.drawable.selector_option_floating_handle_background
        )
        popupWindow.setOnDismissListener {
            isChecked = false
        }
        setOnClickListener {
            if (option != null) show()
        }
        buttonDrawable = null
        isEnabled = false
    }
}