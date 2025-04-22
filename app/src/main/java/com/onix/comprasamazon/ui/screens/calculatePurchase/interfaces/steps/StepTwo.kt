package com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.steps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.onix.comprasamazon.R
import com.onix.comprasamazon.ui.atomicDesign.molecules.textFields.NumberTextField
import com.onix.comprasamazon.ui.logic.Screen
import com.onix.comprasamazon.ui.screens.calculatePurchase.CalculatePurchaseVM


class StepTwo(private val viewModel: CalculatePurchaseVM): Screen {

    @Composable
    override fun Body() {
        val context = LocalContext.current
        var value by remember {
            mutableStateOf("")
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column {
                Row {

                    Text(context.getString(R.string.enterTotalAmazonCharge), fontSize = 20.sp)
                }
                Row{
                    NumberTextField(value,"") {
                        value = it
                    }
                }

            }
        }
    }

}






