package com.jakey.calc80085

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {



    var input = MutableLiveData("")
    var inputList = mutableListOf<Double>()

    fun deleteInput() {
        viewModelScope.launch {
            input.value = input.value?.dropLast(1)
        }
    }

}