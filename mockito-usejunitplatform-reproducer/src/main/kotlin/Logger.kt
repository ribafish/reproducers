package org.example

data class Logger(val message: String) {
    fun log() {
        println(message)
    }

    companion object {
        const val MESSAGE = "Stuff"
    }
}