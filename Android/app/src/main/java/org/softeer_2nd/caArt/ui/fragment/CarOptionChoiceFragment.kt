package org.softeer_2nd.caArt.ui.fragment

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
import org.softeer_2nd.caArt.databinding.ItemSituationOptionsOptionBinding
import org.softeer_2nd.caArt.ui.dialog.OptionDetailDialog
import org.softeer_2nd.caArt.util.dp2px
import org.softeer_2nd.caArt.ui.recycleradapter.OptionPreviewRecyclerAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.OptionTagRecyclerAdapter
import org.softeer_2nd.caArt.viewmodel.CarOptionChoiceViewModel

@AndroidEntryPoint
class CarOptionChoiceFragment : Fragment() {
    private var _binding: FragmentCarOptionChoiceBinding? = null
    private val binding get() = _binding!!

    private val model: CarOptionChoiceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        binding.bsOptionChoiceSummary.setMode(
            BottomSheetMode.PrevAndEstimate,
            CarColorChoiceFragmentDirections.actionCarColorChoiceFragmentToCarOptionChoiceFragment()
        )

        val optionTagAdapter = OptionTagRecyclerAdapter() { _, tag ->
            model.selectTag(tag)
        }

        binding.rvOptionChoiceOptionTagsContainer.initOptionChoiceOptionTagsContainer(
            optionTagAdapter
        )

        val optionPreviewAdapter = OptionPreviewRecyclerAdapter() { _, option ->
            showOptionDetailDialog(option)
        }
        binding.rvOptionPreviewContainer.initOptionPreviewContainer(optionPreviewAdapter)

        val situationalOptionViewOptionMap = mapOf<ItemSituationOptionsOptionBinding, Option?>(
            binding.incSituationalOptions.incSituationOption1 to null,
            binding.incSituationalOptions.incSituationOption2 to null,
            binding.incSituationalOptions.incSituationOption3 to null,
            binding.incSituationalOptions.incSituationOption4 to null,

            ).apply {
            keys.forEach {
                it.onClickListener = View.OnClickListener { view ->
                    //TODO 모델로 전달!
                    it.isSelected = !it.isSelected
                }
            }
        }
        binding.incSituationalOptions.ivSituationalTagOptionsSituationImage.setOnMoreIconClickListener {
            if (it != null) showOptionDetailDialog(it)
        }

        model.tagList.observe(viewLifecycleOwner) {
            optionTagAdapter.setItemList(it)
        }

        model.selectedTag.observe(viewLifecycleOwner) {
            optionTagAdapter.changeSelectedItem(it)
        }

        model.optionList.observe(viewLifecycleOwner) {
            Log.d("check", it.toString())
            optionPreviewAdapter.setOptionList(it)
        }

        model.situationalOptions.observe(viewLifecycleOwner) {
            binding.incSituationalOptions.ivSituationalTagOptionsSituationImage.apply {
                clear()
                addOptions(it)
            }
            situationalOptionViewOptionMap.keys.forEachIndexed { index, itemBinding ->
                val option = it[index]
                itemBinding.onClickListener
                itemBinding.optionImageUrl = option?.optionImage
            }
        }

        model.displayType.observe(viewLifecycleOwner) {
            binding.isSituationalLayoutDisplay = (it == CarOptionChoiceViewModel.OPTION_IMAGE)
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
    }

    private fun RecyclerView.initOptionChoiceOptionTagsContainer(adapter: OptionTagRecyclerAdapter) {
        val optionTagMargin = 6f.dp2px(requireContext())
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        this.adapter = adapter
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

    private fun showOptionDetailDialog(option: Option) {
        OptionDetailDialog.Builder()
            .setOption(option)
            .build()
            .show(requireActivity().supportFragmentManager, "optionDetail")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}