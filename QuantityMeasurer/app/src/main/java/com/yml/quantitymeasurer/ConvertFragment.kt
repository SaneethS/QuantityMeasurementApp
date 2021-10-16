package com.yml.quantitymeasurer

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.yml.quantitymeasurer.util.ChosenQuantity.chosenQuantity

class ConvertFragment: Fragment(R.layout.convert_fragment) {
    lateinit var selectedQuantity: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mainSpinner = view.findViewById<Spinner>(R.id.metrics)
        var arrayAdapter = ArrayAdapter.createFromResource(requireContext(),R.array.measurements,android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mainSpinner.adapter = arrayAdapter
        mainSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                selectedQuantity = mainSpinner.selectedItem.toString()
                measurementChoice(selectedQuantity, view)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedQuantity = "Length"
                measurementChoice(selectedQuantity, view)
            }

        }

    }

    fun measurementChoice(selectedQuantity: String, view: View){
        var choice = chosenQuantity(requireContext(), selectedQuantity)
        var leftSpinner = view.findViewById<Spinner>(R.id.spinnerLConvert)
        var rightSpinner = view.findViewById<Spinner>(R.id.spinnerRConvert)
        leftSpinner.adapter = choice
        rightSpinner.adapter =choice

    }

}