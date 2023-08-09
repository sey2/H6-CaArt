package org.softeer_2nd.caArt.ui.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.softeer_2nd.caArt.BottomSheetMode
import org.softeer_2nd.caArt.databinding.FragmentCarOptionChoiceBinding

class CarOptionChoiceFragment : Fragment() {
    private var _binding: FragmentCarOptionChoiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarOptionChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.bsOptionChoiceSummary.setMode(BottomSheetMode.PrevAndEstimate)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}