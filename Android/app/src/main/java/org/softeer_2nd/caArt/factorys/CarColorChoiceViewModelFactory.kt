package org.softeer_2nd.caArt.factorys

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.softeer_2nd.caArt.repositorys.ImageRepository
import org.softeer_2nd.caArt.viewmodels.CarColorChoiceViewModel

class CarColorChoiceViewModelFactory(private val imageRepository: ImageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarColorChoiceViewModel::class.java)) {
            return CarColorChoiceViewModel(imageRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
