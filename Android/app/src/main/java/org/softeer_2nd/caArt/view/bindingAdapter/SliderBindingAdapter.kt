package org.softeer_2nd.caArt.view.bindingAdapter

import androidx.databinding.BindingAdapter
import com.google.android.material.slider.Slider

@BindingAdapter("onChangeListener")
fun Slider.setOnChangeListener(onChangeListener: Slider.OnChangeListener?) {
    onChangeListener ?: return
    clearOnChangeListeners()
    this.addOnChangeListener(onChangeListener)
}
