package org.softeer_2nd.caArt.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import org.softeer_2nd.caArt.models.datas.BottomSheetMode
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.views.recyclerAdapters.ColorOptionSelectionAdapter
import org.softeer_2nd.caArt.databinding.FragmentCarColorChoiceBinding
import org.softeer_2nd.caArt.databinding.LayoutChangePopupBinding
import org.softeer_2nd.caArt.views.dialogs.CaArtDialog
import org.softeer_2nd.caArt.models.factorys.CarColorChoiceViewModelFactory
import org.softeer_2nd.caArt.models.factorys.DummyItemFactory
import org.softeer_2nd.caArt.views.callbackListener.OnOtherColorItemClickListener
import org.softeer_2nd.caArt.models.dummys.OptionColorDummyItem
import org.softeer_2nd.caArt.views.recyclerAdapters.OptionChangePopupAdapter
import org.softeer_2nd.caArt.models.repositorys.CarExteriorImageRepository
import org.softeer_2nd.caArt.viewmodels.CarColorChoiceViewModel

class CarColorChoiceFragment() : Fragment(), OnOtherColorItemClickListener {
    private var _binding: FragmentCarColorChoiceBinding? = null
    private val binding get() = _binding!!
    private val carColorChoiceViewModel by viewModels<CarColorChoiceViewModel> {
        CarColorChoiceViewModelFactory(
            CarExteriorImageRepository(requireContext())
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarColorChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            rvInteriorColor.initializeColorOptions(
                this@CarColorChoiceFragment,
                DummyItemFactory.createOptionInteriorColorDummyItems(),
                false
            )

            rvExteriorColor.initializeColorOptions(
                this@CarColorChoiceFragment,
                DummyItemFactory.createOptionExteriorColorDummyItems(),
                false
            )

            incOtherExteriorColorOption.rvOtherExteriorOption.initializeColorOptions(
                this@CarColorChoiceFragment,
                DummyItemFactory.createOptionExteriorOtherColorDummyItems(),
                true
            )

            incOtherInteriorColorOption.rvOtherExteriorOption.initializeColorOptions(
                this@CarColorChoiceFragment,
                DummyItemFactory.createOptionInteriorOtherColorDummyItems(),
                true
            )

            this.viewModel = this@CarColorChoiceFragment.carColorChoiceViewModel
            lifecycleOwner = viewLifecycleOwner

            colorSummryBottomSheet.setMode(
                BottomSheetMode.PrevAndNext,
                CarColorChoiceFragmentDirections.actionCarColorChoiceFragmentToCarOptionChoiceFragment()
            )

            incOtherExteriorColorOption.handleText =
                getString(R.string.ask_search_other_exterior_color)
            incOtherInteriorColorOption.handleText =
                getString(R.string.ask_search_other_interior_color)
        }

    }

    private fun RecyclerView.initializeColorOptions(
        fragment: CarColorChoiceFragment,
        items: List<OptionColorDummyItem>,
        isOtherColorOption: Boolean
    ) {
        if (isOtherColorOption) {
            this.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        } else {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        this.adapter = ColorOptionSelectionAdapter(fragment, items, isOtherColorOption)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(changeOptionTitle: String) {
        val layoutInflater = LayoutInflater.from(requireContext())
        val dialogContent = LayoutChangePopupBinding.inflate(layoutInflater).apply {
            topOptionTitle = "현재 트림"
            bottomOptionTitle = "변경 트림"
            showGuidePrice = true
            guideChangePrice = "+ 12,100,000원"
        }

        val topOptionAdapter =
            OptionChangePopupAdapter(DummyItemFactory.createCurrentTrimOptionDummyItems())
        val bottomOptionAdapter =
            OptionChangePopupAdapter(DummyItemFactory.createChangeTrimOptionDummyItems())

        dialogContent.rvTop.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topOptionAdapter
        }

        dialogContent.rvBottom.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomOptionAdapter
        }

        CaArtDialog.Builder(requireContext())
            .setTitle("$changeOptionTitle 트림으로 변경\n하시겠어요?")
            .setDescription("인조가죽 (블랙) 색상은 트림 변경 후 선택할 수 있어요.")
            .setDialogContentView(dialogContent.root)
            .setPositiveButton(text = "변경하기", listener = {})
            .build()
            .show(childFragmentManager, "colorOptionChangePopup")
    }

}
