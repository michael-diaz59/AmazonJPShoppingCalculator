package com.onix.comprasamazon.ui.atomicDesign.molecules.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onix.comprasamazon.ui.features.product.UIProduct

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductItem(
    item: UIProduct, isSelected: Boolean,
    onClick: (UIProduct) -> Unit,
    onLongClick: (UIProduct) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent)
            .combinedClickable(
                onClick = { onClick(item) },
                onLongClick = { onLongClick(item) }
            )) {
        Row(Modifier.align(Alignment.Start)) {
            Text("nombre:")
            Spacer(modifier = Modifier.width(4.dp))
            Text(item.name)
        }
        Row(Modifier.align(Alignment.Start)) {
            Text("comprador:")
            Spacer(modifier = Modifier.width(4.dp))
            Text(item.buyer.toString())
        }
        Row(Modifier.align(Alignment.Start)) {
            Text("precio:")
            Spacer(modifier = Modifier.width(4.dp))
            Text(item.productValue.toString())
        }
        Row(Modifier.align(Alignment.Start)) {
            Text("valor de envio:")
            Spacer(modifier = Modifier.width(4.dp))
            Text(item.shippingValue.toString())
        }
    }
}

@Preview
@Composable
fun ProductItemSelectedPreview() {
    var selectedItems by remember { mutableStateOf(setOf<Int>()) }

    ProductItem(UIProduct(name = "test"), true, onClick = {
    }, onLongClick = {

    })
}

@Preview
@Composable
fun ProductItemNoSelectedPreview() {
    var selectedItems by remember { mutableStateOf(setOf<Int>()) }

    ProductItem(UIProduct(name = "test"), false, onClick = {
    }, onLongClick = {

    })
}
