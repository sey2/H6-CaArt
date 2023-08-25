package org.softeer_2nd.caArt.ui.recycleradapter

import android.content.res.ColorStateList
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.data.Answer
import org.softeer_2nd.caArt.ui.callback.OnItemClickListener
import org.softeer_2nd.caArt.util.dp2px

class SurveyAnswerOptionsRecyclerAdapter(private val itemSelectListener: OnItemClickListener<Answer>) :
    RecyclerView.Adapter<SurveyAnswerOptionsRecyclerAdapter.SurveyAnswerOptionViewHolder>() {

    private var selectedAnswerOptionIndex: Int = -1
    private var answerOptionList: List<Answer> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SurveyAnswerOptionViewHolder {
        val paddingHorizontal = 12f.dp2px(parent.context)
        val textView = TextView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                56f.dp2px(parent.context)
            )
            gravity = Gravity.CENTER_VERTICAL
            setPadding(paddingHorizontal, 0, paddingHorizontal, 0)
        }
        return SurveyAnswerOptionViewHolder(textView)
    }

    override fun onBindViewHolder(holder: SurveyAnswerOptionViewHolder, position: Int) {
        holder.bind(answerOptionList[position])
        if (position == selectedAnswerOptionIndex) holder.applySelectedStyle() else holder.applyDefaultStyle()
    }

    override fun getItemCount(): Int = answerOptionList.size

    fun setAnswerOptionList(optionList: List<Answer>) {
        answerOptionList = optionList
        notifyItemRangeChanged(0, answerOptionList.size)
    }

    fun selectAnswerOption(answer: Answer) {
        val newIndex = answerOptionList.indexOf(answer)
        if (newIndex == -1) return
        val oldIndex = selectedAnswerOptionIndex
        selectedAnswerOptionIndex = newIndex

        if (oldIndex >= 0) notifyItemChanged(oldIndex)
        notifyItemChanged(selectedAnswerOptionIndex)

    }

    inner class SurveyAnswerOptionViewHolder(private val textView: TextView) :
        RecyclerView.ViewHolder(textView) {

        private val selectedIconDrawable =
            ContextCompat.getDrawable(textView.context, R.drawable.ic_check_circle_24_blue)
        private val selectedTextColor = ContextCompat.getColor(textView.context, R.color.blue)
        private val defaultTextColor = ContextCompat.getColor(textView.context, R.color.gray_400)
        private val selectedBackgroundColor =
            ContextCompat.getColor(textView.context, R.color.gray_800)

        init {
            textView.textSize = 16f
            textView.background = ContextCompat.getDrawable(
                textView.context,
                R.drawable.shape_survey_answer_option_background_r6_blue
            )
        }

        fun bind(answerOption: Answer) {
            textView.text = answerOption.answer
            textView.setOnClickListener {
                itemSelectListener.onItemClicked(answerOption)
            }
        }

        fun applySelectedStyle() {
            textView.apply {
                setTextColor(selectedTextColor)
                setCompoundDrawablesWithIntrinsicBounds(null, null, selectedIconDrawable, null)
                backgroundTintList = null
                typeface = resources.getFont(R.font.hyundaisanstextkrmedium)
            }
        }

        fun applyDefaultStyle() {
            textView.apply {
                setTextColor(defaultTextColor)
                setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                backgroundTintList = ColorStateList.valueOf(selectedBackgroundColor)
                typeface = resources.getFont(R.font.hyundaisanstextkrregular)
            }
        }
    }
}