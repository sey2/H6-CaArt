package org.softeer_2nd.caArt.view.recyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemColorSelectBinding
import org.softeer_2nd.caArt.view.callbackListener.OnOtherColorItemClickListener
import org.softeer_2nd.caArt.model.dummy.OptionColorDummyItem

class ColorOptionSelectionAdapter(
    private val listener: OnOtherColorItemClickListener,
    private val items: List<OptionColorDummyItem>,
    private val isOtherColorOption: Boolean
) :
    RecyclerView.Adapter<ColorOptionSelectionAdapter.ColorOptionSelectionViewHolder>() {
    private var selectedPosition = -1
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

    override fun onBindViewHolder(holder: ColorOptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    inner class ColorOptionSelectionViewHolder(val binding: ItemColorSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onOtherColorItemClicked(view: View) {
            listener.onItemClicked(items[adapterPosition].tag)
        }

        fun onDefaultColorItemClicked(view: View) {
            selectItem(adapterPosition)
        }

        fun bind(item: OptionColorDummyItem) {
            val selectedFlag = adapterPosition == selectedPosition

            binding.apply {
                binding.otherColorSelectionHandler = this@ColorOptionSelectionViewHolder
                selected = selectedFlag
                backgroundRes = item.res
                isOtherColor = this@ColorOptionSelectionAdapter.isOtherColorOption
                inTop3 = adapterPosition <= 2
                topTag.text = "Top ${adapterPosition + 1}"
                optionTitle = item.tag
            }
        }
    }
}
