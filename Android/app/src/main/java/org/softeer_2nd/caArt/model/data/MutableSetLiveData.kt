package org.softeer_2nd.caArt.model.data

import android.util.Log
import androidx.lifecycle.MutableLiveData

class MutableSetLiveData<T> : MutableLiveData<Set<T>>() {

    private val set = mutableSetOf<T>()

    init {
        value = set
    }

    fun add(item: T) {
        set.add(item)
        value = set
    }

    fun addAll(items: Set<T>) {
        set.addAll(items)
        value = set
    }

    fun remove(item: T) {
        set.remove(item)
        value = set
    }

    fun clear() {
        set.clear()
        value = set
    }

    fun contain(item: T): Boolean = set.contains(item)

}