package org.softeer_2nd.caArt.ui.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.ItemOptionSelectBinding
import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.UserChoiceBottomsheetState
import org.softeer_2nd.caArt.model.data.WheelDrive
import org.softeer_2nd.caArt.model.factory.DummyItemFactory

class BottomSheetCurrentOptionAdapter() :
    RecyclerView.Adapter<BottomSheetCurrentOptionAdapter.OptionSelectionViewHolder>() {
    private var items: MutableList<UserChoiceBottomsheetState> =
        DummyItemFactory.createOptionSelectionDummyItems()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionSelectionViewHolder {
        val binding =
            ItemOptionSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return OptionSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OptionSelectionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    fun updateItem(index: Int, newItem: UserChoiceBottomsheetState) {
        if (items.isNotEmpty()) {
            items[index] = newItem
            notifyItemChanged(index)
        }
    }

    fun updateEngineItem(engine: Engine) {
        if (items.isNotEmpty()) {
            val engineParts = engine.itemName.split(" ")
            if (engineParts.size > 1) {
                val currentItemParts = items[0].optionDetailTop.split(" ").toMutableList()
                currentItemParts[1] = engineParts[0]
                currentItemParts[2] = engineParts[1]
                items[0].optionDetailTop = currentItemParts.joinToString(" ")
            }
        }
        notifyItemChanged(0)
    }

    fun updateWheelDriveItem(wheelDrive: WheelDrive) {
        if (items.isNotEmpty()) {
            val currentItemParts = items[0].optionDetailTop.split(" ").toMutableList()
            currentItemParts[3] = wheelDrive.itemName
            items[0].optionDetailTop = currentItemParts.joinToString(" ")
        }
        notifyItemChanged(0)
    }

    fun updateBodyTypeItem(bodyType: BodyType) {
        if (items.isNotEmpty()) {
            items[0].optionDetailBottom = bodyType.itemName
        }
        notifyItemChanged(0)
    }

    inner class OptionSelectionViewHolder(val binding: ItemOptionSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserChoiceBottomsheetState) {
            binding.userChoiceItem = item
        }
    }
}
