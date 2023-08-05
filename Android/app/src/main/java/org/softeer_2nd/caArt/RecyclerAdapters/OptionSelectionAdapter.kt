package org.softeer_2nd.caArt.RecyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemOptionSelectBinding
import org.softeer_2nd.caArt.models.OptionSelectionDummyItem

class OptionSelectionAdapter(private val items: List<OptionSelectionDummyItem>) :
    RecyclerView.Adapter<OptionSelectionAdapter.OptionSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionSelectionViewHolder {
        val binding = ItemOptionSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OptionSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.apply {
            tvOptionTitle.text = currentItem.optionTitle
            tvOptionDetailTop.text = currentItem.optionDetailTop
            tvOptionDetailBottom.text = currentItem.optionDetailBottom
            tvPriceTop.text = currentItem.priceTop
            tvPriceBottom.text = currentItem.priceBottom
        }
    }

    inner class OptionSelectionViewHolder(val binding: ItemOptionSelectBinding) : RecyclerView.ViewHolder(binding.root)
}
