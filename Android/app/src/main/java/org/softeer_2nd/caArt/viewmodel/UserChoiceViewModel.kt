package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.data.WheelDrive


class UserChoiceViewModel:ViewModel() {

    private val _selectedBodyType=MutableLiveData<BodyType>()
    val selectedBodyType:LiveData<BodyType> = _selectedBodyType

    private val _selectedEngine=MutableLiveData<Engine>()
    val selectedEngine:LiveData<Engine> = _selectedEngine

    private val _selectedWheelDrive=MutableLiveData<WheelDrive>()
    val selectedWheelDrive:LiveData<WheelDrive> = _selectedWheelDrive

    private val _selectedOptions=MutableLiveData<List<Option>>()
    val selectedOptions:LiveData<List<Option>> = _selectedOptions

    private val _selectedTrim=MutableLiveData<Trim>()
    val selectedTrim:LiveData<Trim> =_selectedTrim

    private val _selectedExteriorColor=MutableLiveData<Any>()
    val selectedExteriorColor:LiveData<Any> =_selectedExteriorColor

    private val _selectedInteriorColor=MutableLiveData<Any>()
    val selectedInteriorColor:LiveData<Any> =_selectedInteriorColor

    fun setSelectedBodyType(bodyType: BodyType){
        _selectedBodyType.value=bodyType
    }

    fun setSelectedEngine(engine: Engine){
        _selectedEngine.value=engine
    }

    fun setSelectedWheelDrive(wheelDrive: WheelDrive){
        _selectedWheelDrive.value=wheelDrive
    }

    fun setSelectedOptions(options:List<Option>){
        _selectedOptions.value=options
    }

    fun setSelectedTrim(trim: Trim){
        _selectedTrim.value=trim
    }

    fun setExteriorColor(color:Any){
        _selectedExteriorColor.value=color
    }

    fun setInteriorColor(color:Any){
        _selectedInteriorColor.value=color
    }
}