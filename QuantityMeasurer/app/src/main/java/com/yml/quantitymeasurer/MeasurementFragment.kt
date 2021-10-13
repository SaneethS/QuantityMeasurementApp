package com.yml.quantitymeasurer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class MeasurementFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MeasurementFragment","Fragment onCreate Called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MeasurementFragment","Fragment onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MeasurementFragment","Fragment onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MeasurementFragment","Fragment onPause Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MeasurementFragment","Fragment onDestroy Called")
    }
}