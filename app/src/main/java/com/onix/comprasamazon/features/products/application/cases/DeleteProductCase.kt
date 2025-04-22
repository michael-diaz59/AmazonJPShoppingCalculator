package com.onix.comprasamazon.features.products.application.cases

import com.onix.comprasamazon.core.exceptions.errors.AppError
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.DeleteProduct
import com.onix.comprasamazon.features.products.domain.infraestructure.ProductGateway
import javax.inject.Inject

class DeleteProductCase @Inject constructor(private val localProductManager: ProductGateway) :DeleteProduct(

) {


    override suspend fun execute(baseProduct: BaseProduct) {
        val operation=localProductManager.deleteProduct(baseProduct)
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