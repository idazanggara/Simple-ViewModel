package com.enigmacamp.simpleviewmodel

import androidx.lifecycle.ViewModel

class CounterVM : ViewModel() {
    var counterVm = 0

    fun increment() {
        counterVm++
    }
}