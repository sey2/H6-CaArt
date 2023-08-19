package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import org.softeer_2nd.caArt.databinding.FragmentCarTrimDescriptionBinding
import org.softeer_2nd.caArt.ui.recycleradapter.TrimDescriptionPagerAdapter
import org.softeer_2nd.caArt.viewmodel.CarTrimDescriptionViewModel
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel

class CarTrimDescriptionFragment() : Fragment() {

    private var _binding: FragmentCarTrimDescriptionBinding? = null
    private val binding get() = _binding!!

    private val carTrimDescriptionViewModel by viewModels<CarTrimDescriptionViewModel>()

    private val userChoiceViewModel by activityViewModels<UserChoiceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarTrimDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carTrimDescriptionViewModel.getCompositions()

        binding.apply {
            vpTrimContainer.adapter =
                TrimDescriptionPagerAdapter()

            TabLayoutMediator(tlTrimDescriptionCategory, vpTrimContainer) { tab, position ->
                when (position) {
                    0 -> tab.text = "엔진"
                    1 -> tab.text = "바디"
                    2 -> tab.text = "구동방식"
                }
            }.attach()
        }

        carTrimDescriptionViewModel.composition.observe(viewLifecycleOwner) {
            (binding.vpTrimContainer.adapter as TrimDescriptionPagerAdapter).updateItems(
                carTrimDescriptionViewModel.composition.value!!
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}