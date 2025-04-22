package com.onix.comprasamazon.features.amazon.domain.infraestructure

import com.onix.comprasamazon.core.utilities.CustomProcess
import com.onix.comprasamazon.core.utilities.ResultO
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct

interface AmazonCases {
    suspend fun editAmazon(amazon: BaseAmazon): CustomProcess
    suspend fun getAmazon(): ResultO<BaseAmazon>
    suspend fun calculateFinalValueOfProducts(products:List<BaseProduct>): ResultO<List<BaseProduct>>
}