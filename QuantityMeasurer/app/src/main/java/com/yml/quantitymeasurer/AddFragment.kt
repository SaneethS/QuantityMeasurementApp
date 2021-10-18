package com.yml.quantitymeasurer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.yml.quantitymeasurer.databinding.AddFragmentBinding
import com.yml.quantitymeasurer.util.ChosenQuantity
import com.yml.quantitymeasurer.logic.ConvertQuantity

class AddFragment: Fragment(R.layout.add_fragment) {
    private lateinit var binding: AddFragmentBinding
    companion object{
        private var selectedQuantity: String = "Length"
        private var userQuantity1:String = "cm"
        private var userQuantity2:String = "cm"
        private var resultQuantity: String = "cm"
        private var value1: Float = Float.MAX_VALUE
        private var value2: Float = Float.MAX_VALUE
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AddFragmentBinding.bind(view)

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

        binding.spinnerAdd1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                userQuantity1 = binding.spinnerAdd1.selectedItem.toString()
                addValue()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.spinnerAdd2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                userQuantity2 = binding.spinnerAdd2.selectedItem.toString()
                addValue()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spinnerTotal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                resultQuantity = binding.spinnerTotal.selectedItem.toString()
                addValue()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.metricAdd1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                value1 = if(!s.isNullOrEmpty())
                            s.toString().toFloat()
                        else
                            Float.MAX_VALUE
                addValue()
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        binding.metricAdd2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                value2 = if(!s.isNullOrEmpty())
                            s.toString().toFloat()
                        else
                            Float.MAX_VALUE
                addValue()
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    fun addValue(){
        var result = ConvertQuantity.add(value1, value2,selectedQuantity, userQuantity1,
            userQuantity2, resultQuantity)
        binding.metricTotal.setText(result.toString())
    }

    fun measurementAdd(){
        var choice = ChosenQuantity.chosenQuantity(requireContext(), selectedQuantity)
        binding.spinnerAdd1.adapter = choice
        binding.spinnerAdd2.adapter = choice
        binding.spinnerTotal.adapter = choice
    }

}