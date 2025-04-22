package com.onix.comprasamazon.core.utilities

class Validator {

    companion object{
        /**
         * This function accepts that the input can be a name.
         */
        fun isName(input: String): Boolean {
            return input.matches(Regex("^[\\p{L} ]+$"))
        }

        /**
         * This function accepts that the input be a number
         */
        fun isNumber(newText: String): Boolean {
            return newText.all { it.isDigit() }
        }
    }

}