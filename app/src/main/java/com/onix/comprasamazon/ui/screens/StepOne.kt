package com.onix.comprasamazon.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.onix.comprasamazon.features.buyer.domian.Buyer
import com.onix.comprasamazon.features.products.domain.Product


@Composable
fun StepOne() {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    var products by remember {
        mutableStateOf(listOf<Product>())
    }

    var addDialog by remember {
        mutableStateOf(false)
    }
    var editDialog by remember {
        mutableStateOf(false)
    }

    var selectedItems by remember { mutableStateOf(setOf<Int>()) }
    var editingItem by remember { mutableStateOf<Product?>(null) }

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
                            products = products.filterNot { selectedItems.contains(it.id) }
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
                addDialog=true
/*
                val newItem = Product(
                    id = (products.maxOfOrNull { it.id } ?: 0) + 1,
                    name = "Nuevo Item", buyer = Buyer()
                )
                products = products + newItem

 */
            }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(products) { item ->
                val isSelected = selectedItems.contains(item.id)
                ProductItem(item, isSelected, onClick = {
                    if (isSelectionMode) {
                        //selectedItems = selectedItems.toggle(item.id)
                    } else {
                        editingItem = item
                    }
                }, onLongClick = {
                    selectedItems = selectedItems + item.id
                })

                HorizontalDivider()
            }
        }
        if(addDialog){
            ProductDialog(null,products)
        }
        if (editingItem != null && !isSelectionMode) {
            ProductDialog(editingItem, products)
        }
    }
}

@Composable
fun ProductDialog(editingItem2: Product?, products2: List<Product>) {
    var name by remember { mutableStateOf("") }
    val buyer by remember { mutableStateOf(Buyer()) }
    var productValue by remember { mutableStateOf("") }
    var shippingValue by remember { mutableStateOf("") }

    var editingItem by remember { mutableStateOf(editingItem2) }
    var products by remember {
        mutableStateOf(products2)
    }

    val product by remember {
        mutableStateOf(Product())
    }
        AlertDialog(
            onDismissRequest = { editingItem = null },
            title = { Text("Editar nombre") },
            text = {
                Column {
                    Row {
                        numberTextField(name) { name = it }
                        numberTextField(buyer.name) {buyer.name = it}
                    }
                    Row {
                        numberTextField(productValue) {productValue=it}
                        numberTextField(shippingValue) {shippingValue=it}
                    }
                }

            },
            confirmButton = {
                TextButton(onClick = {
                    if(editingItem2==null){
                        products=products+
                    }

                    products = products.map {
                        if (it.id == editingItem!!.id) it.copy(name = name) else it
                    }
                    editingItem = null
                }) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { editingItem = null }) {
                    Text("Cancelar")
                }
            }
        )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductItem(
    item: Product, isSelected: Boolean,
    onClick: (Product) -> Unit,
    onLongClick: (Product) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent)
        .combinedClickable(
            onClick = { onClick(item) },
            onLongClick = { onLongClick(item) }
        )) {
        Row(Modifier.align(Alignment.Start)) {
            Text(item.name)
        }
        Row(Modifier.align(Alignment.Start)) {
            Text(item.name)
        }
    }
}

private fun Set<Int>.toggle(id: Int): Set<Int> {
    return if (contains(id)) this - id else this + id
}

