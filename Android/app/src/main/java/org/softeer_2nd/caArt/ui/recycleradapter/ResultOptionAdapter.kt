package org.softeer_2nd.caArt.ui.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemResultOptionBinding
import org.softeer_2nd.caArt.model.data.ResultChoiceOption

class ResultOptionAdapter(private val items: List<ResultChoiceOption>, val isToolTipVisible: Boolean) :
    RecyclerView.Adapter<ResultOptionAdapter.ResultOptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultOptionViewHolder {
        val binding =
            ItemResultOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultOptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultOptionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    inner class ResultOptionViewHolder(val binding: ItemResultOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultChoiceOption) {
            binding.apply {
                optionItem = item
                toolTipVisible = isToolTipVisible
            }
        }
    }
}
