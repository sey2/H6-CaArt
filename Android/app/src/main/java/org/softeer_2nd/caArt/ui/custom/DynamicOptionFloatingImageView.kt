package org.softeer_2nd.caArt.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.core.content.ContextCompat
import coil.load
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.databinding.LayoutDynamicOptionFloatingTooltipBinding
import org.softeer_2nd.caArt.model.data.state.SelectState
import org.softeer_2nd.caArt.ui.bindingadapter.setImageSrcWithUrl
import org.softeer_2nd.caArt.ui.callback.OnItemClickListener
import org.softeer_2nd.caArt.util.dp2px

class DynamicOptionFloatingImageView(context: Context, attrs: AttributeSet) :
    FrameLayout(context, attrs) {

    private val binding =
        LayoutDynamicOptionFloatingTooltipBinding.inflate(LayoutInflater.from(context), null, false)

    private val optionViewMap = mutableMapOf<CheckBox, Option>()
    private val viewOptionMap = mutableMapOf<Option, CheckBox>()
    private val floatingButtonList = mutableListOf<CheckBox>()
    private val popupWindow = PopupWindow(
        binding.root,
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT,
        true
    )

    private var selectedOption: Option? = null

    private val imageView = ImageView(context).apply {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        scaleType = ImageView.ScaleType.CENTER_CROP
    }

    init {
        binding.ivOptionFloatingOptionImage.clipToOutline = true
        isClickable = false
        isFocusable = false
        addView(imageView)

        popupWindow.setOnDismissListener {
            viewOptionMap[selectedOption]?.isChecked = false
        }
    }

    fun addOption(option: Option) {

        val ratioX = option.position?.mobileX ?: 0f
        val ratioY = option.position?.mobileY ?: 0f
        val floatingButton = CheckBox(context).apply {
            layoutParams = LayoutParams(28f.dp2px(context), 28f.dp2px(context))
            optionViewMap[this] = option
            viewOptionMap[option] = this
            floatingButtonList.add(this)
            initFloatingButton(option)
        }
        addView(floatingButton)

        floatingButton.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val offsetX = (measuredWidth * ratioX).toInt()
                val offsetY = (measuredHeight * ratioY).toInt()
                (floatingButton.layoutParams as MarginLayoutParams).setMargins(
                    offsetX,
                    offsetY,
                    0,
                    0
                )
                floatingButton.requestLayout()
                floatingButton.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
    }

    fun addOptions(options: List<SelectState<Option>?>) {
        for (option in options) {
            option ?: continue
            addOption(option.item)
        }
    }

    private fun showTooltip(target: View) {
        val xOffset = target.width / 2 - popupWindow.contentView.measuredWidth / 2
        val yOffset = -5
        popupWindow.showAsDropDown(target, xOffset, yOffset)
    }

    fun setImage(url: String?) {
        imageView.setImageSrcWithUrl(url)
    }

    private fun CheckBox.initFloatingButton(option: Option) {

        background = ContextCompat.getDrawable(
            context,
            R.drawable.selector_option_floating_handle_background
        )
        setOnClickListener {
            selectedOption = optionViewMap[this]
            showTooltip(this)
            binding.apply {
                optionName = option.optionName
                optionPrice = option.optionPrice ?: 0
                optionImageUrl = option.optionImage
            }
        }
        buttonDrawable = null
    }

    fun setOnMoreIconClickListener(listener: OnItemClickListener<Option>) {
        binding.ibOptionFloatingDetail.setOnClickListener {
            listener.onItemClicked(selectedOption)
        }
    }

    fun clear() {
        floatingButtonList.forEach {
            removeView(it)
        }
        optionViewMap.clear()
        viewOptionMap.clear()
        floatingButtonList.clear()
    }
}