package org.softeer_2nd.caArt.interfaces

fun interface OnButtonClickListener<T> {
    fun onButtonClicked(msg: T?)
}