package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.softeer_2nd.caArt.model.data.dto.ColorData
import org.softeer_2nd.caArt.model.repository.CarColorImageRepository
import org.softeer_2nd.caArt.util.StringFormatter
import javax.inject.Inject


@HiltViewModel
class CarColorChoiceViewModel @Inject constructor(
    val imageRepository: CarColorImageRepository
) : ViewModel() {
    val BASE_PATH = "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/"

    private val _colorData = MutableLiveData<ColorData>()
    val colorData: LiveData<ColorData> = _colorData

    private val _spinCarImageIndex = MutableLiveData<Int>(0)
    val spinCarImageIndex: LiveData<Int> = _spinCarImageIndex

    private val _spinActive = MutableLiveData<Boolean>(false)
    val spinActive: LiveData<Boolean> = _spinActive

    val currentExteriorColorImage =
        MediatorLiveData<String>("https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_001.png")

    private val _currentInteriorColorImage = MutableLiveData<String>("")
    val currentInteriorColorImage: LiveData<String> = _currentInteriorColorImage

    private val _currentExteriorUrls = MutableLiveData<List<String>>()
    val currentExteriorUrls: LiveData<List<String>>  = _currentExteriorUrls

    init {
        currentExteriorColorImage.addSource(spinCarImageIndex) { index ->
            val urls = _currentExteriorUrls.value
            if (urls != null && index in urls.indices) {
                val color = StringFormatter.extractColorFromUrl(urls[index])
                val imageUrl = "$BASE_PATH$color/image_${StringFormatter.getImageUrlFromIndex(index)}.png"
                currentExteriorColorImage.value = imageUrl
            }
        }
    }
    fun getImages(trimId: Int) {
        viewModelScope.launch {
            _colorData.value = imageRepository.fetchColorList(trimId)
            _currentInteriorColorImage.value = colorData.value!!.interiorColors[0].preview
            _currentExteriorUrls.value = colorData.value!!.exteriorColors[0].previews
        }
    }

    fun updateIndex(newIndex: Int) {
        val index = when {
            newIndex < 0 -> 60 + newIndex
            newIndex >= 60 -> newIndex - 60
            else -> newIndex
        }
        _spinCarImageIndex.value = index
    }

    fun activateSpinImage() {
        _spinActive.value = true
    }

    fun updateCurrentImageUrl(index: Int) {
        _currentExteriorUrls.value = colorData.value!!.exteriorColors[index].previews
        _spinCarImageIndex.value = 0
    }


}
