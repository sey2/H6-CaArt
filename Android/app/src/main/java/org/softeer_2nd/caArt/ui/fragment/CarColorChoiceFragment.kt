package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.request.CachePolicy
import coil.request.ImageRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.model.data.typeEnum.BottomSheetMode
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.ui.recycleradapter.ColorOptionSelectionAdapter
import org.softeer_2nd.caArt.databinding.FragmentCarColorChoiceBinding
import org.softeer_2nd.caArt.databinding.LayoutChangePopupBinding
import org.softeer_2nd.caArt.model.data.ChoiceColorItem
import org.softeer_2nd.caArt.model.data.OptionChangePopUpItem
import org.softeer_2nd.caArt.model.data.dto.toChoiceColorItems
import org.softeer_2nd.caArt.ui.callback.OnOtherColorItemClickListener
import org.softeer_2nd.caArt.ui.dialog.CaArtDialog
import org.softeer_2nd.caArt.ui.recycleradapter.OptionChangePopupAdapter
import org.softeer_2nd.caArt.util.CoilUtils
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
        carColorChoiceViewModel.getImages(1)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            listOf(
                rvExteriorColor to false,
                rvInteriorColor to false,
                incOtherExteriorColorOption.rvOtherExteriorOption to true,
                incOtherInteriorColorOption.rvOtherExteriorOption to true
            ).forEach { (recyclerView, isOther) ->
                recyclerView.initializeColorOptions(this@CarColorChoiceFragment, isOther)
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
        fragment: CarColorChoiceFragment,
        isOtherColorOption: Boolean
    ) {
        if (isOtherColorOption) {
            this.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        } else {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        this.adapter = ColorOptionSelectionAdapter(fragment, isOtherColorOption)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onItemClicked(
        item: ChoiceColorItem,
        isOtherColor: Boolean,
        index: Int,
    ) {
        if (!isOtherColor) {
            if (item.isExteriorColor) {
                val exteriorColor = carColorChoiceViewModel.colorData.value?.exteriorColors!![index]
                userChoiceViewModel.setExteriorColor(exteriorColor)
            } else {
                val interiorColor = carColorChoiceViewModel.colorData.value?.interiorColors!![index]
                userChoiceViewModel.setInteriorColor(interiorColor)
            }
            carColorChoiceViewModel.updateCurrentImageUrl(index)
            return
        }

        createDialog(item.tag, item.colorName, item.colorPrice, item.trimName)
    }


    private fun createDialog(
        changeOptionTitle: String,
        changeColorName: String,
        changeColorPrice: Long,
        trimName: String
    ) {
        val curTrim = userChoiceViewModel.selectedTrim.value ?: return
        val sub = changeColorPrice - curTrim.trimPrice
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
                        trimName,
                        changeColorPrice.setFormattedPrice()
                    )
                )
            )

            CaArtDialog.Builder(requireContext())
                .setTitle("$changeOptionTitle ${getString(R.string.trim_change_popup_message)}")
                .setDescription("$changeColorName ${getString(R.string.infomation_change_color_popup)}")
                .setDialogContentView(root)
                .setPositiveButton(text = getString(R.string.change), listener = {})
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
                (rvExteriorColor.adapter as ColorOptionSelectionAdapter).updateItem(colorData.exteriorColors.toChoiceColorItems())
                (rvInteriorColor.adapter as ColorOptionSelectionAdapter).updateItem(colorData.interiorColors.toChoiceColorItems())
                (incOtherExteriorColorOption.rvOtherExteriorOption.adapter as ColorOptionSelectionAdapter).updateItem(
                    colorData.otherTrimExteriorColors.toChoiceColorItems()
                )
                (incOtherInteriorColorOption.rvOtherExteriorOption.adapter as ColorOptionSelectionAdapter).updateItem(
                    colorData.otherTrimInteriorColors.toChoiceColorItems()
                )
            }

            // download exteriror Color
            carColorChoiceViewModel.currentExteriorUrls.observe(viewLifecycleOwner) { urls ->
                CoilUtils.imageLoader.memoryCache?.clear()
                lifecycleScope.launch {
                    urls.forEach { url ->
                        val request = ImageRequest.Builder(requireContext())
                            .data(url)
                            .memoryCachePolicy(CachePolicy.ENABLED)
                            .diskCachePolicy(CachePolicy.ENABLED)
                            .build()
                        CoilUtils.imageLoader.enqueue(request)
                    }
                }
            }
        }
    }
}
