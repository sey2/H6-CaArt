package org.softeer_2nd.caArt.views.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.softeer_2nd.caArt.models.datas.BottomSheetMode
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.views.recyclerAdapters.BottomSheetCurrentOptionAdapter
import org.softeer_2nd.caArt.databinding.LayoutBottomSheetBaseBinding
import org.softeer_2nd.caArt.models.factorys.DummyItemFactory

class SummaryBottomSheet(context: Context, attrs: AttributeSet) : CoordinatorLayout(context, attrs) {

    private val bottomSheetBehavior: BottomSheetBehavior<View>
    private val binding: LayoutBottomSheetBaseBinding
    private var itemAdapter: BottomSheetCurrentOptionAdapter

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutBottomSheetBaseBinding.inflate(inflater, this, true)

        bottomSheetBehavior = BottomSheetBehavior.from(binding.root)
        binding.incSlideUp.rvSelectOptions.layoutManager = LinearLayoutManager(context)
        itemAdapter =
            BottomSheetCurrentOptionAdapter(DummyItemFactory.createOptionSelectionDummyItems())
        binding.incSlideUp.rvSelectOptions.adapter = itemAdapter

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                handleSlide(slideOffset)
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })

        binding.incSlideDown.btnPrevious.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    fun setMode(mode: BottomSheetMode, navDirection: NavDirections) {
        when (mode) {
            BottomSheetMode.PrevAndNext -> showPrevAndNextView(navDirection)
            BottomSheetMode.PrevAndEstimate -> showPrevAndEstimateView(navDirection)
            BottomSheetMode.Next -> showNextView(navDirection)
        }
    }

    private fun handleSlide(slideOffset: Float) {
        val threshold = 0.5f
        if (slideOffset >= threshold) {
            binding.incSlideUp.root.alpha = (slideOffset - threshold) / (1 - threshold)
            binding.incSlideDown.root.visibility = View.GONE
            binding.incSlideUp.root.visibility = View.VISIBLE
        } else {
            binding.incSlideDown.root.alpha = 1 - (slideOffset / threshold)
            binding.incSlideDown.root.visibility = View.VISIBLE
            binding.incSlideUp.root.visibility = View.GONE
        }
    }

    private fun showPrevAndNextView(nextFragmentAction: NavDirections) {
        binding.incSlideDown.flowPrvNextBtn.visibility = View.VISIBLE
        binding.incSlideDown.btnOneNext.visibility = View.GONE
        binding.incSlideDown.btnTwoNext.setOnClickListener {
            findNavController().navigate(nextFragmentAction)
        }
    }

    private fun showPrevAndEstimateView(nextFragmentAction: NavDirections) {
        binding.incSlideDown.btnOneNext.visibility = View.GONE
        binding.incSlideDown.flowPrvNextBtn.visibility = View.VISIBLE
        binding.incSlideDown.btnTwoNext.apply {
            text = "견적내기"
            setOnClickListener {
                findNavController().navigate(nextFragmentAction)
            }
        }
    }
    private fun showNextView(nextFragmentAction: NavDirections) {
        binding.incSlideDown.flowPrvNextBtn.visibility = View.GONE

        binding.incSlideDown.btnOneNext.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                findNavController().navigate(nextFragmentAction)
            }
        }
    }
}
