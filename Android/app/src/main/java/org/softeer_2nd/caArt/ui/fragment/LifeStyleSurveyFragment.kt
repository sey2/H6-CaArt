package org.softeer_2nd.caArt.ui.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.viewpager2.widget.ViewPager2
import org.softeer_2nd.caArt.databinding.FragmentSurveyBinding
import org.softeer_2nd.caArt.databinding.LayoutLifeStylePersonaContainerBinding
import org.softeer_2nd.caArt.model.data.event.SurveyQuestion
import org.softeer_2nd.caArt.util.dp2px
import org.softeer_2nd.caArt.ui.recycleradapter.LifestylePersonaSelectAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.SurveyAnswerOptionsRecyclerAdapter
import org.softeer_2nd.caArt.viewmodel.LifeStyleSurveyViewModel

class LifeStyleSurveyFragment : ProcessFragment<SurveyQuestion>() {

    override val processViewModel: LifeStyleSurveyViewModel by viewModels()

    private var _binding: FragmentSurveyBinding? = null
    private val binding get() = _binding!!

    private var surveyAdapter: SurveyAnswerOptionsRecyclerAdapter? = null

    private var lifeStylePersonaLayoutBinding: LayoutLifeStylePersonaContainerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurveyBinding.inflate(inflater, container, false)
        lifeStylePersonaLayoutBinding =
            LayoutLifeStylePersonaContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val personaAdapter = LifestylePersonaSelectAdapter(
            onLifeStylePersonaClickListener = { _, persona ->
                processViewModel.selectPersona(persona)
            },
            onLifeStylePersonaDetailSelectClickListener = { _ ->
                //TODO 라이프 스타일 상세선택 화면으로 이동
            },
            onLifeStylePersonaMoreClickListener = { _, persona ->
                //TODO 라이프 스타일 엿보기 화면으로 이동
            }
        )

        lifeStylePersonaLayoutBinding?.apply {
            root.initPersonaContainerLayoutParams()
            vpLifeStylePersonaContainer.initLifeStylePersonaContainer(personaAdapter)
        }
        binding.clSurveyScreenContainer.addView(lifeStylePersonaLayoutBinding?.root)

        binding.processViewModel = processViewModel

        surveyAdapter = SurveyAnswerOptionsRecyclerAdapter()

        binding.rvSurveyAnswerOptionsContainer.initSurveyAnswerOptionsRecyclerView(surveyAdapter!!)

        processViewModel.personaList.observe(viewLifecycleOwner) {
            lifeStylePersonaLayoutBinding?.ciLifeStylePersonaIndicator?.setDotCount(it.size + 1)
            personaAdapter.setItemList(it)
        }

        processViewModel.selectedPersona.observe(viewLifecycleOwner) {
            personaAdapter.selectItem(it)
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
            lifeStylePersonaLayoutBinding?.root?.visibility = View.VISIBLE
        }

    }

    private fun View.initPersonaContainerLayoutParams() {
        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            topToBottom = binding.tvSurveyQuestion.id
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            bottomToTop = binding.btnSurveyNextProcess.id
            topMargin = 43f.dp2px(requireContext())
            verticalBias = 0.2f
        }
        layoutParams = lp
        visibility = View.GONE
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

    private fun ViewPager2.initLifeStylePersonaContainer(adapter: LifestylePersonaSelectAdapter) {
        this.adapter = adapter
        val margin = 48f.dp2px(requireContext())
        val adjacentItemPreviewWidth = 40f.dp2px(context)
        addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.left = margin
                outRect.right = margin
            }
        })
        offscreenPageLimit = 1
        setPageTransformer { page, position ->
            page.translationX = position * -(margin + adjacentItemPreviewWidth)
        }
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                lifeStylePersonaLayoutBinding?.ciLifeStylePersonaIndicator?.setSelectedDotIndex(
                    position
                )
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        surveyAdapter = null
        _binding = null
        lifeStylePersonaLayoutBinding = null
    }

}