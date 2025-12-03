package com.example.lib3

object Lib3Utils {
    fun getLib3Message(): String {
        return "Hello from Lib3"
    }

    fun formatMessage(name: String): String {
        return "Welcome, $name!"
    }

    fun calculateSum(a: Int, b: Int): Int {
        return a + b
    }

    fun isValid(input: String?): Boolean {
        return !input.isNullOrBlank()
    }
}
