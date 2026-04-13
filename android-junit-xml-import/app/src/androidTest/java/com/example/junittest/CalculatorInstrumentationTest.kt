package com.example.junittest

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorInstrumentationTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun addition() {
        assertEquals(5, calculator.add(2, 3))
        assertEquals(0, calculator.add(-1, 1))
        assertEquals(-3, calculator.add(-1, -2))
    }

    @Test
    fun subtraction() {
        assertEquals(1, calculator.subtract(3, 2))
        assertEquals(-2, calculator.subtract(-1, 1))
        assertEquals(0, calculator.subtract(5, 5))
    }

    @Test
    fun multiplication() {
        assertEquals(6, calculator.multiply(2, 3))
        assertEquals(0, calculator.multiply(0, 5))
        assertEquals(1, calculator.multiply(-1, -1))
    }

    @Test
    fun division() {
        assertEquals(2, calculator.divide(6, 3))
        assertEquals(-2, calculator.divide(6, -3))
        assertEquals(1, calculator.divide(7, 4))
    }

    @Test
    fun divisionByZeroThrows() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.divide(1, 0)
        }
    }
}
