package com.onix.comprasamazon.features.amazon.appliation.cases

import com.onix.comprasamazon.core.exceptions.errors.AppError
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon
import com.onix.comprasamazon.features.amazon.domain.business.useCases.EditAmazon
import com.onix.comprasamazon.features.amazon.domain.infraestructure.AmazonGateway
import javax.inject.Inject

class EditAmazonCase  @Inject constructor(private val localAmazonManager: AmazonGateway):EditAmazon() {

    override suspend fun execute(amazon: BaseAmazon){
        val operation=localAmazonManager.editAmazon(amazon)
        if(operation.isRight()){
            value=operation.getRight()
            isSuccessful=true
        }else{
            val gatewayException=operation.getLeft()
            appError= AppError()
            isSuccessful=false
        }
    }
}