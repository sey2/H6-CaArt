package org.softeer_2nd.caArt.views.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemTrimSelectBinding
import org.softeer_2nd.caArt.models.factorys.DummyItemFactory
import org.softeer_2nd.caArt.models.dummys.OptionTrimSelectionDummyItem

class TrimOptionSelectionAdapter(
    private val items: List<OptionTrimSelectionDummyItem>
) :
    RecyclerView.Adapter<TrimOptionSelectionAdapter.TrimOptionSelectionViewHolder>() {
    private var selectedPosition = 0
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrimOptionSelectionViewHolder {
        val binding =
            ItemTrimSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TrimOptionSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TrimOptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    inner class TrimOptionSelectionViewHolder(val binding: ItemTrimSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.ivTrimCheck.setOnClickListener {
                if (selectedPosition != -1) {
                    items[selectedPosition].isChecked = false
                    notifyItemChanged(selectedPosition)
                }

                items[adapterPosition].isChecked = true
                notifyItemChanged(adapterPosition)
                selectedPosition = adapterPosition
            }

            binding.incOtherMore.rvOtherMoreExteriorDetail.apply {
                this.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                this.adapter = TrimOptionMoreDetailAdapter(DummyItemFactory.createTrimMoreExteriorDetailItem())
                isNestedScrollingEnabled = false
            }

            binding.incOtherMore.rvOtherMoreInteriorDetail.apply {
                this.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                this.adapter = TrimOptionMoreDetailAdapter(DummyItemFactory.createTrimMoreInteriorDetailItem())
            }

            binding.incOtherMore.rvOtherMoreDefaultDetail.apply {
                this.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                this.adapter = TrimOptionMoreDetailAdapter(DummyItemFactory.createTrimMoreDefaultDetailItem(), true)
            }
        }


        fun bind(item: OptionTrimSelectionDummyItem) {
            binding.apply {
                trimDummyItem = OptionTrimSelectionDummyItem(
                    item.model,
                    item.productKeyFeatures,
                    item.specifications,
                    item.price,
                    adapterPosition == itemCount - 1
                )
                isChecked = item.isChecked
            }
        }
    }
}
