package com.onix.comprasamazon.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun StepTwo() {
    var value by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Row {
                Text("coloca el total que te cobra amazon jp", fontSize = 20.sp)
            }
            Row{
                numberTextField(value) {
                    value = it
                }
            }

        }
    }
}

@Composable
fun numberTextField(value: String, onValueChange: (String) -> Unit){

    TextField(value = value, onValueChange = {newText->
        if (newText.all { it.isDigit() }) {
            onValueChange(newText)
        }
    },keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Done
    )
    )
}