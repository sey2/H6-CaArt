package org.softeer_2nd.caArt.ui.bindingadapter

import android.widget.RadioGroup
import androidx.databinding.BindingAdapter
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.viewmodel.CarTrimChoiceViewModel
import org.softeer_2nd.caArt.viewmodel.UserChoiceViewModel
@BindingAdapter("onCompositionChanged", "carTrimChoiceViewModel")
fun RadioGroup.setCompositionChanged(
    userChoiceViewModel: UserChoiceViewModel,
    carTrimChoiceViewModel: CarTrimChoiceViewModel
) {
    setOnCheckedChangeListener { _, checkedId ->
        val engines = carTrimChoiceViewModel.composition.value?.carEngines ?: emptyList()
        val bodyType =  carTrimChoiceViewModel.composition.value?.bodyTypes ?: emptyList()
        val wheelDrive = carTrimChoiceViewModel.composition.value?.wheelDrives ?: emptyList()

        when (checkedId) {
            R.id.btn_engine_left -> {
                userChoiceViewModel.setSelectedEngine(engines[0])
                carTrimChoiceViewModel.setTrimChoiceDescription(engines[0].description)
            }
            R.id.btn_engine_right -> {
                userChoiceViewModel.setSelectedEngine(engines[1])
                carTrimChoiceViewModel.setTrimChoiceDescription(engines[1].description)
            }
            R.id.btn_body_left -> {
                userChoiceViewModel.setSelectedBodyType(bodyType[0])
                carTrimChoiceViewModel.setTrimChoiceDescription(bodyType[0].description)
            }
            R.id.btn_body_right -> {
                userChoiceViewModel.setSelectedBodyType(bodyType[1])
                carTrimChoiceViewModel.setTrimChoiceDescription(bodyType[1].description)
            }
            R.id.btn_driven_left -> {
                userChoiceViewModel.setSelectedWheelDrive(wheelDrive[0])
                carTrimChoiceViewModel.setTrimChoiceDescription(wheelDrive[0].description)
            }
            R.id.btn_driven_right -> {
                userChoiceViewModel.setSelectedWheelDrive(wheelDrive[1])
                carTrimChoiceViewModel.setTrimChoiceDescription(wheelDrive[1].description)
            }
        }

        carTrimChoiceViewModel.setIsToolTipVisible(true)
    }
}