package org.softeer_2nd.caArt.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import org.softeer_2nd.caArt.databinding.FragmentCarTrimDescriptionBinding
import org.softeer_2nd.caArt.model.factory.DummyItemFactory
import org.softeer_2nd.caArt.view.recyclerAdapter.TrimDescriptionPagerAdapter

class CarTrimDescriptionFragment() : Fragment() {

    private var _binding: FragmentCarTrimDescriptionBinding? = null
    private val binding get() = _binding!!

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

        binding.apply {
            vpTrimContainer.adapter =
                TrimDescriptionPagerAdapter(DummyItemFactory.createDescriptionDummyItems())

            TabLayoutMediator(tlTrimDescriptionCategory, vpTrimContainer) { tab, position ->
                when (position) {
                    0 -> tab.text = "엔진"
                    1 -> tab.text = "바디"
                    2 -> tab.text = "구동방식"
                }
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}