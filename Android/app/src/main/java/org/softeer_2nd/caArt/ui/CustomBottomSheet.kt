package org.softeer_2nd.caArt.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.softeer_2nd.caArt.BottomSheetMode
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.RecyclerAdapters.OptionSelectionAdapter
import org.softeer_2nd.caArt.databinding.LayoutBottomSheetBaseBinding
import org.softeer_2nd.caArt.factorys.DummyItemFactory

class CustomBottomSheet(context: Context, attrs: AttributeSet) : CoordinatorLayout(context, attrs) {

    private val bottomSheetBehavior: BottomSheetBehavior<View>
    private val binding: LayoutBottomSheetBaseBinding
    private var recyclerView: RecyclerView
    private var itemAdapter: OptionSelectionAdapter

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutBottomSheetBaseBinding.inflate(inflater, this, true)

        bottomSheetBehavior = BottomSheetBehavior.from(binding.root)

        recyclerView = binding.incSlideUp.findViewById<RecyclerView>(R.id.rv_select_options)
        recyclerView.layoutManager = LinearLayoutManager(context)
        itemAdapter = OptionSelectionAdapter(DummyItemFactory.createOptionSelectionDummyItems())
        recyclerView.adapter = itemAdapter

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                handleSlide(slideOffset)
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })
    }

    fun setMode(mode: BottomSheetMode) {
        when(mode) {
            BottomSheetMode.PrevAndNext -> showPrevAndNextView()
            BottomSheetMode.PrevAndEstimate -> showPrevAndEstimateView()
            BottomSheetMode.Next -> showNextView()
        }
    }
    private fun handleSlide(slideOffset: Float) {
        val threshold = 0.5f
        if (slideOffset >= threshold) {
            binding.incSlideUp.alpha =(slideOffset - threshold) / (1 - threshold)
            binding.incSlideDown.root.visibility = View.GONE
            binding.incSlideUp.visibility = View.VISIBLE
        } else {
            binding.incSlideDown.root.alpha = 1 - (slideOffset / threshold)
            binding.incSlideDown.root.visibility = View.VISIBLE
            binding.incSlideUp.visibility = View.GONE
        }
    }

    private fun showPrevAndNextView() {
        binding.incSlideDown.flowPrvNextBtn.visibility = View.VISIBLE
        binding.incSlideDown.btnOneNext.visibility = View.GONE
    }

    private fun showPrevAndEstimateView(){
        binding.incSlideDown.flowPrvNextBtn.visibility = View.VISIBLE
        binding.incSlideDown.btnOneNext.visibility = View.GONE
        binding.incSlideDown.btnTwoNext.text = "견적내기"
    }

    private fun showNextView(){
        binding.incSlideDown.flowPrvNextBtn.visibility = View.GONE
        binding.incSlideDown.btnOneNext.visibility = View.VISIBLE
    }
}
