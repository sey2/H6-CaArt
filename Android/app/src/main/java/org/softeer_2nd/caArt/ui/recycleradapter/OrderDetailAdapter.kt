package org.softeer_2nd.caArt.ui.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemOrderDetailBinding

class OrderDetailAdapter(private val items: List<String>) :
    RecyclerView.Adapter<OrderDetailAdapter.OrderDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailViewHolder {
        val binding =
            ItemOrderDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    inner class OrderDetailViewHolder(val binding: ItemOrderDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.apply {
                tvHandle.text = item
            }
        }
    }
}
