package com.example.lib2

import com.example.lib3.Lib3Utils

object Lib2Utils {
    fun getLib2Message(): String {
        return "Lib2: ${Lib3Utils.getLib3Message()}"
    }

    fun processUser(name: String): String {
        return if (Lib3Utils.isValid(name)) {
            Lib3Utils.formatMessage(name)
        } else {
            "Invalid user"
        }
    }

    fun performCalculation(x: Int, y: Int): String {
        val sum = Lib3Utils.calculateSum(x, y)
        return "Sum of $x and $y is $sum"
    }

    fun validateAndFormat(data: String?): String {
        return if (Lib3Utils.isValid(data)) {
            "Valid: $data"
        } else {
            "Invalid data"
        }
    }
}
