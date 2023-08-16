package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.softeer_2nd.caArt.model.repository.ImageRepository


class CarColorChoiceViewModel(private val imageRepository: ImageRepository) : ViewModel() {
    private val _images = MutableLiveData<List<Int>>()
    val images: LiveData<List<Int>> = _images

    private val _spinCarImageIndex = MutableLiveData<Int>(0)
    val spinCarImageIndex: LiveData<Int> = _spinCarImageIndex

    private val _spinActive = MutableLiveData<Boolean>(false)
    val spinActive: LiveData<Boolean> = _spinActive

    val currentImage = MediatorLiveData<Int>()

    init {
        _images.value = imageRepository.getCarImages()
        currentImage.addSource(spinCarImageIndex) { index ->
            images.value?.let {
                currentImage.value = it[index]
            }
        }
        currentImage.addSource(images) { list ->
            spinCarImageIndex.value?.let {
                currentImage.value = list[it]
            }
        }
    }

    fun updateIndex(index: Int) {
        _spinCarImageIndex.value = index
    }

    fun activateSpinImage() {
        _spinActive.value = true
    }
}
