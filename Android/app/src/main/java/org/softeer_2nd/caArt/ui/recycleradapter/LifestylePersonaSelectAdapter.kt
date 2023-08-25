package org.softeer_2nd.caArt.ui.recycleradapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.ItemLifeStyleNoPersonaBinding
import org.softeer_2nd.caArt.databinding.ItemLifeStylePersonaBinding
import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.ui.callback.OnRecyclerItemClickListener

class LifestylePersonaSelectAdapter(
    private val onLifeStylePersonaMoreClickListener: OnRecyclerItemClickListener<Persona>,
    private val onLifeStylePersonaClickListener: OnRecyclerItemClickListener<Persona>,
    private val onLifeStylePersonaDetailSelectClickListener: View.OnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var selectedIndex = 0
    private val itemList = mutableListOf<Persona>()

    private val PERSONA = 0
    private val NO_LIFESTYLE_YOU_WANT = 1

    override fun getItemViewType(position: Int): Int {
        if (position < itemList.size) return PERSONA
        return NO_LIFESTYLE_YOU_WANT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == PERSONA) {
            val binding = ItemLifeStylePersonaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            LifestylePersonaViewHolder(binding)
        } else {
            val binding = ItemLifeStyleNoPersonaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            LifeStyleNoPersonaViewHolder(binding)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LifestylePersonaViewHolder) {
            holder.bind(itemList[position])
            if (position == selectedIndex) holder.applySelectedStyle() else holder.applyDefaultStyle()
        }

    }

    override fun getItemCount(): Int = itemList.size + 1

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(list: List<Persona>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    fun selectItem(item: Persona) {
        val old = selectedIndex
        val new = itemList.indexOf(item)
        if (new < 0) return
        selectedIndex = new
        notifyItemChanged(old)
        notifyItemChanged(new)
    }

    inner class LifestylePersonaViewHolder(private val binding: ItemLifeStylePersonaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val defaultBackgroundColorStateList =
            ContextCompat.getColorStateList(itemView.context, R.color.blue_100)
        private val defaultIconColorStateList =
            ContextCompat.getColorStateList(itemView.context, R.color.gray_500)
        private val defaultTagBackgroundColorStateList =
            ContextCompat.getColorStateList(itemView.context, R.color.white)

        init {
            binding.ivLifeStylePersonaImage.clipToOutline = true

        }

        fun bind(persona: Persona) {
            binding.apply {
                tagText1 = persona.tags[0]
                tagText2 = persona.tags[1]
                lifeStyleDescription = persona.coverLetter
                lifeStyleImageUrl = persona.profileImage
            }

            binding.tvLifeStylePersonaMore.setOnClickListener {
                onLifeStylePersonaMoreClickListener.onItemClicked(adapterPosition, persona)
            }

            binding.root.setOnClickListener {
                onLifeStylePersonaClickListener.onItemClicked(adapterPosition, persona)
            }

        }

        fun applySelectedStyle() {
            binding.isSelected = true
            binding.vLifeStylePersonaBackground.backgroundTintList = null
            binding.ivLifeStylePersonaSelect.backgroundTintList = null
            binding.tvLifeStylePersonaTag1.backgroundTintList = null
            binding.tvLifeStylePersonaTag2.backgroundTintList = null
        }

        fun applyDefaultStyle() {
            binding.isSelected = false
            binding.vLifeStylePersonaBackground.backgroundTintList = defaultBackgroundColorStateList
            binding.ivLifeStylePersonaSelect.backgroundTintList = defaultIconColorStateList
            binding.tvLifeStylePersonaTag1.backgroundTintList = defaultTagBackgroundColorStateList
            binding.tvLifeStylePersonaTag2.backgroundTintList = defaultTagBackgroundColorStateList
        }
    }

    inner class LifeStyleNoPersonaViewHolder(private val binding: ItemLifeStyleNoPersonaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.onLifeStyleDetailSelectionBtnClickListener =
                onLifeStylePersonaDetailSelectClickListener
        }
    }
}