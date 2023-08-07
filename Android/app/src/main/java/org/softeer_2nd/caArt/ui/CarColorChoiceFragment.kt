package org.softeer_2nd.caArt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.BottomSheetMode
import org.softeer_2nd.caArt.recyclerAdapters.ColorOptionSelectionAdapter
import org.softeer_2nd.caArt.databinding.FragmentCarColorChoiceBinding
import org.softeer_2nd.caArt.factorys.CarColorChoiceViewModelFactory
import org.softeer_2nd.caArt.factorys.DummyItemFactory
import org.softeer_2nd.caArt.repositorys.CarExteriorImageRepository
import org.softeer_2nd.caArt.viewmodels.CarColorChoiceViewModel

class CarColorChoiceFragment() : Fragment() {
    private var _binding: FragmentCarColorChoiceBinding? = null
    private val binding get() = _binding!!
    private val imageRepository by lazy { CarExteriorImageRepository(requireContext()) }
    private val carColorChoiceViewModel by viewModels<CarColorChoiceViewModel> { CarColorChoiceViewModelFactory(imageRepository) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCarColorChoiceBinding.inflate(inflater, container, false).apply {
            this.viewModel = this@CarColorChoiceFragment.carColorChoiceViewModel
            lifecycleOwner = viewLifecycleOwner
            bottomSheet.setMode(BottomSheetMode.PrevAndNext)
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecyclerView(
            binding.rvInteriorColor,
            ColorOptionSelectionAdapter(DummyItemFactory.createOptionInteriorColorDummyItems())
        )

        initializeRecyclerView(
            binding.rvExteriorColor,
            ColorOptionSelectionAdapter(DummyItemFactory.createOptionExteriorColorDummyItems())
        )
    }

    private fun initializeRecyclerView(recyclerView: RecyclerView, adapter: ColorOptionSelectionAdapter) {
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
