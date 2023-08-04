package org.softeer_2nd.caArt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.softeer_2nd.caArt.RecyclerAdapters.OptionSelectionAdapter
import org.softeer_2nd.caArt.databinding.LayoutBottomSheetBaseBinding

class CustomBottomSheet(context: Context, attrs: AttributeSet) : CoordinatorLayout(context, attrs) {

    private val bottomSheetBehavior: BottomSheetBehavior<View>
    private val binding: LayoutBottomSheetBaseBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: OptionSelectionAdapter

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutBottomSheetBaseBinding.inflate(inflater, this, true)
        bottomSheetBehavior = BottomSheetBehavior.from(binding.root)

        recyclerView = binding.incSlideUp.findViewById<RecyclerView>(R.id.rv_select_options)
        recyclerView.layoutManager = LinearLayoutManager(context)
        itemAdapter = OptionSelectionAdapter(DummyItemFactory.createDummyItems())
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

    private fun handleSlide(slideOffset: Float) {
        val threshold = 0.5f
        if (slideOffset >= threshold) {
            binding.incSlideUp.alpha =(slideOffset - threshold) / (1 - threshold)
            binding.incSlideDown.visibility = View.GONE
            binding.incSlideUp.visibility = View.VISIBLE
        } else {
            binding.incSlideDown.alpha = 1 - (slideOffset / threshold)
            binding.incSlideDown.visibility = View.VISIBLE
            binding.incSlideUp.visibility = View.GONE
        }
    }
}
