package org.softeer_2nd.caArt.ui.callback

import android.view.View

fun interface OnItemClickListener<DATA_T> {
    fun onItemClicked(data:DATA_T?)
}