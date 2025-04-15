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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.onix.comprasamazon.features.products.domain.Product

@Composable
fun StepOne() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Row {
                Text("coloca los productos con su costo de producto y costo de envio", fontSize = 20.sp)
            }
            ProductListScreen()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    var products by remember {
        mutableStateOf(
            List(10) { index -> Product(id = index, name = "Item $index") }
        )
    }

    var selectedItems by remember { mutableStateOf(setOf<Int>()) }
    var editingItem by remember { mutableStateOf<Product?>(null) }
    var newName by remember { mutableStateOf("") }

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
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(products) { item ->
                val isSelected = selectedItems.contains(item.id)
                ProductItem(item,isSelected,isSelectionMode, onClick = {
                    if (isSelectionMode) {
                        selectedItems = selectedItems.toggle(item.id)
                    } else {
                        editingItem = item
                        newName = item.name
                    }
                },onLongClick = {
                        selectedItems = selectedItems + item.id
                    })

                HorizontalDivider()
            }
        }

        if (editingItem != null) {
            AlertDialog(
                onDismissRequest = { editingItem = null },
                title = { Text("Editar nombre") },
                text = {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Nuevo nombre") }
                    )
                },
                confirmButton = {
                    TextButton(onClick = {
                        products = products.map {
                            if (it.id == editingItem!!.id) it.copy(name = newName) else it
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
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductItem(item: Product , isSelected: Boolean,
                isSelectionMode: Boolean,
                onClick: (Product) -> Unit,
                onLongClick: (Product) -> Unit){
    Column {
        Row {
           Box( modifier = Modifier
               .fillMaxWidth()
               .background(if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent)
               .combinedClickable(
                   onClick = { onClick(item) },
                   onLongClick = { onLongClick(item) }
               )){
               Text(item.name)

           }


        }
    }
}

fun Set<Int>.toggle(id: Int): Set<Int> {
    return if (contains(id)) this - id else this + id
}