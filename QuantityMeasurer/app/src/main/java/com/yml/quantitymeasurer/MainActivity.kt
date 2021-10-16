package com.yml.quantitymeasurer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity","Process Created")
        val convert = findViewById<Button>(R.id.convertingButton) as Button
        val add = findViewById<Button>(R.id.addingButton)

        convert.setOnClickListener {
            switchFragment(ConvertFragment())
        }

        add.setOnClickListener {
            switchFragment(AddFragment())
        }

    }

    private fun switchFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_convert,fragment)
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","Process Started")
        println("Process Started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","Process Resumed")
        println("Process Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","Process Paused")
        println("Process Paused")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity","Process Restarted")
        println("Process Restarted")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","Process Destroyed")
        println("Process Destroyed")
    }
}