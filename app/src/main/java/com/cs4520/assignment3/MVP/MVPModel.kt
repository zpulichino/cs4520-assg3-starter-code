package com.cs4520.assignment3.MVP

class MVPModel {

    fun add(firstNum: Double, secondNum: Double): Double {
        return firstNum + secondNum
    }

    fun sub(firstNum: Double, secondNum: Double): Double {
        return firstNum - secondNum
    }

    fun multiply(firstNum: Double, secondNum: Double): Double {
        return firstNum * secondNum
    }

    fun divide(firstNum: Double, secondNum: Double): Double {
        if (secondNum == 0.0) {
            throw IllegalArgumentException("Can not divide by zero!")
        }
        return firstNum / secondNum
    }


}