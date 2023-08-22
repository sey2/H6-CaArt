package org.softeer_2nd.caArt.ui.recycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemColorSelectBinding
import org.softeer_2nd.caArt.ui.callback.OnOtherColorItemClickListener
import org.softeer_2nd.caArt.model.data.ChoiceColorItem

class ColorOptionSelectionAdapter(
    private val listener: OnOtherColorItemClickListener,
    private val isOtherColorOption: Boolean,
    private var selectedPosition: Int = 0
) :
    RecyclerView.Adapter<ColorOptionSelectionAdapter.ColorOptionSelectionViewHolder>() {

    private var items = listOf<ChoiceColorItem>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ColorOptionSelectionViewHolder {
        val binding =
            ItemColorSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorOptionSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun selectItem(position: Int) {
        val previousSelected = selectedPosition
        selectedPosition = position

        if (previousSelected in 0 until itemCount) {
            notifyItemChanged(previousSelected)
        }

        if (selectedPosition in 0 until itemCount) {
            notifyItemChanged(selectedPosition)
        }
    }

    fun updateItem(newItems: List<ChoiceColorItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ColorOptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    inner class ColorOptionSelectionViewHolder(val binding: ItemColorSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onOtherColorItemClicked(view: View) {
            listener.onItemClicked(
                ChoiceColorItem(
                    items[adapterPosition].tag,
                    items[adapterPosition].colorName,
                    items[adapterPosition].colorPrice,
                    isExteriorColor = items[adapterPosition].isExteriorColor,
                    trimName = items[adapterPosition].trimName
                ),
                isOtherColor = true,
                adapterPosition,
            )
        }

        fun onDefaultColorItemClicked(view: View) {
            listener.onItemClicked(
                ChoiceColorItem(
                    items[adapterPosition].tag,
                    items[adapterPosition].colorName,
                    items[adapterPosition].colorPrice,
                    isExteriorColor = items[adapterPosition].isExteriorColor,
                ),
                isOtherColor = false,
                adapterPosition
            )
            selectItem(adapterPosition)
        }

        fun bind(item: ChoiceColorItem) {
            val selectedFlag = adapterPosition == selectedPosition

            binding.apply {
                binding.otherColorSelectionHandler = this@ColorOptionSelectionViewHolder
                selected = selectedFlag && !isOtherColorOption
                imgUrl = item.imgUrl
                isOtherColor = this@ColorOptionSelectionAdapter.isOtherColorOption
                inTop3 = adapterPosition <= 2
                topTag.text = "Top ${adapterPosition + 1}"
                optionTitle = item.tag
            }
        }
    }
}
