package com.yml.quantitymeasurer

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.yml.quantitymeasurer.util.ChosenQuantity

class AddFragment: Fragment(R.layout.add_fragment) {
    lateinit var selectedQuantity: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        var mainSpinner = view.findViewById<Spinner>(R.id.spinnerAdd)
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
                measurementAdd(selectedQuantity, view)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedQuantity = "Length"
                measurementAdd(selectedQuantity, view)
            }

        }
    }

    fun measurementAdd(selectedQuantity: String, view: View){
        var choice = ChosenQuantity.chosenQuantity(requireContext(), selectedQuantity)
        var leftSpinner = view.findViewById<Spinner>(R.id.spinnerAdd1)
        var rightSpinner = view.findViewById<Spinner>(R.id.spinnerAdd2)
        var resultSpinner = view.findViewById<Spinner>(R.id.spinnerTotal)
        leftSpinner.adapter = choice
        rightSpinner.adapter = choice
        resultSpinner.adapter = choice

    }

}