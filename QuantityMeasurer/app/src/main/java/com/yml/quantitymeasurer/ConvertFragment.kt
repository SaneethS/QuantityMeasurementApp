package com.yml.quantitymeasurer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.yml.quantitymeasurer.databinding.ConvertFragmentBinding
import com.yml.quantitymeasurer.util.ChosenQuantity.chosenQuantity
import com.yml.quantitymeasurer.logic.ConvertQuantity

class ConvertFragment: Fragment(R.layout.convert_fragment) {
    lateinit var binding: ConvertFragmentBinding
    companion object{
        private var selectedQuantity: String = "Length"
        private var userQuantity:String = "cm"
        private var resultQuantity: String = "cm"
        private var value: Float = 0f
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ConvertFragmentBinding.bind(view)
//        binding.metric1.setText(0)

        var arrayAdapter = ArrayAdapter.createFromResource(requireContext(),R.array.measurements,android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.metrics.adapter = arrayAdapter
        binding.metrics.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                selectedQuantity = binding.metrics.selectedItem.toString()
                measurementChoice()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedQuantity = "Length"
                measurementChoice()
            }

        }

        binding.spinnerLConvert.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                userQuantity = binding.spinnerLConvert.selectedItem.toString()
                convertValue()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.spinnerRConvert.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                resultQuantity = binding.spinnerRConvert.selectedItem.toString()
                convertValue()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.metric1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                value = if(!s.isNullOrEmpty())
                            s.toString().toFloat()
                        else
                            Float.MAX_VALUE
                convertValue()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun convertValue() {
        var result = ConvertQuantity.convert(value, selectedQuantity, userQuantity, resultQuantity)
        binding.metric2.setText(result.toString())
    }

    fun measurementChoice(){
        var choice = chosenQuantity(requireContext(), selectedQuantity)
        binding.spinnerLConvert.adapter = choice
        binding.spinnerRConvert.adapter =choice

    }

}