package org.softeer_2nd.caArt.ui.recycleradapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.ItemOptionTagBinding
import org.softeer_2nd.caArt.model.data.OptionTag
import org.softeer_2nd.caArt.ui.callback.OnRecyclerItemClickListener

class OptionTagRecyclerAdapter(
    private val onTagClickListener: OnRecyclerItemClickListener<OptionTag>
) : RecyclerView.Adapter<OptionTagRecyclerAdapter.OptionTagViewHolder>() {

    private var optionTagList = listOf<OptionTag>()
    private var selectedIndex: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionTagViewHolder {
        val binding =
            ItemOptionTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OptionTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OptionTagViewHolder, position: Int) {
        holder.bind(optionTagList[position], position)
    }

    override fun getItemCount(): Int = optionTagList.size

    fun changeSelectedItem(optionTag: OptionTag) {
        val new = optionTagList.indexOf(optionTag)
        if (new < 0) return
        val old = selectedIndex
        selectedIndex = new
        notifyItemChanged(old)
        notifyItemChanged(new)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(list: List<OptionTag>) {
        optionTagList = list
        notifyDataSetChanged()
    }

    inner class OptionTagViewHolder(private val binding: ItemOptionTagBinding) :
        ViewHolder(binding.root) {

        private val blueColor = ContextCompat.getColor(itemView.context, R.color.blue)
        private val gray400Color = ContextCompat.getColor(itemView.context, R.color.gray_400)
        private val gray800Color = ContextCompat.getColor(itemView.context, R.color.gray_800)
        private val gray100Color = ContextCompat.getColor(itemView.context, R.color.gray_100)

        fun bind(optionTag: OptionTag, position: Int) {
            binding.apply {
                tagName = optionTag.tagName
                iconUrl = optionTag.tagIcon
            }
            if (position == selectedIndex) applySelectedStyle() else applyDefaultStyle()
            binding.root.setOnClickListener {
                onTagClickListener.onItemClicked(position, optionTag)
            }
        }

        private fun applySelectedStyle() {
            binding.ivOptionTabIcon.apply {
                backgroundTintList = null
                imageTintList = ColorStateList.valueOf(blueColor)
            }
            binding.tvOptionTagName.apply {
                setTextColor(blueColor)
                setTypeface(typeface, Typeface.BOLD)
            }
        }

        private fun applyDefaultStyle() {
            binding.ivOptionTabIcon.apply {
                backgroundTintList = ColorStateList.valueOf(gray800Color)
                imageTintList = ColorStateList.valueOf(gray100Color)
            }
            binding.tvOptionTagName.apply {
                setTextColor(gray400Color)
                setTypeface(typeface, Typeface.NORMAL)
            }
        }
    }
}