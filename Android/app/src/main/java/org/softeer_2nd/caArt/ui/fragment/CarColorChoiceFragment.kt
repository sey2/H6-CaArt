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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.softeer_2nd.caArt.model.data.typeEnum.BottomSheetMode
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.ui.recycleradapter.ColorOptionSelectionAdapter
import org.softeer_2nd.caArt.databinding.FragmentCarColorChoiceBinding
import org.softeer_2nd.caArt.databinding.LayoutChangePopupBinding
import org.softeer_2nd.caArt.model.data.ChoiceColorItem
import org.softeer_2nd.caArt.model.data.OptionChangePopUpItem
import org.softeer_2nd.caArt.model.data.dto.InteriorColor
import org.softeer_2nd.caArt.model.data.dto.toChoiceColorItems
import org.softeer_2nd.caArt.ui.callback.OnOtherColorItemClickListener
import org.softeer_2nd.caArt.ui.dialog.CaArtDialog
import org.softeer_2nd.caArt.ui.recycleradapter.OptionChangePopupAdapter
import org.softeer_2nd.caArt.util.StringFormatter.setFormattedPrice
import org.softeer_2nd.caArt.viewmodel.CarColorChoiceViewModel
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel

@AndroidEntryPoint
class CarColorChoiceFragment() : Fragment(), OnOtherColorItemClickListener {
    private var _binding: FragmentCarColorChoiceBinding? = null
    private val binding get() = _binding!!
    private val userChoiceViewModel by activityViewModels<UserChoiceViewModel>()
    private val carColorChoiceViewModel by viewModels<CarColorChoiceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarColorChoiceBinding.inflate(inflater, container, false)
        carColorChoiceViewModel.getImages(userChoiceViewModel.selectedTrimIndex.value!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            binding.incTopColorChoiceIndicator.currentIndex = 1

            listOf(
                Triple(rvExteriorColor, false, true),
                Triple(rvInteriorColor, false, false),
                Triple(incOtherExteriorColorOption.rvOtherExteriorOption, true, true),
                Triple(incOtherInteriorColorOption.rvOtherExteriorOption, true, false)
            ).forEach { (recyclerView, isOther, isExteriorColor) ->
                recyclerView.initializeColorOptions(
                    this@CarColorChoiceFragment,
                    isOther,
                    isExteriorColor
                )
            }

            colorSummryBottomSheet.setMode(
                BottomSheetMode.PrevAndNext,
                CarColorChoiceFragmentDirections.actionCarColorChoiceFragmentToCarOptionChoiceFragment()
            )

            colorSummryBottomSheet.setViewModel(userChoiceViewModel, viewLifecycleOwner)

            this.viewModel = carColorChoiceViewModel
            this.userViewModel = userChoiceViewModel
            lifecycleOwner = viewLifecycleOwner

            incOtherExteriorColorOption.handleText =
                getString(R.string.ask_search_other_exterior_color)
            incOtherInteriorColorOption.handleText =
                getString(R.string.ask_search_other_interior_color)
        }

