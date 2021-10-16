package com.yml.quantitymeasurer.util

import android.content.Context
import android.widget.ArrayAdapter
import com.yml.quantitymeasurer.R

object ChosenQuantity {
    fun chosenQuantity(context: Context, choice: String): ArrayAdapter<CharSequence>{
        var quantityArray = when(choice){
            "Length" -> R.array.lengthMeasurement
            "Weight" -> R.array.weightMeasurement
            "Volume" -> R.array.volumeMeasurement
            "Temperature" -> R.array.temperatureMeasurement
            else -> R.array.lengthMeasurement
        }
        var arrayAdapter = ArrayAdapter.createFromResource(context, quantityArray!!, android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return arrayAdapter
    }
}