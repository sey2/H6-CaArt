package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.FragmentEstimateBinding
import org.softeer_2nd.caArt.model.data.ResultChoiceOption
import org.softeer_2nd.caArt.model.factory.DummyItemFactory
import org.softeer_2nd.caArt.ui.recycleradapter.OrderDetailAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.ResultOptionAdapter
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel

class EstimateFragment : Fragment() {
    private var _binding: FragmentEstimateBinding? = null
    private val binding get() = _binding!!

    private val userChoiceViewModel by activityViewModels<UserChoiceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEstimateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            userViewModel = userChoiceViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        setupRecyclerViews()
    }

    fun RecyclerView.setup(
        layoutManager: RecyclerView.LayoutManager,
        adapter: RecyclerView.Adapter<*>,
        nestedScrollingEnabled: Boolean = true
    ) {
        this.layoutManager = layoutManager
        this.adapter = adapter
        this.isNestedScrollingEnabled = nestedScrollingEnabled
    }

    private fun setupRecyclerViews() {
        binding.rvChoiceOptions.setup(
            LinearLayoutManager(context),
            ResultOptionAdapter(getChoiceOptions(), false),
            false
        )

        binding.rvOrderDetail.setup(
            LinearLayoutManager(context),
            OrderDetailAdapter(DummyItemFactory.createOrderMoreDetailDummyItem()),
            false
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getChoiceOptions(): List<ResultChoiceOption> {
        return listOf(
            ResultChoiceOption(
                optionTitle = getString(R.string.color),
                topOptionTitle= "외장 - ${userChoiceViewModel.selectedExteriorColor.value?.colorName}",
                topOptionImgUrl= userChoiceViewModel.selectedExteriorColor.value?.colorImage,
                topOptionPrice = userChoiceViewModel.selectedExteriorColor.value?.colorPrice,
                bottomOptionTitle =  "내장 - ${userChoiceViewModel.selectedInteriorColor.value?.colorName}",
                bottomOptionImgUrl = userChoiceViewModel.selectedInteriorColor.value?.colorImage,
                bottomOptionPrice = userChoiceViewModel.selectedInteriorColor.value?.colorPrice
            ),
            ResultChoiceOption(
                optionTitle = getString(R.string.option),
                topOptionTitle = userChoiceViewModel.selectedTrim.value?.mainOptions?.get(0)?.optionName ?: "",
                topOptionImgUrl = userChoiceViewModel.selectedTrim.value?.mainOptions?.get(0)?.optionImage ?: "",
                0,
                bottomOptionTitle =  userChoiceViewModel.selectedTrim.value?.mainOptions?.get(0)?.optionName ?: "",
                bottomOptionImgUrl = userChoiceViewModel.selectedTrim.value?.mainOptions?.get(1)?.optionImage ?: "",
                bottomOptionPrice = 0
            )
        )
    }

}