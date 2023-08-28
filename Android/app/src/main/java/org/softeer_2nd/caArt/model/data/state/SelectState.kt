package org.softeer_2nd.caArt.model.data.state

data class SelectState<ITEM_T>(val item: ITEM_T, var isSelected: Boolean)
