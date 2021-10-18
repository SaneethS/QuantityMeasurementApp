package com.yml.quantitymeasurer.logic

object ConvertQuantity {
    fun convert(value: Float, mainQuantity: String, fromQuantity: String, toQuantity: String):Float {
        if(value == Float.MAX_VALUE) return 0f
        return when(mainQuantity){
            "Length" -> convertLength(value,fromQuantity,toQuantity)
            "Weight" -> convertWeight(value,fromQuantity,toQuantity)
            "Volume" -> convertVolume(value,fromQuantity,toQuantity)
            "Temperature" -> convertTemperature(value,fromQuantity,toQuantity)
            else -> value
        }
    }

    fun add(value1: Float, value2: Float, mainQuantity: String, quantity1: String, quantity2: String, quantityResult: String):Float{
        var metric1 = convert(value1, mainQuantity, quantity1, quantityResult)
        var metric2 = convert(value2, mainQuantity, quantity2, quantityResult)
        return metric1 + metric2
    }

    private fun convertTemperature(value: Float, fromQuantity: String, toQuantity: String): Float {
        return when(fromQuantity){
            "C" -> convertC(value,toQuantity)
            "F" -> convertF(value,toQuantity)
            "K" -> convertK(value,toQuantity)
            else -> value
        }
    }

    private fun convertK(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "C" -> value - 273.15f
            "F" -> (value - 273.15f)*(9f/5f) + 32
            else -> value
        }
    }

    private fun convertF(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "C" -> (value - 32) * (5f/9f)
            "K" -> (value - 32) * (5f/9f) + 273.15f
            else -> value
        }
    }

    private fun convertC(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "F" -> (value * (9f/5f)) + 32
            "K" -> value + 273.15f
            else -> value
        }
    }

    private fun convertVolume(value: Float, fromQuantity: String, toQuantity: String): Float {
        return when(fromQuantity){
            "ml" -> convertMl(value,toQuantity)
            "l" -> convertL(value,toQuantity)
            "gallon" -> convertGallon(value,toQuantity)
            else -> value
        }
    }

    private fun convertGallon(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "ml" -> value * 3785
            "l" -> value * 3.785f
            else -> value
        }
    }

    private fun convertL(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "ml" -> value*1000
            "gallon" -> value/3.785f
            else -> value
        }
    }

    private fun convertMl(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "l" -> value/1000
            "gallon" -> value/3785
            else -> value
        }
    }

    private fun convertWeight(value: Float, fromQuantity: String, toQuantity: String): Float {
        return when(fromQuantity){
            "g" -> convertG(value,toQuantity)
            "kg" -> convertKg(value,toQuantity)
            "ton" -> convertTon(value,toQuantity)
            else -> value
        }
    }

    private fun convertTon(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "g" -> value*1000000
            "kg" -> value*1000
            else -> value
        }
    }

    private fun convertKg(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "g" -> value*1000
            "ton" -> value/1000
            else -> value
        }
    }

    private fun convertG(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "kg" -> value/1000
            "ton" -> value/1000000
            else -> value
        }
    }

    private fun convertLength(value: Float, fromQuantity: String, toQuantity: String): Float {
        return when(fromQuantity){
            "cm" -> convertCm(value,toQuantity)
            "m" -> convertM(value,toQuantity)
            "km" -> convertKm(value,toQuantity)
            else -> value
        }
    }

    private fun convertKm(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "cm" -> value*100000
            "m" -> value*1000
            else -> value
        }
    }

    private fun convertM(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "cm" -> value*100
            "km" -> value/1000
            else -> value
        }
    }

    private fun convertCm(value: Float, toQuantity: String): Float {
        return when(toQuantity){
            "m" -> value/100
            "km" -> value/100000
            else -> value
        }
    }
}