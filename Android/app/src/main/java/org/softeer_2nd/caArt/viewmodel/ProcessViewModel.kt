package org.softeer_2nd.caArt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.softeer_2nd.caArt.model.data.event.ProcessChangeEvent
import kotlin.math.max
import kotlin.math.min

abstract class ProcessViewModel<PROCESS_DATA_TYPE> : ViewModel() {

    protected val _lastProcess = MutableLiveData<Int>()
    val lastProcess: LiveData<Int> = _lastProcess

    private var _currentProcessIndex = -1
    val currentProcessIndex get() = _currentProcessIndex
    val currentProcess get() = _currentProcessIndex + 1

    protected val _processChangeEvent = MutableLiveData<ProcessChangeEvent<PROCESS_DATA_TYPE>>()
    val processChangeEvent: LiveData<ProcessChangeEvent<PROCESS_DATA_TYPE>> = _processChangeEvent

    protected val processData = mutableListOf<PROCESS_DATA_TYPE>()

    protected fun setLastProcess(lastProcess: Int) {
        _lastProcess.value = lastProcess
    }

    protected fun startProcess() {
        next()
    }

    open fun next() {
        val next = min(processData.lastIndex, currentProcessIndex + 1)
        _currentProcessIndex = next
        val data =
            if (currentProcessIndex in 0..processData.lastIndex) {
                processData[currentProcessIndex]
            } else {
                null
            }
        _processChangeEvent.value =
            ProcessChangeEvent(
                currentProcess = currentProcess,
                isLastProcess = currentProcess == lastProcess.value,
                data = data
            )
    }

    open fun prev() {
        val prev = max(0, currentProcessIndex - 1)
        _currentProcessIndex = prev
        val data =
            if (currentProcessIndex in 0..processData.lastIndex) {
                processData[currentProcessIndex]
            } else {
                null
            }
        _processChangeEvent.value =
            ProcessChangeEvent(
                currentProcess = currentProcess,
                isLastProcess = currentProcess == lastProcess.value,
                data = data
            )
    }

    protected fun setProcessData(list: List<PROCESS_DATA_TYPE>) {
        processData.clear()
        processData.addAll(list)
    }


}