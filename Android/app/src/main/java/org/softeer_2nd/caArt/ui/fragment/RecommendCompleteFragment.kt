package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.FragmentRecommendCompleteBinding
import org.softeer_2nd.caArt.model.data.state.RecommendCompleteResultState
import org.softeer_2nd.caArt.model.factory.DummyItemFactory
import org.softeer_2nd.caArt.ui.dialog.LoadingDialog
import org.softeer_2nd.caArt.ui.fragment.CarBuildingLoadingFragment.Companion.DEFAULT_LOADING_DURATION
import org.softeer_2nd.caArt.ui.recycleradapter.ResultOptionAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.UserSelectedAnswerChipRecyclerAdapter
import org.softeer_2nd.caArt.viewmodel.RecommendCompleteViewModel
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel

@AndroidEntryPoint
class RecommendCompleteFragment : Fragment() {

    private var _binding: FragmentRecommendCompleteBinding? = null
    private val binding get() = _binding!!

    private val recommendCompleteViewModel: RecommendCompleteViewModel by viewModels()

    private val args: RecommendCompleteFragmentArgs by navArgs()

    private val userChoiceViewModel: UserChoiceViewModel by activityViewModels()

    private var loadingDialog: LoadingDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadingDialog = LoadingDialog(requireContext())
        val fromAdditionalSurvey =
            (findNavController().previousBackStackEntry?.destination?.id == R.id.lifeStyleDetailSurveyFragment)
        if (!fromAdditionalSurvey) {
            recommendCompleteViewModel.requestRecommendCompleteResult(args.personaId, args.age.code)
        } else {
            loadingDialog?.show()
            with(args) {
                recommendCompleteViewModel.requestRecommendCompleteResultByAdditionalQuestions(
                    age = age,
                    experience = experience,
                    family = family,
                    purpose = purpose,
                    value = value,
                    maxBudget = budget,
                    minBudget = 42000000
                )
            }
        }
        _binding = FragmentRecommendCompleteBinding.inflate(inflater, container, false)
        binding.isCarmasterRecommend = fromAdditionalSurvey
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val optionAdapter =
            ResultOptionAdapter(DummyItemFactory.createResultOptionDummyItem(), true)

        binding.rvRecommendCompleteRecommendOptionsContainer.setup(
            LinearLayoutManager(context),
            optionAdapter,
            false
        )

        binding.btnRecommendCompleteGoCustom.setOnClickListener {
            saveRecommendData()
            findNavController().navigate(RecommendCompleteFragmentDirections.actionRecommendCompleteFragmentToCarTrimChoiceFragment())
        }

        binding.btnRecommendCompleteGoEstimate.setOnClickListener {
            saveRecommendData()
            findNavController().navigate(
                RecommendCompleteFragmentDirections.actionGlobalCarBuildingLoadingFragment(
                    DEFAULT_LOADING_DURATION
                )
            )
        }

        recommendCompleteViewModel.resultState.observe(viewLifecycleOwner) {
            loadingDialog?.dismiss()
            binding.setBinding(it)
            optionAdapter.setItems(it.resultOptions)
        }

        recommendCompleteViewModel.answerList.observe(viewLifecycleOwner) {
            loadingDialog?.dismiss()
            binding.incRecommendCompleteByAdditionalQuestionCover.rvRecommendationCompleteByAdditionalQuestionUserAnswersContainer.setup(
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false),
                UserSelectedAnswerChipRecyclerAdapter(it),
                false
            )
        }

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

    private fun saveRecommendData() {
        recommendCompleteViewModel.recommendResultData?.let {
            userChoiceViewModel.setRecommendData(
                it
            )
        }
    }

    private fun FragmentRecommendCompleteBinding.setBinding(state: RecommendCompleteResultState) {
        recommendationCard = state.recommendationCard
        model = state.model
        carImage = state.palisadeImage
        totalPrice = state.totalPrice
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        loadingDialog = null
    }
}