        setupObservers()
    }

    private fun RecyclerView.initializeColorOptions(
        listener: OnOtherColorItemClickListener,
        isOtherColorOption: Boolean,
        isExteriorColor: Boolean
    ) {
        if (isOtherColorOption) {
            this.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        } else {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        this.adapter = ColorOptionSelectionAdapter(
            listener,
            isOtherColorOption,
            isExteriorColor = isExteriorColor
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(
        item: ChoiceColorItem,
        isOtherColor: Boolean,
        isExteriorColor: Boolean,
        index: Int,
    ) {
        if (!isOtherColor) {
            if (isExteriorColor) {
                val exteriorColor = carColorChoiceViewModel.colorData.value?.exteriorColors!![index]
                userChoiceViewModel.setSelectedExteriorColor(exteriorColor)
                carColorChoiceViewModel.updateCurrentExteriorUrls(index)
            } else {
                val interiorColor = carColorChoiceViewModel.colorData.value?.interiorColors!![index]
                userChoiceViewModel.setSelectedInteriorColor(interiorColor)
            }
            return
        }

        createDialog(item, index, isExteriorColor)
    }


    private fun createDialog(changeItem: ChoiceColorItem, index: Int, isExteriorColor: Boolean) {
        val curTrim = userChoiceViewModel.selectedTrim.value ?: return
        val sub = changeItem.trimPrice - curTrim.trimPrice
        val formattedSub = if (sub > 0) "+ ${sub.setFormattedPrice()}" else sub.setFormattedPrice()

        LayoutChangePopupBinding.inflate(LayoutInflater.from(requireContext())).apply {
            bottomOptionVisible = true
            topOptionTitle = getString(R.string.current_trim)
            bottomOptionTitle = getString(R.string.change_trim)
            showGuidePrice = true
            guideChangePrice = formattedSub

            rvTop.setupOptionAdapter(
                listOf(
                    OptionChangePopUpItem(
                        curTrim.trimName,
                        curTrim.trimPrice.setFormattedPrice()
                    )
                )
            )
            rvBottom.setupOptionAdapter(
                listOf(
                    OptionChangePopUpItem(
                        changeItem.trimName,
                        changeItem.trimPrice.setFormattedPrice()
                    )
                )
            )

            CaArtDialog.Builder(requireContext())
                .setTitle("${changeItem.tag} ${getString(R.string.trim_change_popup_message)}")
                .setDescription("${changeItem.colorName} ${getString(R.string.infomation_change_color_popup)}")
                .setDialogContentView(root)
                .setPositiveButton(text = getString(R.string.change), listener = {

                    userChoiceViewModel.setSelectedTrimIndex(changeItem.trimId)
                    val userChoiceTrim = userChoiceViewModel.selectedTrim.value
                    userChoiceTrim!!.trimName = changeItem.trimName
                    userChoiceTrim.trimPrice = changeItem.trimPrice
                    userChoiceViewModel.setSelectedTrim(userChoiceTrim)

                    if (!isExteriorColor) {
                        userChoiceViewModel.setSelectedInteriorColor(
                            InteriorColor(
                                index,
                                changeItem.colorName,
                                changeItem.imgUrl,
                                0,
                                0,
                                changeItem.preview
                            )
                        )
                    }
                    findNavController().popBackStack()
                })
                .build()
                .show(childFragmentManager, "colorOptionChangePopup")
        }
    }

    private fun RecyclerView.setupOptionAdapter(items: List<OptionChangePopUpItem>) {
        layoutManager = LinearLayoutManager(context)
        adapter = OptionChangePopupAdapter(items)
    }

    private fun setupObservers() {
        carColorChoiceViewModel.colorData.observe(viewLifecycleOwner) { colorData ->
            binding.apply {
                val (matchedExteriorIndex, matchedInteriorIndex) = userChoiceViewModel.findMatchedIndices(colorData)

                val exteriorColor =
                    carColorChoiceViewModel.colorData.value?.exteriorColors!![matchedExteriorIndex]
                userChoiceViewModel.setSelectedExteriorColor(exteriorColor)
                carColorChoiceViewModel.updateCurrentExteriorUrls(matchedExteriorIndex)

                userChoiceViewModel.setSelectedInteriorColor(carColorChoiceViewModel.colorData.value?.interiorColors!![matchedInteriorIndex])

                (rvExteriorColor.adapter as ColorOptionSelectionAdapter).updateItem(
                    colorData.exteriorColors.toChoiceColorItems(),
                    matchedExteriorIndex,
                    matchedInteriorIndex
                )
                (rvInteriorColor.adapter as ColorOptionSelectionAdapter).updateItem(
                    colorData.interiorColors.toChoiceColorItems(),
                    matchedInteriorIndex,
                    matchedInteriorIndex
                )
                (incOtherExteriorColorOption.rvOtherExteriorOption.adapter as ColorOptionSelectionAdapter).updateItem(
                    colorData.otherTrimExteriorColors.toChoiceColorItems()
                )
                (incOtherInteriorColorOption.rvOtherExteriorOption.adapter as ColorOptionSelectionAdapter).updateItem(
                    colorData.otherTrimInteriorColors.toChoiceColorItems()
                )
            }
        }
    }
}
