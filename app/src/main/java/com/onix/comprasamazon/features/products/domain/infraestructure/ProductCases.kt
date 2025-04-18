package com.onix.comprasamazon.features.products.domain.infraestructure

import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.core.utilities.CustomProcess

interface ProductCases {
    fun createProduct(): CustomProcess
    fun editProduct(): CustomProcess
    fun deleteProduct(): CustomProcess
    fun getProducts(): Result<List<BaseProduct>>
}