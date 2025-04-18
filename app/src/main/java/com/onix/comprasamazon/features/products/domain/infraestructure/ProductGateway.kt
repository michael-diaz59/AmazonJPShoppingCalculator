package com.onix.comprasamazon.features.products.domain.infraestructure

import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.core.utilities.Either
import com.onix.comprasamazon.core.exceptions.gateway.GatewayException
import com.onix.comprasamazon.features.products.data.local.room.RoomProduct

interface ProductGateway {
    suspend fun createProduct(product: BaseProduct): Either<GatewayException, Long>
    fun editProduct(product: BaseProduct): Either<GatewayException, Boolean>
    fun deleteProduct(product: BaseProduct): Either<GatewayException, Boolean>
    fun getProducts(): Either<GatewayException, List<BaseProduct>>
}