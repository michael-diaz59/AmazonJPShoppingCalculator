package com.onix.comprasamazon.features.amazon.appliation.cases

import com.onix.comprasamazon.core.exceptions.errors.AppError
import com.onix.comprasamazon.features.amazon.domain.business.useCases.GetAmazon
import com.onix.comprasamazon.features.amazon.domain.infraestructure.AmazonGateway
import javax.inject.Inject

class GetAmazonCase @Inject constructor(private val localAmazonManager: AmazonGateway): GetAmazon() {

    override suspend fun execute(){
        val operation=localAmazonManager.getAmazon()
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