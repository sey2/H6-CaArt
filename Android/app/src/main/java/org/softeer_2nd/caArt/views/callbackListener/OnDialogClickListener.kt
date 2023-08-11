package org.softeer_2nd.caArt.views.callbackListener

import androidx.fragment.app.DialogFragment

fun interface OnDialogClickListener {
    fun onButtonClicked(dialog: DialogFragment)
}