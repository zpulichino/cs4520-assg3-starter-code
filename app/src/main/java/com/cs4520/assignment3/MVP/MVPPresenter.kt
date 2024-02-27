package com.cs4520.assignment3.MVP

class MVPPresenter(private val view: MVPView, private val model: MVPModel) {
    fun onAddClick(firstNum: String, secondNum: String) {
        if(firstNum.isEmpty() || secondNum.isEmpty()) {
            view.showError("Enter two inputs")
            return
        }
        processCalc(firstNum, secondNum) {a, b, -> model.add(a, b)}
    }

    fun onSubClick(firstNum: String, secondNum: String) {
        if(firstNum.isEmpty() || secondNum.isEmpty()) {
            view.showError("Enter two inputs")
            return
        }
        processCalc(firstNum, secondNum) {a, b, -> model.sub(a, b)}
    }

    fun onMultiplyClick(firstNum: String, secondNum: String) {
        if(firstNum.isEmpty() || secondNum.isEmpty()) {
            view.showError("Enter two inputs")
            return
        }
        processCalc(firstNum, secondNum) {a, b, -> model.multiply(a, b)}
    }

    fun onDivideClick(firstNum: String, secondNum: String) {
        if(firstNum.isEmpty() || secondNum.isEmpty()) {
            view.showError("Enter two inputs")
            return
        }
        if (secondNum.toDoubleOrNull() == 0.0) {
            view.showError("Can't use zero for division")
            return
        }
        processCalc(firstNum, secondNum) {a, b, -> model.divide(a, b)}
    }

    private fun processCalc(firstNum: String, secondNum: String, calculation: (Double, Double) -> Double) {
        try {
            val num1 = firstNum.toDouble()
            val num2 = secondNum.toDouble()
            val result = calculation(num1, num2)
            view.showResult(result.toString())
        } catch (e: NumberFormatException) {
            view.showError("Invalid input")
        }
    }
}