package com.onix.comprasamazon.ui.screens.calculatePurchase

import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onix.comprasamazon.core.exceptions.errors.AppError
import com.onix.comprasamazon.features.products.application.ProductUseCases
import com.onix.comprasamazon.ui.features.product.UIProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State


@HiltViewModel
class CalculatePurchaseVM @Inject constructor(
    private val productUseCase:ProductUseCases
) : ViewModel() {

    private val _appError= mutableStateOf(AppError())
    val appError:State<AppError> get() = _appError

    private val _products = mutableStateListOf<UIProduct>()
    val products: List<UIProduct> get() = _products

    private val amazonPrice = mutableLongStateOf(0L)

    fun getProducts() {
        viewModelScope.launch {
            val result = productUseCase.getProducts()
            if (result.isSuccessful()) {
                val baseProducts = result.getValue()!!
                val uiProducts = baseProducts.map { baseProduct->return@map UIProduct.baseToUI(baseProduct) }
                _products.clear()
                _products.addAll(uiProducts)
            } else {
                _appError.value.copy(result.getError()!!)
            }
        }
    }

    fun createProduct(product: UIProduct) {
        viewModelScope.launch{
            val result = productUseCase.createProduct(product)
            if (result.isSuccessful()) {
                product.id= result.getValue()!!
                _products.add(product)
            }else{
                _appError.value.copy(result.getError()!!)
            }
        }

    }

    fun editProduct(productToEdit: UIProduct) {
        viewModelScope.launch{
            val result = productUseCase.editProduct(productToEdit)
            if (result.isSuccessful()) {
                val index = _products.indexOfFirst { it.id == productToEdit.id }
                if (index != -1) {
                    _products[index] = productToEdit
                }
            }else{
                _appError.value.copy(result.getError()!!)
            }
        }
    }

    fun deleteProduct(productToDelete: UIProduct) {
        viewModelScope.launch{
            val result = productUseCase.deleteProduct(productToDelete)
            if (result.isSuccessful()) {
                _products.remove(productToDelete)
            }else{
                _appError.value.copy(result.getError()!!)}
        }
    }

    fun deleteProducts(productToRemove: Set<UIProduct>) {
        viewModelScope.launch{
            productToRemove.map {
                deleteProduct(it)
            }
        }

    }

}