package com.jakey.calc80085

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {


    var lastInput: String = ""
    val currentInputManager = CurrentInputManager()
    private val operatorManager = OperatorManager()

    fun clearAll() {
        operatorManager.operatorReceived("")
        currentInputManager.clearAll()
    }

    fun saveOperator(operator: String) {
        if (currentInputManager.shouldSaveInput()) {
            lastInput = currentInputManager.inputLiveData.value!!
        }
        currentInputManager.setFinalInput(operator)
        operatorManager.operatorReceived(operator)
    }

    fun calculate() {
        val result = operatorManager.calculate(left = lastInput, right = currentInputManager.inputLiveData.value!!)
        currentInputManager.setFinalInput(result)
    }
}