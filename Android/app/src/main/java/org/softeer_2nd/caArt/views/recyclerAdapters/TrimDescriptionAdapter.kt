package org.softeer_2nd.caArt.views.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.softeer_2nd.caArt.databinding.ItemTrimDescriptionBinding
import org.softeer_2nd.caArt.models.dummys.TrimDescriptionDummyItem

class TrimDescriptionAdapter(private val items: List<TrimDescriptionDummyItem>) :
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

    inner class TrimDescriptionViewHolder(val binding: ItemTrimDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrimDescriptionDummyItem) {
            binding.apply {
                itemDescription = item
                Glide.with(ivDescription.context)
                    .load(item.imgUrl)
                    .fitCenter()
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(8)))
                    .into(ivDescription)
            }
        }
    }
}
