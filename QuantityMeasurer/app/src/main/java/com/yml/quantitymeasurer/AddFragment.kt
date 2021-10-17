package com.yml.quantitymeasurer

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.yml.quantitymeasurer.databinding.AddFragmentBinding
import com.yml.quantitymeasurer.util.ChosenQuantity

class AddFragment: Fragment(R.layout.add_fragment) {
    private lateinit var binding: AddFragmentBinding
    lateinit var selectedQuantity: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)

        var arrayAdapter = ArrayAdapter.createFromResource(requireContext(),R.array.measurements,android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerAdd.adapter = arrayAdapter
        binding.spinnerAdd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                selectedQuantity = binding.spinnerAdd.selectedItem.toString()
                measurementAdd()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedQuantity = "Length"
                measurementAdd()
            }

        }
    }

    fun measurementAdd(){
        var choice = ChosenQuantity.chosenQuantity(requireContext(), selectedQuantity)
        binding.spinnerAdd1.adapter = choice
        binding.spinnerAdd2.adapter = choice
        binding.spinnerTotal.adapter = choice

    }

}