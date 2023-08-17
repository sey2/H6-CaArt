package org.softeer_2nd.caArt.ui.recycleradapter

import android.content.Context
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.data.TrimItemColor
import org.softeer_2nd.caArt.model.data.TrimMainItem
import org.softeer_2nd.caArt.util.dp2px

class TrimOptionMoreDetailAdapter(
    private val isDefaultOption: Boolean = false
) : RecyclerView.Adapter<TrimOptionMoreDetailAdapter.TrimOptionMoreDetailViewHolder>() {

    private var items = mutableListOf<Any>()

    companion object {
        const val IMAGE_WIDTH_DP = 24f
        const val IMAGE_HEIGHT_DP = 24f
        const val DEFAULT_IMAGE_WIDTH_DP = 96f
        const val DEFAULT_IMAGE_HEIGHT_DP = 80f
        const val TEXT_SIZE_SP = 12f
        const val MARGIN_DP = 8f
    }

    private lateinit var typeface: Typeface
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrimOptionMoreDetailViewHolder {

        typeface = ResourcesCompat.getFont(parent.context, R.font.hyundaisanstext_regular)
            ?: Typeface.DEFAULT

        return TrimOptionMoreDetailViewHolder(parent.context, isDefaultOption, typeface)
    }

    override fun onBindViewHolder(holder: TrimOptionMoreDetailViewHolder, position: Int) {
        val imageItem = items[position]
        holder.bind(imageItem)
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Any>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class TrimOptionMoreDetailViewHolder(
        private val context: Context,
        isDefaultOption: Boolean,
        typeface: Typeface
    ) : RecyclerView.ViewHolder(LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        layoutParams = ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).also { it.rightMargin = MARGIN_DP.dp2px(context) }

    }) {
        private val ivMoreOption: ImageView = ImageView(context).apply {
            layoutParams = if (isDefaultOption) {
                ViewGroup.LayoutParams(
                    DEFAULT_IMAGE_WIDTH_DP.dp2px(context),
                    DEFAULT_IMAGE_HEIGHT_DP.dp2px(context)
                )
            } else {
                ViewGroup.LayoutParams(
                    IMAGE_WIDTH_DP.dp2px(context),
                    IMAGE_HEIGHT_DP.dp2px(context)
                )
            }
        }

        private val tvOptionTitle: TextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            textSize = TEXT_SIZE_SP
            setTextColor(ContextCompat.getColor(context, R.color.gray_100))
            typeface.let { this.typeface = typeface }

            if (isDefaultOption) {
                val params = layoutParams as LinearLayout.LayoutParams
                params.topMargin = MARGIN_DP.dp2px(context)
            }
        }

        init {
            (itemView as LinearLayout).apply {
                addView(ivMoreOption)
                if (isDefaultOption) addView(tvOptionTitle)
            }
        }

        fun bind(imageItem: Any) {
            val url =
                if (isDefaultOption) (imageItem as TrimMainItem).optionImage else (imageItem as TrimItemColor).colorImage

            ivMoreOption.load(url) {
                scale(coil.size.Scale.FILL)
                transformations(RoundedCornersTransformation(6f))
            }

            if (isDefaultOption)
                tvOptionTitle.text = (imageItem as TrimMainItem).optionName
        }
    }
}
