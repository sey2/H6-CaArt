package org.softeer_2nd.caArt.ui.dialog

import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.ui.recycleradapter.OptionDetailPageAdapter
import org.softeer_2nd.caArt.util.dp2px

class OptionDetailDialog(private val builder: Builder) : DialogFragment() {

    companion object {
        const val SINGLE_OPTION = 0
        const val OPTION_GROUP = 1
    }

    private var viewPager: ViewPager2? = null

    override fun onStart() {
        super.onStart()
        val width = requireContext().resources.displayMetrics.widthPixels
        val height =
            if (builder.type == SINGLE_OPTION) width / 330 * 396 else width / 330 * 570
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewPager = ViewPager2(requireContext()).apply {
            initOptionDetailViewPager()
        }
        return viewPager ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = OptionDetailPageAdapter(
            builder.parentOption,
            builder.optionList?: listOf(),
            onTextIndicatorItemClickListener = { position, _ ->
                viewPager?.setCurrentItem(position, true)
            },
            onOptionSelectListener = { _, optionSelectEvent ->
                //TODO 반영 ~ 뷰모델
            },
            onCancelButtonClickListener = {
                dismiss()
            }
        )

        viewPager?.adapter = adapter
    }

    private fun ViewPager2.initOptionDetailViewPager() {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        clipToPadding = false
        clipChildren = false

        val margin = 22f.dp2px(requireContext())
        val adjacentItemPreviewWidth = 8f.dp2px(context)
        addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.left = margin
                outRect.right = margin
            }
        })
        offscreenPageLimit = 1
        setPageTransformer { page, position ->
            page.translationX = position * -(margin + adjacentItemPreviewWidth)

        }
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                (adapter as OptionDetailPageAdapter).setDisplayingPageIndex(position)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPager = null
    }

    class Builder() {
        var isDefaultOption=false
        var parentOption:Option?=null
        var optionList: List<Option>? = null
        private var _type: Int = SINGLE_OPTION
        val type get() = _type
        fun setOption(option: Option) = apply {
            if (option.subOptions.isNullOrEmpty()){
                _type= SINGLE_OPTION
                optionList=listOf(option)

            }else{
                _type= OPTION_GROUP
                parentOption=option
                optionList=option.subOptions
            }
        }

        fun build(): OptionDetailDialog = OptionDetailDialog(this)
    }
}