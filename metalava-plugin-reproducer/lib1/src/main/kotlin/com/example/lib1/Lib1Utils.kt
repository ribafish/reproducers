package com.example.lib1

import com.example.lib2.Lib2Utils

object Lib1Utils {
    fun getMessage(): String {
        return "Lib1: ${Lib2Utils.getLib2Message()}"
    }
}
