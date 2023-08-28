package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import org.softeer_2nd.caArt.model.data.typeEnum.BottomSheetMode
import org.softeer_2nd.caArt.databinding.FragmentCarTrimChoiceBinding
import org.softeer_2nd.caArt.databinding.LayoutChangePopupBinding
import org.softeer_2nd.caArt.model.data.OptionChangePopUpItem
import org.softeer_2nd.caArt.model.data.toExteriorColor
import org.softeer_2nd.caArt.model.data.toInteriorColor
import org.softeer_2nd.caArt.ui.dialog.CaArtDialog
import org.softeer_2nd.caArt.model.factory.DummyItemFactory
import org.softeer_2nd.caArt.ui.callback.OnTrimItemClickListener
import org.softeer_2nd.caArt.ui.recycleradapter.OptionChangePopupAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.TrimOptionSelectionAdapter
import org.softeer_2nd.caArt.viewmodel.CarTrimChoiceViewModel
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel

@AndroidEntryPoint
class CarTrimChoiceFragment : Fragment(), OnTrimItemClickListener {

    private var _binding: FragmentCarTrimChoiceBinding? = null
    private val binding get() = _binding!!

    private val userChoiceViewModel by activityViewModels<UserChoiceViewModel>()
    private val carTrimChoiceViewModel by viewModels<CarTrimChoiceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarTrimChoiceBinding.inflate(inflater, container, false)
        setupObservers()

        carTrimChoiceViewModel.getTrims()
        carTrimChoiceViewModel.getCompositions()

