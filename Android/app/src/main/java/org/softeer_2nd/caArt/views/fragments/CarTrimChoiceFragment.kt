package org.softeer_2nd.caArt.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.models.datas.BottomSheetMode
import org.softeer_2nd.caArt.databinding.FragmentCarTrimChoiceBinding
import org.softeer_2nd.caArt.databinding.LayoutChangePopupBinding
import org.softeer_2nd.caArt.views.dialogs.CaArtDialog
import org.softeer_2nd.caArt.models.factorys.DummyItemFactory
import org.softeer_2nd.caArt.models.dummys.OptionTrimSelectionDummyItem
import org.softeer_2nd.caArt.views.recyclerAdapters.OptionChangePopupAdapter
import org.softeer_2nd.caArt.views.recyclerAdapters.TrimOptionSelectionAdapter

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

        createChangePopup(false)
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

    private fun createChangePopup(bottomOptionVisible: Boolean){
        val layoutInflater = LayoutInflater.from(requireContext())
        val dialogContent = LayoutChangePopupBinding.inflate(layoutInflater).apply {
            topOptionTitle = "현재 되는 내장 색상"
            bottomOptionTitle = "해제되는 옵션"
            showGuidePrice = false
            this.bottomOptionVisible = bottomOptionVisible
            guideChangePrice = "+ 12,100,000원"
        }

        val topOptionAdapter = OptionChangePopupAdapter(DummyItemFactory.createInteriorColorOptionChangeDummyItems())
        val bottomOptionAdapter = OptionChangePopupAdapter(DummyItemFactory.createDefaultOptionChangeDummyItems())

        dialogContent.rvTop.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topOptionAdapter
        }

        dialogContent.rvBottom.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomOptionAdapter
        }

        val description = if(bottomOptionVisible) "지금 변경하시면 선택한 색상과 옵션이 해제돼요" else "지금 변경하시면 선택한 색상이 해제돼요."

        CaArtDialog.Builder(requireContext())
            .setTitle("Exclusive 트림으로 변경\n하시겠어요?")
            .setDescription(description)
            .setDialogContentView(dialogContent.root)
            .setPositiveButton(text = "변경하기", listener = {})
            .build()
            .show(childFragmentManager, "colorOptionChangePopup")
    }

}