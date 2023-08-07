package org.softeer_2nd.caArt.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemOptionSelectBinding
import org.softeer_2nd.caArt.models.OptionSelectionDummyItem

class OptionSelectionAdapter(private val items: List<OptionSelectionDummyItem>) :
    RecyclerView.Adapter<OptionSelectionAdapter.OptionSelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionSelectionViewHolder {
        val binding =
            ItemOptionSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OptionSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    inner class OptionSelectionViewHolder(val binding: ItemOptionSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OptionSelectionDummyItem) {
            binding.apply {
                tvOptionTitle.text = item.optionTitle
                tvOptionDetailTop.text = item.optionDetailTop
                tvOptionDetailBottom.text = item.optionDetailBottom
                tvPriceTop.text = item.priceTop
                tvPriceBottom.text = item.priceBottom
            }
        }
    }
}
