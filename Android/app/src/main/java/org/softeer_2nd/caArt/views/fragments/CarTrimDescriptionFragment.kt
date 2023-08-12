package org.softeer_2nd.caArt.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import org.softeer_2nd.caArt.databinding.FragmentCarTrimDescriptionBinding
import org.softeer_2nd.caArt.views.recyclerAdapters.TrimDescriptionPagerAdapter

class CarTrimDescriptionFragment() : Fragment() {

    private var _binding: FragmentCarTrimDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarTrimDescriptionBinding.inflate(inflater, container, false).apply {
            vpTrimDescription.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            vpTrimDescription.adapter = TrimDescriptionPagerAdapter()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}