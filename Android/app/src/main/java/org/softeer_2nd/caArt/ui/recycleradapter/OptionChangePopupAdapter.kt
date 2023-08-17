package org.softeer_2nd.caArt.ui.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemOptionChangePopupBinding
import org.softeer_2nd.caArt.model.dummy.OptionChangePopUpDummyItem

class OptionChangePopupAdapter(private val items: List<OptionChangePopUpDummyItem>) :
    RecyclerView.Adapter<OptionChangePopupAdapter.OptionChangePopupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionChangePopupViewHolder {
        val binding =
            ItemOptionChangePopupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OptionChangePopupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OptionChangePopupViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    inner class OptionChangePopupViewHolder(val binding: ItemOptionChangePopupBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OptionChangePopUpDummyItem) {
            binding.apply {
                tvCurrentOption.text = item.optionName
                tvChangePrice.text = item.optionPrice
            }
        }
    }
}
