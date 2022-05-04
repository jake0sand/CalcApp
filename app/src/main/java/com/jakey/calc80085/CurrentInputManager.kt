package com.jakey.calc80085

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CurrentInputManager {
    private val _inputLiveData = MutableLiveData("")
    val inputLiveData: LiveData<String> = _inputLiveData

    private val _canPressDecimalLiveData = MutableLiveData(true)
    val canPressDecimalLiveData: LiveData<Boolean> = _canPressDecimalLiveData

    private val operatorList = listOf("+", "-", "*", "/")

    fun inputReceived(s: String) {
        val currentInput = _inputLiveData.value ?: ""

        if (operatorList.contains(currentInput)) {
            setFinalInput(s)
            return
        }
        _inputLiveData.postValue(currentInput + s)
        updateDecimalState(currentInput + s)
    }

    fun backspace() {
        val currentInput = _inputLiveData.value ?: ""
        if (currentInput.isNotEmpty()) {
            val newInput = currentInput.dropLast(1)
            _inputLiveData.postValue(newInput)
            updateDecimalState(newInput)
        }
    }

    fun clearAll() {
        _inputLiveData.postValue("")
        updateDecimalState("")
    }

    fun setFinalInput(s: String) {
        _inputLiveData.postValue(s)
        updateDecimalState(currentInput = s)
    }

    fun shouldSaveInput(): Boolean {
        val currentInput = _inputLiveData.value ?: ""
        return currentInput.isDigitsOnly() || currentInput.contains('.')
    }

    private fun updateDecimalState(currentInput: String) {
        _canPressDecimalLiveData.postValue(currentInput.isEmpty() || currentInput.isDigitsOnly())
    }
}