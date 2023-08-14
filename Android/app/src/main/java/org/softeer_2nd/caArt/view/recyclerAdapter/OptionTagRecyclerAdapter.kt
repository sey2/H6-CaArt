package org.softeer_2nd.caArt.view.recyclerAdapter

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.ItemOptionTagBinding
import org.softeer_2nd.caArt.view.callbackListener.OnRecyclerItemClickListener

class OptionTagRecyclerAdapter(
    private val optionTagList: List<String>,
    private val onTagClickListener: OnRecyclerItemClickListener<String>
) : RecyclerView.Adapter<OptionTagRecyclerAdapter.OptionTagViewHolder>() {

    private var selectedIndex:Int=0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionTagViewHolder {
        val binding =
            ItemOptionTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OptionTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OptionTagViewHolder, position: Int) {
        holder.bind(optionTagList[position],position)
    }

    override fun getItemCount(): Int = optionTagList.size

    fun changeSelect(currentIndex:Int){
        val old=selectedIndex
        selectedIndex=currentIndex
        notifyItemChanged(old)
        notifyItemChanged(currentIndex)
    }

    inner class OptionTagViewHolder(private val binding: ItemOptionTagBinding) :
        ViewHolder(binding.root) {

        private val blueColor=ContextCompat.getColor(itemView.context, R.color.blue)
        private val gray400Color=ContextCompat.getColor(itemView.context,R.color.gray_400)
        private val gray800Color=ContextCompat.getColor(itemView.context,R.color.gray_800)
        private val gray100Color=ContextCompat.getColor(itemView.context,R.color.gray_100)

        fun bind(optionTag: String,position: Int) {
            binding.tagName = optionTag
            if(position==selectedIndex)applySelectedStyle() else applyDefaultStyle()
            binding.root.setOnClickListener {
                onTagClickListener.onItemClicked(position,optionTag)
                changeSelect(position) //나중에 삭제
            }
        }

        private fun applySelectedStyle(){
            binding.imageView3.apply{
                backgroundTintList = null
                imageTintList= ColorStateList.valueOf(blueColor)
            }
            binding.textView.apply{
                setTextColor(blueColor)
                setTypeface(typeface, Typeface.BOLD)
            }
        }

        private fun applyDefaultStyle(){
            binding.imageView3.apply{
                backgroundTintList = ColorStateList.valueOf(gray800Color)
                imageTintList= ColorStateList.valueOf(gray100Color)
            }
            binding.textView.apply{
                setTextColor(gray400Color)
                setTypeface(typeface, Typeface.NORMAL)
            }
        }
    }
}