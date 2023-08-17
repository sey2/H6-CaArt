package org.softeer_2nd.caArt.ui.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.DialogCaartBinding
import org.softeer_2nd.caArt.ui.callback.OnDialogClickListener
import org.softeer_2nd.caArt.util.dp2px

open class CaArtDialog(private val builder: Builder) : DialogFragment() {

    companion object {
        const val DOUBLE = 0
        const val SINGLE = 1

        const val NONE = 0
        const val EDITABLE_TEXT_CONTENT = 1
        const val TEXT_CONTENT = 2
        const val VIEW_CONTENT = 3
    }

    val contentText get() = binding.etCaartDialogTextContent.text.toString()

    private var _binding: DialogCaartBinding? = null
    private val binding get() = _binding!!

    override fun onStart() {
        super.onStart()
        val width = builder.dialogWidth ?: return
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogCaartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.builder = builder
        binding.dialog = this
        if (builder.dialogType == VIEW_CONTENT) {
            builder.contentView?.let { changeContent(it) }
            builder.contentViewRes?.let { changeContent(it) }
        }
    }

    private fun changeContent(view: View) {
        val lp = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        val content = view.apply {
            layoutParams = lp
        }
        binding.flCaartDialogContentContainer.apply {
            removeAllViews()
            addView(content)
        }
    }

    private fun changeContent(res: Int) {
        val content = layoutInflater.inflate(res, binding.flCaartDialogContentContainer, false)
        changeContent(content)
    }

    open class Builder(
        private val context: Context
    ) {

        var dialogWidth = context.resources?.getDimensionPixelSize(R.dimen.two_buttons_dialog_width)
        var title: String? = null
        var titleTextSize: Int = 16
        var description: String? = null
        var positiveButtonText: String? = context.getString(R.string.yes)
        var negativeButtonText: String? = context.getString(R.string.no)
        var positiveButtonClickListener: OnDialogClickListener? = null
        var negativeButtonClickListener: OnDialogClickListener? = OnDialogClickListener {
            it.dismiss()
        }
        var buttonType: Int = DOUBLE
        var dialogType: Int = NONE
        var contentText: String? = null
        var contentHintText: String? = null
        var contentView: View? = null
        var contentViewRes: Int? = null

        fun setTitle(title: String, size: Int = 16): Builder = apply {
            this.title = title
            titleTextSize = size
        }

        fun setDescription(description: String) = apply { this.description = description }

        fun setPositiveButton(text: String? = null, listener: OnDialogClickListener): Builder {
            positiveButtonText = text ?: context.getString(R.string.yes)
            positiveButtonClickListener = listener
            return this
        }

        fun setNegativeButton(text: String? = null, listener: OnDialogClickListener): Builder {
            negativeButtonText = text ?: context.getString(R.string.no)
            negativeButtonClickListener = OnDialogClickListener {
                listener.onButtonClicked(it)
                it.dismiss()
            }
            return this
        }

        fun setButtonType(type: Int) = apply { buttonType = type }

        fun setContentText(text: String = "", hint: String = "", isEditable: Boolean) = apply {
            contentText = text
            contentHintText = hint
            dialogType = if (isEditable) EDITABLE_TEXT_CONTENT else TEXT_CONTENT
        }

        fun setDialogContentView(res: Int) = apply {
            dialogWidth = dialogWidth ?: (280f.dp2px(context) + 10f.dp2px(context))
            dialogType = VIEW_CONTENT
            contentViewRes = res
        }

        fun setDialogContentView(view: View) = apply {
            dialogWidth = dialogWidth ?: (280f.dp2px(context) + 10f.dp2px(context))
            dialogType = VIEW_CONTENT
            contentView = view
        }

        fun build() = CaArtDialog(this)
    }
}