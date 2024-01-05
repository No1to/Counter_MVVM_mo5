package com.example.counter_mvvm_mo5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var clickCount: Int = 0
    val countLiveData = MutableLiveData<Int>()

    fun getInitialCount() : MutableLiveData<Int> {
        countLiveData.value = clickCount
        return countLiveData
    }

    fun incrementCount() {
        clickCount += 1
        countLiveData.postValue(clickCount)
    }

    fun decrementCount() {
        clickCount -= 1
        countLiveData.postValue(clickCount)
    }

    fun defaultCount() {
        clickCount = 0
        countLiveData.postValue(clickCount)
    }
}
