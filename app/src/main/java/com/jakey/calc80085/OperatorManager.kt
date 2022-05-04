package com.jakey.calc80085

import com.jakey.calc80085.OperatorManager.Operator.*
class OperatorManager {


    enum class Operator {
        NONE, PLUS, MINUS, MULTIPLY, DIVIDE
    }

    private var operator = NONE

    fun operatorReceived(s: String) {
        operator = when (s) {
            "+" -> PLUS
            "-" -> MINUS
            "*" -> MULTIPLY
            "/" -> DIVIDE
            else -> NONE
        }
    }

    fun calculate(left: String, right: String): String {

        return when (operator) {
            NONE -> left
            PLUS -> CalculateWorker.add(left, right).toString()
            MINUS -> CalculateWorker.minus(left, right).toString()
            MULTIPLY -> CalculateWorker.multiply(left, right).toString()
            DIVIDE -> {
                if (right != "0") {
                    return CalculateWorker.divide(left, right).toString()
                } else "Cannot divide by 0"
            }
        }
    }
}