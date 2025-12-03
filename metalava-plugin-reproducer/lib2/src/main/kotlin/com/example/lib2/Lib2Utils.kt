package com.example.lib2

import com.example.lib3.Lib3Utils

object Lib2Utils {
    fun getLib2Message(): String {
        return "Lib2: ${Lib3Utils.getLib3Message()}"
    }
}
