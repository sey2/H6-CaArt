package org.softeer_2nd.caArt.view.recyclerAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemTrimDescriptionPagerBinding
import org.softeer_2nd.caArt.model.data.Compositions
import org.softeer_2nd.caArt.model.data.TrimDescription

class TrimDescriptionPagerAdapter() :
    RecyclerView.Adapter<TrimDescriptionPagerAdapter.TrimDescriptionHolder>() {

    private var items: Compositions? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrimDescriptionHolder {
        val binding = ItemTrimDescriptionPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TrimDescriptionHolder(binding)
    }

    fun updateItems(newItems: Compositions) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TrimDescriptionHolder, position: Int) {
        val item = when (position) {
            0 -> items?.carEngines
            1 -> items?.bodyTypes
            2 -> items?.wheelDrives
            else -> return
        }

        item?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = 3

    inner class TrimDescriptionHolder(private val binding: ItemTrimDescriptionPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val descriptionAdapter: TrimDescriptionAdapter = TrimDescriptionAdapter(
            mutableListOf()
        )

        init {
            binding.rvTrimDescription.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
            binding.rvTrimDescription.adapter = descriptionAdapter
        }

        fun bind(items: List<TrimDescription>) {
            descriptionAdapter.updateData(items)
        }
    }
}
