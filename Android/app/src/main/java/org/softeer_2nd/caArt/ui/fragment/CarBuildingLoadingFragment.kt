package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.databinding.FragmentCarBuildingLoadingBinding
import java.lang.IllegalStateException

class CarBuildingLoadingFragment : Fragment() {

    companion object {
        const val DEFAULT_LOADING_DURATION = 2000L
    }

    private var _binding: FragmentCarBuildingLoadingBinding? = null
    private val binding get() = _binding!!

    private val args: CarBuildingLoadingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarBuildingLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                delay(args.loadingDuration)
                findNavController().navigate(CarBuildingLoadingFragmentDirections.actionCarBuildingLoadingFragmentToEstimateFragment())
            } catch (e: IllegalStateException) {
                findNavController().navigate(CarBuildingLoadingFragmentDirections.actionCarBuildingLoadingFragmentToEstimateFragment())
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}