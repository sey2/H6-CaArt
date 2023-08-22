package org.softeer_2nd.caArt.ui.recycleradapter

import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.util.dp2px

class UserSelectedAnswerChipRecyclerAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<UserSelectedAnswerChipRecyclerAdapter.UserAnswerChipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAnswerChipViewHolder {
        val view = TextView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                28f.dp2px(parent.context)
            )
            val verticalPadding = 10f.dp2px(parent.context)
            setPadding(verticalPadding, 0, verticalPadding, 0)
            setBackgroundResource(R.drawable.shape_user_select_answer_chip_background_gray600_r30)
            gravity = Gravity.CENTER
            typeface = parent.context.resources.getFont(R.font.hyundaisanstextkrmedium)
            textSize = 12f
            setTextColor(ContextCompat.getColor(parent.context, R.color.gray_300))
        }
        return UserAnswerChipViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAnswerChipViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class UserAnswerChipViewHolder(private val textView: TextView) :
        RecyclerView.ViewHolder(textView) {
        fun bind(text: String) {
            textView.text = text
        }
    }
}