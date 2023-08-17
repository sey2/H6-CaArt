package org.softeer_2nd.caArt.view.fragment

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import org.softeer_2nd.caArt.databinding.FragmentSurveyBinding
import org.softeer_2nd.caArt.databinding.LayoutDetailSurveySetBudgetBinding
import org.softeer_2nd.caArt.model.data.event.SurveyQuestion
import org.softeer_2nd.caArt.util.dp2px
import org.softeer_2nd.caArt.view.recyclerAdapter.SurveyAnswerOptionsRecyclerAdapter
import org.softeer_2nd.caArt.viewmodel.LifeStyleDetailSurveyViewModel

class LifeStyleDetailSurveyFragment : ProcessFragment<SurveyQuestion>() {

    override val processViewModel: LifeStyleDetailSurveyViewModel by viewModels()

    private var _binding: FragmentSurveyBinding? = null
    private val binding get() = _binding!!

    private var surveyAdapter: SurveyAnswerOptionsRecyclerAdapter? = null

    private var detailSurveySetBudgetBinding: LayoutDetailSurveySetBudgetBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailSurveySetBudgetBinding =
            LayoutDetailSurveySetBudgetBinding.inflate(inflater, container, false)

        _binding = FragmentSurveyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailSurveySetBudgetBinding?.apply {
            root.initDetailSurveySetBudgetBindingLayout()
            onSliderValueChangedListener =
                Slider.OnChangeListener { _, value, _ ->
                    selectPrice = value.toLong()
                }
        }

        binding.processViewModel = processViewModel

        surveyAdapter = SurveyAnswerOptionsRecyclerAdapter().apply {
            setAnswerOptionList(List(5) { "$it" })
        }

        binding.rvSurveyAnswerOptionsContainer.initSurveyAnswerOptionsRecyclerView(surveyAdapter!!)
        binding.clSurveyScreenContainer.addView(detailSurveySetBudgetBinding?.root)

        processViewModel.budgetRange.observe(viewLifecycleOwner) {
            detailSurveySetBudgetBinding?.apply {
                minPrice = it.min
                maxPrice = it.max
                step = it.step
                selectPrice = it.max
            }
        }
    }

    override fun onLastProcessChanged(lastProcess: Int) {
        binding.pageCount = lastProcess
    }

    override fun onProcessChanged(
        currentProcess: Int,
        isLastProcess: Boolean,
        data: SurveyQuestion?
    ) {
        binding.pageIndex = currentProcess
        binding.questionString = data?.question
        if (!isLastProcess) {
            surveyAdapter?.setAnswerOptionList(data?.answerOptions ?: emptyList())
        } else {
            binding.rvSurveyAnswerOptionsContainer.visibility = View.GONE
            detailSurveySetBudgetBinding?.root?.visibility = View.VISIBLE
        }
    }

    private fun RecyclerView.initSurveyAnswerOptionsRecyclerView(adapter: SurveyAnswerOptionsRecyclerAdapter) {
        this.adapter = adapter
        layoutManager = LinearLayoutManager(requireContext())
        addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                if (getChildAdapterPosition(view) != adapter.itemCount - 1) outRect.bottom =
                    12f.dp2px(context)
            }
        })

    }

    private fun View.initDetailSurveySetBudgetBindingLayout() {
        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            topToBottom = binding.tvSurveyQuestion.id
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            bottomToTop = binding.btnSurveyNextProcess.id
            topMargin = 43f.dp2px(requireContext())
            marginStart = 16f.dp2px(requireContext())
            marginEnd = 16f.dp2px(requireContext())
            verticalBias = 0.2f
        }
        layoutParams = lp
        visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        detailSurveySetBudgetBinding = null
        surveyAdapter = null
        _binding = null
    }

}