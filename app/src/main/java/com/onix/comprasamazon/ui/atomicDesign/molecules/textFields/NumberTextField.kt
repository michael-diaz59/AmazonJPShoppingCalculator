package com.onix.comprasamazon.ui.atomicDesign.molecules.textFields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.onix.comprasamazon.ui.atomicDesign.subAtomicParticles.CustomKeyboard
import com.onix.comprasamazon.core.utilities.Validator

@Composable
fun NumberTextField(value: String, label: String, onValueChange: (String) -> Unit){

    TextField(value = value, onValueChange = {newText->
        if (Validator.isNumber(newText)) {
            onValueChange(newText)
        }
    },keyboardOptions = CustomKeyboard.number(),
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}