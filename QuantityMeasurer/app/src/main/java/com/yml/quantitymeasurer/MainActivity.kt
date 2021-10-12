package com.yml.quantitymeasurer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("status","Process Created")
    }

    override fun onStart() {
        super.onStart()
        Log.i("status","Process Started")
        println("Process Started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("status","Process Resumed")
        println("Process Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("status","Process Paused")
        println("Process Paused")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("status","Process Restarted")
        println("Process Restarted")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("status","Process Destroyed")
        println("Process Destroyed")
    }
}