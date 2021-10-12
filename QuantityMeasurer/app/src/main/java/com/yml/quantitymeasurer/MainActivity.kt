package com.yml.quantitymeasurer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        println("Process Started")
    }

    override fun onResume() {
        super.onResume()
        println("Process Resumed")
    }

    override fun onPause() {
        super.onPause()
        println("Process Paused")
    }

    override fun onRestart() {
        super.onRestart()
        println("Process Restarted")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Process Destroyed")
    }
}