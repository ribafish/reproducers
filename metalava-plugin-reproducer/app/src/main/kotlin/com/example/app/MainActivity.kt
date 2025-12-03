package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lib1.Lib1Utils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = Lib1Utils.getMessage()
        android.util.Log.d("MainActivity", message)

        val userMessage = Lib1Utils.processUserData("Alice")
        android.util.Log.d("MainActivity", userMessage)

        val calcMessage = Lib1Utils.computeAndFormat(10, 20)
        android.util.Log.d("MainActivity", calcMessage)

        val (isValid, validationMessage) = Lib1Utils.validateUserInput("TestInput")
        android.util.Log.d("MainActivity", "Valid: $isValid, Message: $validationMessage")
    }
}
