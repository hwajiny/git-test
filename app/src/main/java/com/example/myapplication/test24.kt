package com.example.myapplication

class Calculator {
    private val operations = mutableMapOf<Char, MathOperation>()
    fun addOperation(operator: Char, operation: MathOperation) {
        operations[operator] = operation
    }
    fun calculate(operator: Char, num1: Double, num2: Double): Double {
        val operation = operations[operator]
        if (operation != null) {
            return operation.operate(num1, num2)
        } else {
            throw IllegalArgumentException("Invalid operator")
        }
    }
}
interface MathOperation {
    fun operate(num1: Double, num2: Double): Double
}
class AddOperation : MathOperation {
    override fun operate(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}
class SubtractOperation : MathOperation {
    override fun operate(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}
class MultiplyOperation : MathOperation {
    override fun operate(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}
class DivideOperation : MathOperation {
    override fun operate(num1: Double, num2: Double): Double {
        if (num2 == 0.0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        return num1 / num2
    }
}
fun main() {
    val calculator = Calculator()
    calculator.addOperation('+', AddOperation())
    calculator.addOperation('-', SubtractOperation())
    calculator.addOperation('*', MultiplyOperation())
    calculator.addOperation('/', DivideOperation())

    val num1 = 10.0
    val num2 = 20.0

    println("$num1 + $num2 = ${calculator.calculate('+', num1, num2)}")
    println("$num1 - $num2 = ${calculator.calculate('-', num1, num2)}")
    println("$num1 * $num2 = ${calculator.calculate('*', num1, num2)}")
    println("$num1 / $num2 = ${calculator.calculate('/', num1, num2)}")
}
