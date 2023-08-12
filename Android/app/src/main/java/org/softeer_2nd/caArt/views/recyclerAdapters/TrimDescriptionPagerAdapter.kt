package org.softeer_2nd.caArt.views.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemTrimDescriptionPagerBinding
import org.softeer_2nd.caArt.models.factorys.DummyItemFactory

class TrimDescriptionPagerAdapter() :
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
        holder.bind()
    }

    override fun getItemCount(): Int = 3

    inner class TrimDescriptionHolder(private val binding: ItemTrimDescriptionPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.rvTrimDescription.apply {
                this.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                this.adapter = TrimDescriptionAdapter(DummyItemFactory.createTrimDescriptionItem())
            }
        }
    }
}
