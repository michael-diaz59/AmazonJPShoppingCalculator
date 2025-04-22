package com.onix.comprasamazon.ui.atomicDesign.subAtomicParticles

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType

class CustomKeyboard {
    companion object{
        fun number(): KeyboardOptions {
            //platformImeOptions no debe ser configurado en compose nativo
            return KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
                showKeyboardOnFocus=false,
                hintLocales=null
            )

        }
        fun text(): KeyboardOptions {
            //platformImeOptions no debe ser configurado en compose nativo
            return KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                showKeyboardOnFocus=false,
                hintLocales=null
            )

        }
    }
}