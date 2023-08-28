package org.softeer_2nd.caArt.ui.callback
fun interface OnItemClickListener<DATA_T> {
    fun onItemClicked(data:DATA_T?)
}