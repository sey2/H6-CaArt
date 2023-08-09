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
import org.softeer_2nd.caArt.databinding.FragmentCarTrimChoiceBinding
import org.softeer_2nd.caArt.factorys.DummyItemFactory
import org.softeer_2nd.caArt.models.OptionTrimSelectionDummyItem
import org.softeer_2nd.caArt.recyclerAdapters.TrimOptionSelectionAdapter

import org.softeer_2nd.caArt.viewmodels.CarTrimChoiceViewModel

class CarTrimChoiceFragment : Fragment() {
    private var _binding: FragmentCarTrimChoiceBinding? = null
    private val binding get() = _binding!!

    private val carTrimChoiceViewModel by viewModels<CarTrimChoiceViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarTrimChoiceBinding.inflate(inflater, container, false).apply {
            incEngineBodyOption.carTrimChoiceViewModel =
                this@CarTrimChoiceFragment.carTrimChoiceViewModel
            lifecycleOwner = viewLifecycleOwner
            bottomSheet.setMode(BottomSheetMode.Next)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTrim.apply {
            initializeColorOptions(DummyItemFactory.createSelectionTrimItemDummyItems())
        }
    }

    private fun RecyclerView.initializeColorOptions(
        items: List<OptionTrimSelectionDummyItem>
    ) {

        this.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        this.adapter = TrimOptionSelectionAdapter(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}