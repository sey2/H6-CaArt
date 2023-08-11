package org.softeer_2nd.caArt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.softeer_2nd.caArt.models.repositorys.ImageRepository

class CarColorChoiceViewModel(private val imageRepository: ImageRepository) : ViewModel() {
    private val _images = MutableLiveData<List<Int>>()
    val images: LiveData<List<Int>> = _images

    private val _spinCarImageIndex = MutableLiveData<Int>(0)
    val spinCarImageIndex: LiveData<Int> = _spinCarImageIndex

    private val _spinActive = MutableLiveData<Boolean>(false)
    val spinActive: LiveData<Boolean> = _spinActive

    val currentImage: LiveData<Int> = Transformations.map(spinCarImageIndex) { index ->
        images.value?.get(index)
    }

    init {
        _images.value = imageRepository.getCarImages()
    }

    fun updateIndex(index: Int) {
        _spinCarImageIndex.value = index
    }

    fun activateSpinImage() {
        _spinActive.value = true
    }
}
