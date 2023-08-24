package org.softeer_2nd.caArt.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.data.typeEnum.BottomSheetMode
import org.softeer_2nd.caArt.ui.recycleradapter.BottomSheetCurrentOptionAdapter
import org.softeer_2nd.caArt.databinding.LayoutBottomSheetBaseBinding
import org.softeer_2nd.caArt.ui.bindingadapter.animatePriceChange
import org.softeer_2nd.caArt.util.UserChoiceConverter
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel

class SummaryBottomSheet(context: Context, attrs: AttributeSet) : CoordinatorLayout(context, attrs) {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var binding: LayoutBottomSheetBaseBinding
    private val itemAdapter: BottomSheetCurrentOptionAdapter = BottomSheetCurrentOptionAdapter()

    init {
        setupUI()
        configureBottomSheetBehavior()
        configureNavigation()
    }

    private fun setupUI() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutBottomSheetBaseBinding.inflate(inflater, this, true)

        binding.incSlideUp.rvSelectOptions.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter
        }
    }

    private fun configureBottomSheetBehavior() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.root).apply {
            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    handleSlide(slideOffset)
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {}
            })
        }
    }

    private fun configureNavigation() {
        binding.incSlideDown.btnPrevious.setOnClickListener {
            it.findNavController().popBackStack()
        }

        binding.incSlideUp.btnEstimate.setOnClickListener {
            it.findNavController().navigate(R.id.estimateFragment)
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

    private fun showPrevAndNextView(navDirection: NavDirections) {
        with(binding.incSlideDown) {
            flowPrvNextBtn.visibility = View.VISIBLE
            btnOneNext.visibility = View.GONE
            btnTwoNext.setOnClickListener {
                it.findNavController().navigate(navDirection)
            }
        }
    }

    private fun showPrevAndEstimateView(navDirection: NavDirections) {
        with(binding.incSlideDown) {
            btnOneNext.visibility = View.GONE
            flowPrvNextBtn.visibility = View.VISIBLE
            btnTwoNext.apply {
                text = context.getString(R.string.estimate)
                setOnClickListener {
                    it.findNavController().navigate(navDirection)
                }
            }
        }
    }

    private fun showNextView(navDirection: NavDirections) {
        with(binding.incSlideDown) {
            flowPrvNextBtn.visibility = View.GONE
            btnOneNext.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                    it.findNavController().navigate(navDirection)
                }
            }
        }
    }

    fun setViewModel(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        bindViewModel(userChoiceViewModel, lifecycleOwner)
        observeSelectedTrim(userChoiceViewModel, lifecycleOwner)
        observeSelectedEngine(userChoiceViewModel, lifecycleOwner)
        observeSelectedColors(userChoiceViewModel, lifecycleOwner)
        observeSelectedOptions(userChoiceViewModel, lifecycleOwner)
        observeSelectedBodyType(userChoiceViewModel, lifecycleOwner)
        observeSelectedWheelDrive(userChoiceViewModel, lifecycleOwner)
        observePrice(userChoiceViewModel, lifecycleOwner)
    }

    fun observePrice(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        userChoiceViewModel?.totalPrice?.observe(lifecycleOwner) { price ->
            binding.incSlideDown.tvPrice.animatePriceChange(price)
        }
    }

    private fun bindViewModel(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        with(binding) {
            incSlideDown.userChoiceViewModel = userChoiceViewModel
            incSlideDown.lifecycleOwner = lifecycleOwner
            incSlideUp.userChoiceViewModel = userChoiceViewModel
            incSlideUp.lifecycleOwner = lifecycleOwner
        }
    }

    private fun observeSelectedTrim(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        userChoiceViewModel?.selectedTrim?.observe(lifecycleOwner) { trims ->
            val selectedBodyType = userChoiceViewModel.selectedBodyType.value
            val selectedWheelType = userChoiceViewModel.selectedWheelDrive.value
            val selectedEngineType = userChoiceViewModel.selectedEngine.value

            val updateData = selectedBodyType?.let { bodyType ->
                UserChoiceConverter.trimToUserChoice(
                    trims, selectedEngineType!!, bodyType, selectedWheelType!!
                )
            }
            itemAdapter.updateItem(0, updateData!!)
        }
    }

    private fun observeSelectedEngine(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        userChoiceViewModel?.selectedEngine?.observe(lifecycleOwner) { engine ->
            val selectedEngine = userChoiceViewModel.selectedEngine.value

            if (selectedEngine != null) {
                itemAdapter.updateEngineItem(selectedEngine)
            }
        }
    }

    private fun observeSelectedBodyType(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        userChoiceViewModel?.selectedBodyType?.observe(lifecycleOwner) { body ->
            val selectedBody = userChoiceViewModel.selectedBodyType.value

            if (selectedBody != null) {
                itemAdapter.updateBodyTypeItem(body)
            }
        }
    }

    private fun observeSelectedWheelDrive(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        userChoiceViewModel?.selectedEngine?.observe(lifecycleOwner) { engine ->
            val selectedWheelDrive = userChoiceViewModel.selectedWheelDrive.value

            if (selectedWheelDrive != null) {
                itemAdapter.updateWheelDriveItem(selectedWheelDrive)
            }
        }
    }
    private fun observeSelectedColors(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        val colorObserver = {
            val selectedExteriorColor = userChoiceViewModel?.selectedExteriorColor?.value
            val selectedInteriorColor = userChoiceViewModel?.selectedInteriorColor?.value

            if (selectedExteriorColor != null && selectedInteriorColor != null) {
                itemAdapter.updateItem(
                    1, UserChoiceConverter.colorToUserChoice(selectedExteriorColor, selectedInteriorColor)
                )
            }
        }

        userChoiceViewModel?.selectedExteriorColor?.observe(lifecycleOwner) { colorObserver.invoke() }
        userChoiceViewModel?.selectedInteriorColor?.observe(lifecycleOwner) { colorObserver.invoke() }
    }
    private fun observeSelectedOptions(userChoiceViewModel: UserChoiceViewModel?, lifecycleOwner: LifecycleOwner) {
        userChoiceViewModel?.selectedOptions?.observe(lifecycleOwner) { options ->
            val updateData = UserChoiceConverter.optionToUserChoice(options)
            itemAdapter.updateItem(2, updateData)
        }
    }
}
