package org.softeer_2nd.caArt.RecyclerAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.ItemTestData

class OptionSelectionAdapter(private val items: List<ItemTestData>) : RecyclerView.Adapter<OptionSelectionAdapter.OptionSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionSelectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_option_select, parent, false)
        return OptionSelectionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.optionTitle.text = currentItem.optionTitle
        holder.optionDetailTop.text = currentItem.optionDetailTop
        holder.optionDetailBottom.text = currentItem.optionDetailBottom
        holder.priceTop.text = currentItem.priceTop
        holder.priceBottom.text = currentItem.priceBottom
    }

    inner class OptionSelectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val optionTitle: TextView = itemView.findViewById(R.id.tv_option_title)
        val optionDetailTop: TextView = itemView.findViewById(R.id.tv_option_detail_top)
        val optionDetailBottom: TextView = itemView.findViewById(R.id.tv_option_detail_bottom)
        val priceTop: TextView = itemView.findViewById(R.id.tv_price_top)
        val priceBottom: TextView = itemView.findViewById(R.id.tv_price_bottom)
    }
}
