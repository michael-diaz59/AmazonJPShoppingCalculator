package com.onix.comprasamazon.features.amazon.domain.infraestructure

import com.onix.comprasamazon.core.exceptions.gateway.GatewayException
import com.onix.comprasamazon.core.utilities.Either
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon

interface AmazonGateway {
    suspend fun editAmazon(amazon: BaseAmazon): Either<GatewayException, Boolean>
    suspend fun getAmazon(): Either<GatewayException,BaseAmazon>
}