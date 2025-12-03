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
    }
}
