package org.softeer_2nd.caArt.ui.callback

fun interface OnDialogDismissListener<T> {
    fun onDialogDismissed(res: T)
}