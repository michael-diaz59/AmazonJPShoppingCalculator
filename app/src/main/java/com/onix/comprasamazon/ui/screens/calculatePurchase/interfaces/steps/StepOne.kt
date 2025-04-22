package com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.steps

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.onix.comprasamazon.core.exceptions.errors.AppError
import com.onix.comprasamazon.ui.atomicDesign.molecules.cards.ProductItem
import com.onix.comprasamazon.ui.atomicDesign.organisms.dialogs.DialogEditProduct
import com.onix.comprasamazon.ui.features.product.UIProduct
import com.onix.comprasamazon.ui.logic.Screen
import com.onix.comprasamazon.ui.screens.calculatePurchase.CalculatePurchaseVM

class StepOne(private val viewModel: CalculatePurchaseVM) : Screen {

    @Composable
    override fun Body() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column {
                Row {
                    Text(
                        "coloca los productos con su costo de producto y costo de envio",
                        fontSize = 20.sp
                    )
                }
                ProductListScreen()

            }
        }
    }

    @SuppressLint("MutableCollectionMutableState")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductListScreen() {

        val error: AppError = viewModel.appError.value
        var products = viewModel.products
        var addDialog by remember {
            mutableStateOf(false)
        }

        var selectedItems by remember { mutableStateOf(setOf<UIProduct>()) }
        var editingItem by remember { mutableStateOf<UIProduct?>(null) }

        val isSelectionMode = selectedItems.isNotEmpty()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(if (isSelectionMode) "${selectedItems.size} seleccionados" else "Lista de Items")
                    },
                    actions = {
                        if (isSelectionMode) {
                            IconButton(onClick = {
                                viewModel.deleteProducts(selectedItems)
                                selectedItems = emptySet()
                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                            }
                        }
                    }
                )
            },

            floatingActionButton = {
                FloatingActionButton(onClick = {
                    addDialog = true
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar")
                }
            }
        ) { padding ->
            LazyColumn(contentPadding = padding) {
                items(products) { item ->
                    val isSelected = selectedItems.contains(item)
                    ProductItem(
                        item, isSelected,
                        onClick = {
                            if (isSelectionMode) {
                                selectedItems = selectedItems + item
                            } else {
                                editingItem = item
                            }
                        }, onLongClick = {
                            selectedItems = selectedItems + item
                        })

                    HorizontalDivider()
                }
            }
            if (addDialog) {
                DialogEditProduct(
                    null,
                    onCancelate = {
                        editingItem = null
                        addDialog = false
                    }, onProducts = {
                        viewModel.createProduct(it)
                        addDialog = false
                    }
                )

            }
            if (editingItem != null && !isSelectionMode) {
                DialogEditProduct(
                    editingItem,
                    onCancelate = { editingItem = null },
                    onProducts = { productEdited ->
                        viewModel.editProduct(productEdited)
                        editingItem = null
                    })

            }
        }
    }
}

@Preview
@Composable
fun StepOnePreview() {
    val viewModel: CalculatePurchaseVM = hiltViewModel()
    StepOne(viewModel).Body()
}
