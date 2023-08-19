package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.data.WheelDrive


class UserChoiceViewModel : ViewModel() {

    private val _selectedBodyType = MutableLiveData(BodyType("7인승", "", "", ""))
    val selectedBodyType: LiveData<BodyType> = _selectedBodyType

    private val _selectedEngine = MutableLiveData(Engine("디젤 2.2", "", 1480000, "", "", "", ""))
    val selectedEngine: LiveData<Engine> = _selectedEngine

    private val _selectedWheelDrive = MutableLiveData(WheelDrive("2WD", "", 0, "", ""))
    val selectedWheelDrive: LiveData<WheelDrive> = _selectedWheelDrive

    // TODO: 초기 값 설정
    private val _selectedOptions = MutableLiveData<List<Option>>()
    val selectedOptions: LiveData<List<Option>> = _selectedOptions

    private val _selectedTrim = MutableLiveData(
        Trim(
            "", listOf(),
            listOf(),
            listOf(), "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-2.png", "Exclusive",38960000, false
        )
    )
    val selectedTrim: LiveData<Trim> = _selectedTrim

    private val _selectedExteriorColor = MutableLiveData<Any>()
    val selectedExteriorColor: LiveData<Any> = _selectedExteriorColor

    private val _selectedInteriorColor = MutableLiveData<Any>()
    val selectedInteriorColor: LiveData<Any> = _selectedInteriorColor

    val totalPrice = MediatorLiveData<Long>().apply {
        value = calculateTotalPrice()

        listOf(
            _selectedEngine,
            _selectedWheelDrive,
            _selectedOptions,
            _selectedTrim
        ).forEach { liveData ->
            addSource(liveData) { value = calculateTotalPrice() }
        }
    }

    fun setSelectedBodyType(bodyType: BodyType) {
        _selectedBodyType.value = bodyType
    }

    fun setSelectedEngine(engine: Engine) {
        _selectedEngine.value = engine
    }

    fun setSelectedWheelDrive(wheelDrive: WheelDrive) {
        _selectedWheelDrive.value = wheelDrive
    }

    fun setSelectedOptions(options: List<Option>) {
        _selectedOptions.value = options
    }

    fun setSelectedTrim(trim: Trim) {
        _selectedTrim.value = trim
    }

    fun setExteriorColor(color: Any) {
        _selectedExteriorColor.value = color
    }

    fun setInteriorColor(color: Any) {
        _selectedInteriorColor.value = color
    }

    private fun calculateTotalPrice(): Long {
        val prices = listOf(
            _selectedEngine.value?.enginePrice ?: 0L,
            _selectedWheelDrive.value?.wheelDrivePrice ?: 0L,
            _selectedOptions.value?.sumOf { it.optionPrice?:0} ?: 0L,
            _selectedTrim.value?.trimPrice ?: 0L
        )
        return prices.sum()
    }

}