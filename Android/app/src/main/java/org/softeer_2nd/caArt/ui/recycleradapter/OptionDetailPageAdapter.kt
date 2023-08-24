package org.softeer_2nd.caArt.ui.recycleradapter

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.databinding.ItemOptionDetailBinding
import org.softeer_2nd.caArt.model.data.state.OptionDetailDialogState
import org.softeer_2nd.caArt.ui.callback.OnRecyclerItemClickListener
import org.softeer_2nd.caArt.util.dp2px
import kotlin.math.max

class OptionDetailPageAdapter(
    state: OptionDetailDialogState,
    private val onSelectButtonClicked: OnClickListener,
    private val onTextIndicatorItemClickListener: OnRecyclerItemClickListener<Option>,
    private val onCancelButtonClickListener: OnClickListener
) : RecyclerView.Adapter<OptionDetailPageAdapter.OptionDetailPageViewHolder>(),
    OnRecyclerItemClickListener<String> {

    private val parentOption = state.mainOption
    private val optionList = state.optionList
    private var isSelected = state.isSelected
    private var displayPageIndex: Int = 0

    private val textIndicatorAdapter =
        OptionDetailTextIndicatorAdapter(optionList.map { it.optionName }, this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionDetailPageViewHolder {
        val binding =
            ItemOptionDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                .apply {
                    clOptionDetailContainer.clipToOutline = true

                    rvOptionDetailTextIndicator.apply {
                        adapter = textIndicatorAdapter
                        layoutManager =
                            GridLayoutManager(parent.context, 2, GridLayoutManager.VERTICAL, false)
                        addItemDecoration(object : ItemDecoration() {
                            override fun getItemOffsets(
                                outRect: Rect,
                                view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State
                            ) {
                                val index = parent.getChildAdapterPosition(view)
                                if (index != 0 && index != optionList.size - 1)
                                    outRect.bottom = 14f.dp2px(parent.context)
                            }

                        })
                    }
                }
        return OptionDetailPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OptionDetailPageViewHolder, position: Int) {
        holder.bind(optionList[position], position)
    }

    override fun getItemCount(): Int = optionList.size

    override fun onItemClicked(position: Int, data: String) {
        onTextIndicatorItemClickListener.onItemClicked(position, optionList[position])
    }

    fun changeSelectState(isSelected: Boolean) {
        this.isSelected = isSelected
        notifyItemRangeChanged(0, itemCount)
    }

    fun setDisplayingPageIndex(index: Int) {
        displayPageIndex = index
        textIndicatorAdapter.setIndicatedItemPosition(index)
        val firstChangePosition = max(0, index - 1)
        notifyItemRangeChanged(firstChangePosition, index + 1 - firstChangePosition)
    }

    inner class OptionDetailPageViewHolder(private val binding: ItemOptionDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(option: Option, position: Int) {
            binding.apply {
                this.option = option
                parentOptionName = parentOption.optionName
                isGroup = !parentOption.subOptions.isNullOrEmpty()
                onCancelButtonClickListener = onCancelButtonClickListener
                pageIndex = position
                pageCount = optionList.size
                sbOptionDetailChoice.isChecked = isSelected
                sbOptionDetailChoice.setOnClickListener(onSelectButtonClicked)
                optionPrice = parentOption.optionPrice ?: 0
                isDefaultOption = (parentOption.optionPrice == null)
                onCancelButtonClickListener =
                    this@OptionDetailPageAdapter.onCancelButtonClickListener
            }
        }
    }
}
