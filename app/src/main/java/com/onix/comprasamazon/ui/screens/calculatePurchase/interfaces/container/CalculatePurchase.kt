package com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.container

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.onix.comprasamazon.ui.logic.Screen
import com.onix.comprasamazon.ui.screens.calculatePurchase.CalculatePurchaseVM
import com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.steps.StepOne
import com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.steps.StepThree
import com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.steps.StepTwo

class CalculatePurchase(): Screen {


    @Composable
    override fun Body() {
        val viewModel: CalculatePurchaseVM = hiltViewModel()

        val stepOne = remember { StepOne(viewModel) }
        val stepTwo = remember { StepTwo(viewModel) }
        val stepThree = remember { StepThree(viewModel) }

        val tabs = listOf("Paso 1", "Paso 2", "Paso 3")
        var selectedTabIndex by remember { mutableIntStateOf(0) }

        Column {
            TabRow(
                selectedTabIndex = selectedTabIndex
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) }
                    )
                }
            }

            Crossfade(targetState = selectedTabIndex, label = "") { index ->
                when (index) {
                    0 -> stepOne.Body()
                    1 -> stepTwo.Body()
                    2 -> stepThree.Body()
                }
            }
        }

    }
}
