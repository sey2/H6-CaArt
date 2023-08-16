package org.softeer_2nd.caArt.view.recyclerAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import org.softeer_2nd.caArt.databinding.ItemTrimDescriptionBinding
import org.softeer_2nd.caArt.model.dummy.TrimDescriptionDummyItem

class TrimDescriptionAdapter(private val items: MutableList<TrimDescriptionDummyItem>) :
    RecyclerView.Adapter<TrimDescriptionAdapter.TrimDescriptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrimDescriptionViewHolder {
        val binding =
            ItemTrimDescriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrimDescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrimDescriptionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    fun updateData(newItems: List<TrimDescriptionDummyItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class TrimDescriptionViewHolder(val binding: ItemTrimDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrimDescriptionDummyItem) {
            binding.apply {
                itemDescription = item
                ivDescription.load(item.imgUrl){
                    scale(coil.size.Scale.FILL)
                    transformations(RoundedCornersTransformation(8f))
                }
            }
        }
    }
}
