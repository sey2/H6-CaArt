package org.softeer_2nd.caArt.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.util.dp2px

class LoadingDialog(context: Context) : Dialog(context) {

    init {
        setCanceledOnTouchOutside(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_loading)
        val width = context.resources.displayMetrics.widthPixels - 50f.dp2px(context)
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}