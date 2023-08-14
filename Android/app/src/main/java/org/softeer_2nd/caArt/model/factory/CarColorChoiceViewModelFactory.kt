package org.softeer_2nd.caArt.model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.softeer_2nd.caArt.model.repository.ImageRepository
import org.softeer_2nd.caArt.viewmodel.CarColorChoiceViewModel

class CarColorChoiceViewModelFactory(private val imageRepository: ImageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarColorChoiceViewModel::class.java)) {
            return CarColorChoiceViewModel(imageRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
