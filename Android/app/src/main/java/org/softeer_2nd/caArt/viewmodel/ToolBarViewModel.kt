package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToolBarViewModel : ViewModel() {
    private val _isHomeFragment = MutableLiveData(false)
    val isHomeFragment: LiveData<Boolean> get() = _isHomeFragment
    fun setHomeFragment(isHome: Boolean) {
        _isHomeFragment.value = isHome
    }
}