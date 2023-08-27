package org.softeer_2nd.caArt.ui.fragment

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import org.softeer_2nd.caArt.model.data.typeEnum.BottomSheetMode
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import dagger.hilt.android.AndroidEntryPoint
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.databinding.FragmentCarOptionChoiceBinding
import org.softeer_2nd.caArt.model.data.state.SelectState
import org.softeer_2nd.caArt.ui.dialog.OptionDetailDialog
import org.softeer_2nd.caArt.ui.fragment.CarBuildingLoadingFragment.Companion.DEFAULT_LOADING_DURATION
import org.softeer_2nd.caArt.util.dp2px
import org.softeer_2nd.caArt.ui.recycleradapter.OptionPreviewRecyclerAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.OptionTagRecyclerAdapter
import org.softeer_2nd.caArt.viewmodel.CarOptionChoiceViewModel
import org.softeer_2nd.caArt.viewmodel.CarOptionChoiceViewModel.Companion.OPTION_IMAGE
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel

@AndroidEntryPoint
class CarOptionChoiceFragment : Fragment() {

    private var _binding: FragmentCarOptionChoiceBinding? = null
    private val binding get() = _binding!!

    private val model: CarOptionChoiceViewModel by viewModels()
    private val userChoiceViewModel: UserChoiceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        model.setSelectedModelInfo(
            1,//userChoiceViewModel.selectedTrim.value?.trimName?.toTrimId() ?: 1,
            1,//userChoiceViewModel.selectedEngine.value?.id ?: 1,
            1,//userChoiceViewModel.selectedBodyType.value?.id ?: 1,
            1,//userChoiceViewModel.selectedEngine.value?.id ?: 1
        )
        model.setInitialSelectedOption(userChoiceViewModel.getSelectedOptionList())
        model.requestTagList()
        _binding = FragmentCarOptionChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.incOptionChoiceTopIndicator.currentIndex = 2

        binding.tlOptionChoiceOptionCategory.addOnTabSelectedListener(object :
            OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                model.setTabState(tab?.position ?: 0)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.bsOptionChoiceSummary.apply {
            setMode(
                BottomSheetMode.PrevAndEstimate,
                CarOptionChoiceFragmentDirections.actionCarOptionChoiceFragmentToCarBuildingLoadingFragment(
                    DEFAULT_LOADING_DURATION
                )
            )
            this.setViewModel(userChoiceViewModel, viewLifecycleOwner)
        }

        val optionTagAdapter = OptionTagRecyclerAdapter() { _, tag ->
            model.selectTag(tag)
        }

        binding.rvOptionChoiceOptionTagsContainer.initOptionChoiceOptionTagsContainer(
            optionTagAdapter
        )

        val optionPreviewAdapter = OptionPreviewRecyclerAdapter(
            { _, option ->
                model.setOptionDetailDialogPopUpEvent(option)
            },
            {
                model.requestNextPage()
            },
            { _, selectedOption ->
                model.selectOption(selectedOption)
            }
        )
        binding.rvOptionPreviewContainer.initOptionPreviewContainer(optionPreviewAdapter)

        val situationalOptionViewList = listOf(
            binding.incSituationalOptions.incSituationOption1,
            binding.incSituationalOptions.incSituationOption2,
            binding.incSituationalOptions.incSituationOption3,
            binding.incSituationalOptions.incSituationOption4
        ).apply {
            forEachIndexed { index, itemSituationOptionsOptionBinding ->
                itemSituationOptionsOptionBinding.onClickListener = View.OnClickListener { view ->
                    model.setSituationalOptionSelect(index)
                }
            }
        }


        binding.incSituationalOptions.ivSituationalTagOptionsSituationImage.setOnMoreIconClickListener {
            if (it != null) model.setOptionDetailDialogPopUpEvent(it)
        }

        model.tagList.observe(viewLifecycleOwner) {
            optionTagAdapter.setItemList(it)
        }

        model.selectedTag.observe(viewLifecycleOwner) {
            optionTagAdapter.changeSelectedItem(it)
            binding.incSituationalOptions.imageUrl = it.tagImage
        }

        model.optionListWithSelectState.observe(viewLifecycleOwner) {
            optionPreviewAdapter.setOptionList(it)
        }

        model.situationalOptionViewState.observe(viewLifecycleOwner) {
            binding.incSituationalOptions.ivSituationalTagOptionsSituationImage.apply {
                clear()
                addOptions(it.situationalOption)
                setImage(it.situationalImage)
            }
            situationalOptionViewList.forEachIndexed { index, itemSituationOptionsOptionBinding ->
                itemSituationOptionsOptionBinding.optionImageUrl =
                    it.situationalOption[index]?.item?.optionImage
                itemSituationOptionsOptionBinding.isSelected =
                    it.situationalOption[index]?.isSelected ?: false
            }
        }

        model.displayType.observe(viewLifecycleOwner) {
            binding.isSituationalLayoutDisplay = (it == OPTION_IMAGE)
        }

        model.isLastPage.observe(viewLifecycleOwner) {
            optionPreviewAdapter.setLastPage(it)
        }

        model.totalOptionCount.observe(viewLifecycleOwner) {
            optionPreviewAdapter.setTotalOptionCount(it)
        }

        model.optionSelectEvent.observe(viewLifecycleOwner) {
            optionPreviewAdapter.selectOption(it)
        }

        model.situationalOptionSelectEvent.observe(viewLifecycleOwner) {
            val viewIndex = it.item
            situationalOptionViewList[viewIndex].isSelected = it.isSelected
        }

        model.optionDetailDialogPopUpEvent.observe(viewLifecycleOwner) {
            showOptionDetailDialog(it)
        }

        model.selectedOptionSet.observe(viewLifecycleOwner) {
            userChoiceViewModel.setSelectedOptions(it.toList())
        }

        model.nextOptionListLoadEvent.observe(viewLifecycleOwner) {
            optionPreviewAdapter.addOptionList(it)
        }

    }

    private fun RecyclerView.initOptionPreviewContainer(adapter: OptionPreviewRecyclerAdapter) {
        this.adapter = adapter
        layoutManager = GridLayoutManager(requireContext(), 2).apply {
            spanSizeLookup = object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position == 0 || position == adapter.itemCount - 1) 2
                    else 1
                }
            }
        }
        addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.left = 4f.dp2px(requireContext())
                outRect.right = 4f.dp2px(requireContext())
                if (getChildAdapterPosition(view) != 0 && getChildAdapterPosition(view) != adapter.itemCount - 1) {
                    outRect.top = 12f.dp2px(requireContext())
                    outRect.bottom = 12f.dp2px(requireContext())
                }
            }
        })
        itemAnimator = null
    }

    private fun RecyclerView.initOptionChoiceOptionTagsContainer(adapter: OptionTagRecyclerAdapter) {
        val optionTagMargin = 6f.dp2px(requireContext())
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        this.adapter = adapter
        itemAnimator = null
        addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.left = optionTagMargin
                outRect.right = optionTagMargin
            }
        })
    }

    private fun showOptionDetailDialog(option: SelectState<Option>) {
        val dialog = OptionDetailDialog.Builder()
            .setOption(option)
            .setOnOptionSelectResultListener {
                model.selectDialogResultOption(it)
            }
            .build()

        dialog.show(requireActivity().supportFragmentManager, "optionDetail")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}