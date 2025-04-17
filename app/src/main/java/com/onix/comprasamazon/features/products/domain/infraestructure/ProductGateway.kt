package com.onix.comprasamazon.features.products.domain.infraestructure

import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.utilities.domain.Either
import com.onix.comprasamazon.utilities.domain.GatewayException

interface ProductGateway {
    fun createProduct(): Either<GatewayException,Boolean>
    fun editProduct(): Either<GatewayException,Boolean>
    fun deleteProduct(): Either<GatewayException,Boolean>
    fun getProducts(): Either<GatewayException,List<BaseProduct>>
}