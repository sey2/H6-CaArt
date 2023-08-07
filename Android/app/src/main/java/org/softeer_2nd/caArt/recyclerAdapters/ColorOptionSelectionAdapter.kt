package org.softeer_2nd.caArt.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemColorSelectBinding
import org.softeer_2nd.caArt.models.OptionColorDummyItem

class ColorOptionSelectionAdapter(private val items: List<OptionColorDummyItem>) :
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

        notifyItemChanged(previousSelected)
        notifyItemChanged(selectedPosition)
    }


    override fun onBindViewHolder(holder: ColorOptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    inner class ColorOptionSelectionViewHolder(val binding: ItemColorSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener { selectItem(adapterPosition) }
        }
        fun bind(item: OptionColorDummyItem) {
            val selected = adapterPosition == selectedPosition

            binding.apply {
                topTag.text = item.tag
                this.selected = selected
                this.backgroundRes = item.res
            }
        }
    }
}
