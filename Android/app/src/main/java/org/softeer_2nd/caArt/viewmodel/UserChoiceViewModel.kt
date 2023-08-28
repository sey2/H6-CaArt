package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.ChoiceColorItem.Companion.toExteriorColor
import org.softeer_2nd.caArt.model.data.ChoiceColorItem.Companion.toInteriorColor
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.data.WheelDrive
import org.softeer_2nd.caArt.model.data.dto.ColorData
import org.softeer_2nd.caArt.model.data.dto.ExteriorColor
import org.softeer_2nd.caArt.model.data.dto.InteriorColor
import org.softeer_2nd.caArt.model.data.dto.RecommendCompleteResultDTO
import org.softeer_2nd.caArt.util.StringFormatter

class UserChoiceViewModel : ViewModel() {

    private val _selectedBodyType = MutableLiveData<BodyType>()
    val selectedBodyType: LiveData<BodyType> = _selectedBodyType

    private val _selectedEngine = MutableLiveData<Engine>()
    val selectedEngine: LiveData<Engine> = _selectedEngine

    private val _selectedWheelDrive = MutableLiveData<WheelDrive>()
    val selectedWheelDrive: LiveData<WheelDrive> = _selectedWheelDrive

    private val _selectedOptions = MutableLiveData<List<Option>>()
    val selectedOptions: LiveData<List<Option>> = _selectedOptions

    private val _selectedTrimIndex = MutableLiveData<Int>(1)
    val selectedTrimIndex: LiveData<Int> = _selectedTrimIndex

    private val _selectedTrim = MutableLiveData<Trim>()
    val selectedTrim: LiveData<Trim> = _selectedTrim

    private val _selectedExteriorColor = MutableLiveData<ExteriorColor>()
    val selectedExteriorColor: LiveData<ExteriorColor> = _selectedExteriorColor

    private val _selectedInteriorColor = MutableLiveData<InteriorColor>()
    val selectedInteriorColor: LiveData<InteriorColor> = _selectedInteriorColor

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

    fun setSelectedExteriorColor(color: ExteriorColor) {
        _selectedExteriorColor.value = color
    }

    fun setSelectedInteriorColor(color: InteriorColor) {
        _selectedInteriorColor.value = color
    }

    fun setSelectedTrimIndex(index: Int) {
        _selectedTrimIndex.value = index
    }

    private fun calculateTotalPrice(): Long {
        val prices = listOf(
            _selectedEngine.value?.enginePrice ?: 0L,
            _selectedWheelDrive.value?.wheelDrivePrice ?: 0L,
            _selectedOptions.value?.sumOf { it.optionPrice ?: 0 } ?: 0L,
            _selectedTrim.value?.trimPrice ?: 0L
        )
        return prices.sum()
    }

    fun findMatchedIndices(colorData: ColorData): Pair<Int, Int> {
        val matchedExteriorIndex =
            colorData.exteriorColors.indexOfFirst { it.colorName == selectedExteriorColor.value?.colorName }
        val matchedInteriorIndex =
            colorData.interiorColors.indexOfFirst { it.colorName == selectedInteriorColor.value?.colorName }

        return Pair(
            matchedExteriorIndex.takeIf { it != -1 } ?: 0,
            matchedInteriorIndex.takeIf { it != -1 } ?: 0
        )
    }

    fun setRecommendData(data: RecommendCompleteResultDTO) {

        data.model.let {
            setSelectedBodyType(it.bodyType)
            setSelectedEngine(it.engine)
            setSelectedWheelDrive(it.wheelDrive)
            setSelectedTrim(it.trim)
        }

        setSelectedOptions(data.options)

        data.colors.let {
            setSelectedExteriorColor(it[0].toExteriorColor())
            setSelectedInteriorColor(it[1].toInteriorColor())
        }
    }

    fun setSelectedTrimImage(url: String) {
        _selectedTrim.value?.trimImage = url
    }

    fun getSpecifications(): String {
        return StringFormatter.combineCarComposition(
            selectedEngine.value?.itemName,
            selectedBodyType.value?.itemName,
            selectedWheelDrive.value?.itemName
        )
    }

    fun getCompositionTotalPrice(): Long {
        return (selectedEngine.value?.enginePrice ?: 0) + (selectedBodyType.value?.bodyTypePrice
            ?: 0) + (selectedWheelDrive.value?.wheelDrivePrice?: 0)
    }

    fun getSelectedOptionList(): List<Option>? = selectedOptions.value
}