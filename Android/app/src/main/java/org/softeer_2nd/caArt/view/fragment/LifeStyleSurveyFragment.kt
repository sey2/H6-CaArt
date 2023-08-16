package org.softeer_2nd.caArt.view.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import org.softeer_2nd.caArt.databinding.FragmentSurveyBinding
import org.softeer_2nd.caArt.model.data.event.SurveyQuestion
import org.softeer_2nd.caArt.util.dp2px
import org.softeer_2nd.caArt.view.recyclerAdapter.SurveyAnswerOptionsRecyclerAdapter
import org.softeer_2nd.caArt.viewmodel.LifeStyleSurveyViewModel

class LifeStyleSurveyFragment : ProcessFragment<SurveyQuestion>() {

    override val processViewModel: LifeStyleSurveyViewModel by viewModels()

    private var _binding: FragmentSurveyBinding? = null
    private val binding get() = _binding!!

    private var surveyAdapter: SurveyAnswerOptionsRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurveyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.processViewModel = processViewModel

        surveyAdapter = SurveyAnswerOptionsRecyclerAdapter().apply {
            setAnswerOptionList(List(5) { "$it" })
        }

        binding.rvSurveyAnswerOptionsContainer.initSurveyAnswerOptionsRecyclerView(surveyAdapter!!)

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
        if (!isLastProcess) {
            binding.questionString = data?.question
            surveyAdapter?.setAnswerOptionList(data?.answerOptions ?: emptyList())
        }

    }

    private fun RecyclerView.initSurveyAnswerOptionsRecyclerView(adapter: SurveyAnswerOptionsRecyclerAdapter) {
        this.adapter = adapter
        layoutManager = LinearLayoutManager(requireContext())
        addItemDecoration(object : ItemDecoration() {
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

    override fun onDestroyView() {
        super.onDestroyView()
        surveyAdapter = null
        _binding = null
    }

}