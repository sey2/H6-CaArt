package org.softeer_2nd.caArt.views.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemTrimDescriptionPagerBinding
import org.softeer_2nd.caArt.models.dummys.TrimDescriptionDummyItem

class TrimDescriptionPagerAdapter(private val items: List<List<TrimDescriptionDummyItem>>) :
    RecyclerView.Adapter<TrimDescriptionPagerAdapter.TrimDescriptionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrimDescriptionHolder {
        val binding = ItemTrimDescriptionPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TrimDescriptionHolder(binding)
    }

    override fun onBindViewHolder(holder: TrimDescriptionHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class TrimDescriptionHolder(private val binding: ItemTrimDescriptionPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val descriptionAdapter: TrimDescriptionAdapter = TrimDescriptionAdapter(emptyList())

        init {
            binding.rvTrimDescription.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
            binding.rvTrimDescription.adapter = descriptionAdapter
        }
        fun bind(itemList: List<TrimDescriptionDummyItem>) {
            descriptionAdapter.updateData(itemList)
        }
    }
}
