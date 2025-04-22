package com.onix.comprasamazon.ui.atomicDesign.organisms.dialogs

import android.app.Dialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onix.comprasamazon.R
import com.onix.comprasamazon.ui.atomicDesign.molecules.textFields.NameTextField
import com.onix.comprasamazon.ui.atomicDesign.molecules.textFields.NumberTextField
import com.onix.comprasamazon.ui.features.product.UIProduct

@Composable
fun DialogEditProduct(
    editingItem2: UIProduct?,
    onCancelate: () -> Unit,
    onProducts: (UIProduct) -> Unit
) {

    val context = LocalContext.current

    val product by remember {
        mutableStateOf(
            editingItem2 ?: UIProduct(
                name = "0",
                buyer = 0L,
                shippingValue = 0.0,
                productValue = 0.0
            )
        )
    }

    var name by remember { mutableStateOf(product.name) }
    var buyer by remember { mutableStateOf(product.buyer) }
    var productValue by remember { mutableStateOf(product.productValue.toString()) }
    var shippingValue by remember { mutableStateOf(product.shippingValue.toString()) }




    AlertDialog(
        modifier = Modifier,

        onDismissRequest = { onCancelate() },
        title = { Text("Editar nombre") },
        text = {
            Column {

                NameTextField(
                    value = name,
                    label = "nombre",
                    onValueChange = { name = it;product.name = it })
                HorizontalDivider(thickness = 4.dp, modifier = Modifier.background(Color.White))
                NumberTextField(
                    value = buyer.toString(),
                    label = "comprador",
                    onValueChange = {
                        if (it.isNotEmpty()) {
                            buyer = it.toLong();
                            product.buyer = it.toLong()
                        }
                    }
                )
                HorizontalDivider(thickness = 4.dp, modifier = Modifier.background(Color.White))
                NumberTextField(productValue, "precio") {
                    productValue = it;
                    if (it.isNotEmpty()) {
                        product.productValue = it.toDouble()
                    }
                }
                HorizontalDivider(thickness = 4.dp, modifier = Modifier.background(Color.White))
                NumberTextField(shippingValue, "valor de envio") {
                    shippingValue = it;
                    if (it.isNotEmpty()) {
                        product.shippingValue = it.toDouble()
                    }
                }

            }

        },
        confirmButton = {
            TextButton(onClick = {
                product.id = 2
                product.name = name
                product.productValue = productValue.toDouble()
                product.shippingValue = shippingValue.toDouble()
                product.buyer = buyer

                onProducts(product)
            }) {
                Text(context.getString(R.string.save))
            }
        },
        dismissButton = {
            TextButton(onClick = { onCancelate() }) {
                Text("Cancelar")
            }
        }
    )
}

@Preview
@Composable
fun DialogEditProductPreview() {
    DialogEditProduct(
        UIProduct(name = "test", buyer = 0L, shippingValue = 2.0, productValue = 3.0),
        {},
        {})
}