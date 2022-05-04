package com.jakey.calc80085

object CalculateWorker {
    fun add(left: String, right: String): Double {
        return (left.toDoubleOrNull() ?: 0.0) + (right.toDoubleOrNull() ?: 0.0)
    }
    fun minus(left: String, right: String): Double {
        return (left.toDoubleOrNull() ?: 0.0) - (right.toDoubleOrNull() ?: 0.0)
    }
    fun multiply(left: String, right: String): Double {
        return (left.toDoubleOrNull() ?: 0.0) * (right.toDoubleOrNull() ?: 0.0)
    }
    fun divide(left: String, right: String): Double {
        return (left.toDoubleOrNull() ?: 0.0) / (right.toDoubleOrNull() ?: 0.0)
    }
}