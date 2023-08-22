package org.softeer_2nd.caArt.ui.callback

import org.softeer_2nd.caArt.model.data.ChoiceColorItem

interface OnOtherColorItemClickListener {
    fun onItemClicked(
        item: ChoiceColorItem,
        isOtherColor: Boolean,
        index: Int,
    )
}