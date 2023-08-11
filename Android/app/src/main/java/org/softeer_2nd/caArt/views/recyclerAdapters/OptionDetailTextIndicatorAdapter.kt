package org.softeer_2nd.caArt.views.recyclerAdapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.views.callbackListener.OnRecyclerItemClickListener

class OptionDetailTextIndicatorAdapter(
    private val optionNameList: List<String>,
    private val listener: OnRecyclerItemClickListener<String>
) : RecyclerView.Adapter<OptionDetailTextIndicatorAdapter.OptionDetailTextIndicatorItemViewHolder>() {

    private var indicatedItemIndex = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OptionDetailTextIndicatorItemViewHolder {
        val textView = TextView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        return OptionDetailTextIndicatorItemViewHolder(textView)
    }

    override fun onBindViewHolder(holder: OptionDetailTextIndicatorItemViewHolder, position: Int) {
        holder.bind(optionNameList[position], position)
    }

    override fun getItemCount(): Int = optionNameList.size

    fun setIndicatedItemPosition(currentPosition: Int) {
        val prev = indicatedItemIndex
        indicatedItemIndex = currentPosition
        notifyItemChanged(prev)
        if (currentPosition in optionNameList.indices) notifyItemChanged(indicatedItemIndex)
    }

    inner class OptionDetailTextIndicatorItemViewHolder(private val textView: TextView) :
        RecyclerView.ViewHolder(textView) {

        fun bind(optionName: String, position: Int) {
            textView.apply {
                text = optionName
                setOnClickListener {
                    listener.onItemClicked(position, optionName)
                }
            }
            if (position == indicatedItemIndex) textView.setIndicated() else textView.setNotIndicated()
        }

        private fun TextView.setIndicated() {
            typeface = resources.getFont(R.font.hyundaisanstextkrmedium)
            setTextColor(ContextCompat.getColor(context, R.color.active_blue))
        }

        private fun TextView.setNotIndicated() {
            typeface = resources.getFont(R.font.hyundaisanstextkrregular)
            setTextColor(ContextCompat.getColor(context, R.color.gray_400))
        }
    }
}