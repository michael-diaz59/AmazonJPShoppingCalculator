package com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.steps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import com.onix.comprasamazon.ui.screens.calculatePurchase.CalculatePurchaseVM

class StepThree(private val viewModel: CalculatePurchaseVM) {


    @Composable
    fun Body() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column {
                Row {
                    Text("total de costo por producto", fontSize = 20.sp)
                }
            }
        }
    }
}
