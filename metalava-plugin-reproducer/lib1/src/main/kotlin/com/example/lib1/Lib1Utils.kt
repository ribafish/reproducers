package com.example.lib1

import com.example.lib2.Lib2Utils

object Lib1Utils {
    fun getMessage(): String {
        return "Lib1: ${Lib2Utils.getLib2Message()}"
    }

    fun processUserData(username: String): String {
        val processed = Lib2Utils.processUser(username)
        return "Processing: $processed"
    }

    fun computeAndFormat(a: Int, b: Int): String {
        val result = Lib2Utils.performCalculation(a, b)
        return "Calculation result: $result"
    }

    fun validateUserInput(input: String?): Pair<Boolean, String> {
        val validated = Lib2Utils.validateAndFormat(input)
        val isValid = validated.startsWith("Valid")
        return Pair(isValid, validated)
    }
}
