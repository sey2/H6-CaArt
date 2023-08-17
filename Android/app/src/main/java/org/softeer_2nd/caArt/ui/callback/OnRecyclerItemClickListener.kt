package org.softeer_2nd.caArt.ui.callback

fun interface OnRecyclerItemClickListener<DATA_T> {

    fun onItemClicked(position: Int, data: DATA_T)
}