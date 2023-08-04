package org.softeer_2nd.caArt.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.DialogTwoButtonsBinding
import org.softeer_2nd.caArt.interfaces.OnButtonClickListener

class TwoButtonsDialog(
    private val title: String,
    private val description: String,
    private val primaryButtonText: String? = null,
    private val secondaryButtonText: String? = null
) : DialogFragment() {

    private var _binding: DialogTwoButtonsBinding? = null
    private val binding get() = _binding!!

    private var primaryButtonClickListener: OnButtonClickListener<Unit>? = null
    private var secondaryButtonClickListener: OnButtonClickListener<Unit>? = null

    override fun onStart() {
        super.onStart()
        val width =
            context?.resources?.getDimensionPixelSize(R.dimen.two_buttons_dialog_width) ?: return
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogTwoButtonsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.let {
            it.dialog = this
            it.title = title
            it.description = description
            it.primaryButtonText = primaryButtonText
            it.secondaryButtonText = secondaryButtonText
        }
    }

    fun setOnPrimaryButtonClickListener(listener: OnButtonClickListener<Unit>) {
        this.primaryButtonClickListener = listener
    }

    fun setOnSecondaryButtonClickListener(listener: OnButtonClickListener<Unit>) {
        this.secondaryButtonClickListener = listener
    }

    fun onPrimaryButtonClicked() = primaryButtonClickListener?.onButtonClicked(null)

    fun onSecondaryButtonClicked() = secondaryButtonClickListener?.onButtonClicked(null)

}