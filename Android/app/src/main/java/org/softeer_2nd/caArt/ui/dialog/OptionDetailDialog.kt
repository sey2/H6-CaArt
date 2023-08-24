package org.softeer_2nd.caArt.ui.dialog

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.state.SelectState
import org.softeer_2nd.caArt.model.factory.OptionDetailDialogViewModelFactory
import org.softeer_2nd.caArt.ui.callback.OnDialogDismissListener
import org.softeer_2nd.caArt.ui.callback.OnItemClickListener
import org.softeer_2nd.caArt.ui.recycleradapter.OptionDetailPageAdapter
import org.softeer_2nd.caArt.util.dp2px
import org.softeer_2nd.caArt.viewmodel.OptionDetailDialogViewModel
import kotlin.math.abs

class OptionDetailDialog(private val builder: Builder) : DialogFragment() {

    private val viewModelFactory = OptionDetailDialogViewModelFactory(
        mainOption = builder.parentOption!!,
        initialSelected = builder.isSelected
    )
    private val model by lazy {
        ViewModelProvider(this, viewModelFactory)[OptionDetailDialogViewModel::class.java]
    }

    companion object {
        const val SINGLE_OPTION = 0
        const val OPTION_GROUP = 1
    }

    private var viewPager: ViewPager2? = null
    private var adapter: OptionDetailPageAdapter? = null

    override fun onStart() {
        super.onStart()
        val width = requireContext().resources.displayMetrics.widthPixels
        val height =
            if (builder.type == SINGLE_OPTION) width / 330 * 396 else width / 330 * 570
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
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

        model.optionDetailDialogState.observe(viewLifecycleOwner) {
            adapter = OptionDetailPageAdapter(
                state = it,
                onTextIndicatorItemClickListener = { position, _ ->
                    viewPager?.setCurrentItem(position, true)
                },
                onSelectButtonClicked = {
                    model.changeSelected()
                },
                onCancelButtonClickListener = {
                    dismiss()
                }
            )

            viewPager?.adapter = adapter
        }

        model.onSelectChangeEvent.observe(viewLifecycleOwner) {
            adapter?.changeSelectState(it)
        }

        model.pageChangeEvent.observe(viewLifecycleOwner) {
            adapter?.setDisplayingPageIndex(it)
        }
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
            page.alpha = 0.55f + (1 - abs(position))
        }
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                model.setPageChangeEvent(position)
            }
        })
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        builder.parentOption?.let { builder.onSelectResultListener?.onDialogDismissed(model.getSelectState()) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPager = null
        adapter = null
    }

    class Builder() {
        var parentOption: Option? = null
        var optionList: List<Option>? = null
        var isSelected = false
        var onSelectResultListener: OnDialogDismissListener<SelectState<Option>>? = null
        private var _type: Int = SINGLE_OPTION
        val type get() = _type
        fun setOption(option: SelectState<Option>) = apply {
            parentOption = option.item
            if (option.item.subOptions.isNullOrEmpty()) {
                _type = SINGLE_OPTION
                optionList = listOf(option.item)

            } else {
                _type = OPTION_GROUP
                optionList = option.item.subOptions
            }
            isSelected = option.isSelected
        }

        fun setOnOptionSelectResultListener(listener: OnDialogDismissListener<SelectState<Option>>? = null) =
            apply {
                onSelectResultListener = listener
            }

        fun build(): OptionDetailDialog = OptionDetailDialog(this)
    }
}