        return binding.root
    }

    private fun setupObservers() {
        carTrimChoiceViewModel.trims.observe(viewLifecycleOwner) { trims ->
            binding.rvTrim.adapter?.let { adapter ->
                if (adapter is TrimOptionSelectionAdapter) {
                    adapter.updateTrimItems(trims)
                    updateSpecifications()
                }
            }

            if (userChoiceViewModel.selectedTrim.value == null) {
                userChoiceViewModel.setSelectedTrim(trims.first())
                userChoiceViewModel.setSelectedExteriorColor(trims.first().exteriorColors[5].toExteriorColor())
                userChoiceViewModel.setSelectedInteriorColor(trims.first().interiorColors[0].toInteriorColor())
            } else {
                val selectedTrimIndex =
                    carTrimChoiceViewModel.findMatchedTrimIndices(userChoiceViewModel.selectedTrim.value!!)
                userChoiceViewModel.setSelectedTrimIndex(selectedTrimIndex + 1)
                userChoiceViewModel.selectedTrim.value?.trimImage = userChoiceViewModel.selectedExteriorColor.value?.previews?.get(0) ?: ""
                binding.rvTrim.adapter?.let { adapter ->
                    if (adapter is TrimOptionSelectionAdapter) {
                        adapter.updateSelectedState(selectedTrimIndex)
                    }
                }
            }
        }

        carTrimChoiceViewModel.composition.observe(viewLifecycleOwner) { compositions ->
            if (userChoiceViewModel.selectedEngine.value == null)
                userChoiceViewModel.setSelectedEngine(compositions.carEngines[0])
            if (userChoiceViewModel.selectedBodyType.value == null)
                userChoiceViewModel.setSelectedBodyType(compositions.bodyTypes[0])
            if (userChoiceViewModel.selectedWheelDrive.value == null)
                userChoiceViewModel.setSelectedWheelDrive(compositions.wheelDrives[0])

            listOf(
                userChoiceViewModel.selectedEngine,
                userChoiceViewModel.selectedBodyType,
                userChoiceViewModel.selectedWheelDrive
            ).forEach { liveData ->
                liveData.observe(viewLifecycleOwner) {
                    updateSpecifications()
                }
            }

            userChoiceViewModel.selectedTrimIndex.observe(viewLifecycleOwner) { index ->
                carTrimChoiceViewModel.trims.value?.let { trims ->
                    userChoiceViewModel.setSelectedTrim(trims[index - 1])
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
        setupRecyclerView()
    }

    private fun setupBinding() {
        carTrimChoiceViewModel.setIsToolTipVisible(true)

        binding.apply {
            incEngineBodyOption.carTrimChoiceViewModel = carTrimChoiceViewModel
            incEngineBodyOption.userChoiceViewModel = userChoiceViewModel
            trimChoiceViewModel = this@CarTrimChoiceFragment.carTrimChoiceViewModel
            userViewModel = userChoiceViewModel
            lifecycleOwner = viewLifecycleOwner

            trimSummaryBottomSheet.setViewModel(userChoiceViewModel, viewLifecycleOwner)

            trimSummaryBottomSheet.setMode(
                BottomSheetMode.Next,
                CarTrimChoiceFragmentDirections.actionCarTrimChoiceFragmentToCarColorChoiceFragment()
            )

            tvQuestion.setOnClickListener {
                findNavController().navigate(CarTrimChoiceFragmentDirections.actionCarTrimChoiceFragmentToCarTrimDescriptionFragment())
            }

            viewToolTip.post {
                viewToolTip.tag = viewToolTip.height
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvTrim.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TrimOptionSelectionAdapter(
                this@CarTrimChoiceFragment,
                (userChoiceViewModel.selectedTrimIndex.value ?: 1) - 1
            )
            itemAnimator = null
        }
    }

    private fun updateSpecifications() {
        val specifications = userChoiceViewModel.getSpecifications()
        val compositionTotalPrice = userChoiceViewModel.getCompositionTotalPrice()

        (binding.rvTrim.adapter as? TrimOptionSelectionAdapter)?.updateCompositions(specifications, compositionTotalPrice)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createChangePopup(bottomOptionVisible: Boolean) {
        val dialogContent =
            LayoutChangePopupBinding.inflate(LayoutInflater.from(requireContext())).apply {
                topOptionTitle = "현재 되는 내장 색상"
                bottomOptionTitle = "해제되는 옵션"
                showGuidePrice = false
                this.bottomOptionVisible = bottomOptionVisible
                guideChangePrice = "+ 12,100,000원"
            }
        setupPopupRecyclerView(dialogContent)

        val description = getDescription(bottomOptionVisible)
        showCaArtDialog(description, dialogContent.root)
    }

    private fun setupPopupRecyclerView(dialogContent: LayoutChangePopupBinding) {
        dialogContent.rvTop.setupOptionChangeAdapter(DummyItemFactory.createInteriorColorOptionChangeDummyItems())
        dialogContent.rvBottom.setupOptionChangeAdapter(DummyItemFactory.createDefaultOptionChangeDummyItems())
    }

    private fun getDescription(bottomOptionVisible: Boolean): String {
        return if (bottomOptionVisible) "지금 변경하시면 선택한 색상과 옵션이 해제돼요" else "지금 변경하시면 선택한 색상이 해제돼요."
    }

    private fun RecyclerView.setupOptionChangeAdapter(items: List<OptionChangePopUpItem>) {
        layoutManager = LinearLayoutManager(context)
        adapter = OptionChangePopupAdapter(items)
    }

    private fun showCaArtDialog(description: String, view: View) {
        CaArtDialog.Builder(requireContext())
            .setTitle("Exclusive 트림으로 변경\n하시겠어요?")
            .setDescription(description)
            .setDialogContentView(view)
            .setPositiveButton("변경하기") {}
            .build()
            .show(childFragmentManager, "colorOptionChangePopup")
    }

    override fun onItemClicked(itemIndx: Int) {
        val selectedTrim = carTrimChoiceViewModel.trims.value?.get(itemIndx) ?: return
        userChoiceViewModel.setSelectedTrim(selectedTrim)
        userChoiceViewModel.setSelectedTrimIndex(itemIndx + 1)
    }
}
