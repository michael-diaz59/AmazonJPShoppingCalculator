package com.onix.comprasamazon.features.products.domain.infraestructure

import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.core.utilities.CustomProcess
import com.onix.comprasamazon.core.utilities.ResultO

interface ProductCases {
    suspend fun createProduct(product: BaseProduct): ResultO<Long>
    suspend fun editProduct(product: BaseProduct): CustomProcess
    suspend fun deleteProduct(product: BaseProduct): CustomProcess
    suspend fun getProducts(): ResultO<List<BaseProduct>>
}