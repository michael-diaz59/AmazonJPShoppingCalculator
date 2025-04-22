package com.onix.comprasamazon.features.products.application.cases

import com.onix.comprasamazon.core.exceptions.errors.AppError
import com.onix.comprasamazon.features.products.data.local.LocalProductManager
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.GetProducts
import com.onix.comprasamazon.features.products.domain.infraestructure.ProductGateway
import javax.inject.Inject

class GetProductCase @Inject constructor(private val localProductManager: ProductGateway) : GetProducts() {

    override suspend fun execute() {
        val operation=localProductManager.getProducts()
        if(operation.isRight()){
            value=operation.getRight()!!
            isSuccessful=true
        }else{
            val gatewayException=operation.getLeft()
            appError= AppError()
            isSuccessful=false
        }
    }
}