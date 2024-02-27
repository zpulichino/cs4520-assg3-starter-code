package com.cs4520.assignment3.MVVM

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel: ViewModel() {
    private val model = MVVMModel()

    private val _result = MutableLiveData<String>()
    val result: MutableLiveData<String> = _result

    private val _error = MutableLiveData<String>()
    val error: MutableLiveData<String> = _error

    fun add(a: String, b: String) {
        if (a.isEmpty() || b.isEmpty()) {
            _error.value = "Empty Input"
            return
        } else {
            val resultValue = model.add(a.toDouble(), b.toDouble())
            _result.value = resultValue.toString()
        }
    }

    fun sub(a: String, b: String) {
        if (a.isEmpty() || b.isEmpty()) {
            _error.value = "Empty Input"
            return
        } else {
            val resultValue = model.sub(a.toDouble(), b.toDouble())
            _result.value = resultValue.toString()
        }
    }

    fun multiply(a: String, b: String) {
        if (a.isEmpty() || b.isEmpty()) {
            _error.value = "Empty Input"
            return
        } else {
            val resultValue = model.multiply(a.toDouble(), b.toDouble())
            _result.value = resultValue.toString()
        }
    }

    fun div(a: String, b: String) {
        if (a.isEmpty() || b.isEmpty() || b.toDouble() == 0.0) {
            _error.value = "Error with Input"
            return
        } else {
            val resultValue = model.div(a.toDouble(), b.toDouble())
            _result.value = resultValue.toString()
        }
    }

    fun clearError() {
        _error.value = ""
    }


}