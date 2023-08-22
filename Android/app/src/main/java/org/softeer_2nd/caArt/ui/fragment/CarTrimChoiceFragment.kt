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
import org.softeer_2nd.caArt.ui.dialog.CaArtDialog
import org.softeer_2nd.caArt.model.factory.DummyItemFactory
import org.softeer_2nd.caArt.ui.callback.OnTrimItemClickListener
import org.softeer_2nd.caArt.ui.recycleradapter.OptionChangePopupAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.TrimOptionSelectionAdapter
import org.softeer_2nd.caArt.util.StringFormatter
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

        //createChangePopup(false)
        return binding.root
    }

    private fun setupObservers() {
        carTrimChoiceViewModel.trims.observe(viewLifecycleOwner) { trims ->
            (binding.rvTrim.adapter as TrimOptionSelectionAdapter).updateTrimItems(trims)
        }

        userChoiceViewModel.selectedEngine.observe(viewLifecycleOwner) { engine ->
            val str = StringFormatter.combineCarComposition(
                engine.itemName,
                userChoiceViewModel.selectedBodyType.value!!.itemName,
                userChoiceViewModel.selectedWheelDrive.value!!.itemName
            )
            (binding.rvTrim.adapter as TrimOptionSelectionAdapter).updateSpecifications(str)
        }

        userChoiceViewModel.selectedBodyType.observe(viewLifecycleOwner) { bodyType  ->
            val str = StringFormatter.combineCarComposition(
                userChoiceViewModel.selectedEngine.value!!.itemName,
                bodyType.itemName,
                userChoiceViewModel.selectedWheelDrive.value!!.itemName
            )
            (binding.rvTrim.adapter as TrimOptionSelectionAdapter).updateSpecifications(str)
        }


        userChoiceViewModel.selectedWheelDrive.observe(viewLifecycleOwner) { wheelDrive  ->
            val str = StringFormatter.combineCarComposition(
                userChoiceViewModel.selectedEngine.value!!.itemName,
                userChoiceViewModel.selectedBodyType.value!!.itemName,
                wheelDrive.itemName
            )
            (binding.rvTrim.adapter as TrimOptionSelectionAdapter).updateSpecifications(str)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
        setupRecyclerView()
    }

    private fun setupBinding() {
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
        }
    }

    private fun setupRecyclerView() {
        binding.rvTrim.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TrimOptionSelectionAdapter(this@CarTrimChoiceFragment)
            itemAnimator = null
        }
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
    }
}
