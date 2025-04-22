package com.onix.comprasamazon.features.amazon.appliation

import com.onix.comprasamazon.core.utilities.CustomProcess
import com.onix.comprasamazon.core.utilities.ResultO
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon
import com.onix.comprasamazon.features.amazon.domain.business.useCases.EditAmazon
import com.onix.comprasamazon.features.amazon.domain.business.useCases.FinalValueOfProducts
import com.onix.comprasamazon.features.amazon.domain.business.useCases.GetAmazon
import com.onix.comprasamazon.features.amazon.domain.infraestructure.AmazonCases
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import javax.inject.Inject

class AmazonUseCases @Inject constructor(
    private val getAmazon: GetAmazon,
    private val editAmazon: EditAmazon,
    private val finalValueOfProducts: FinalValueOfProducts
    ):AmazonCases{

    override suspend fun editAmazon(amazon: BaseAmazon): CustomProcess {
        editAmazon.execute(amazon)
        if(editAmazon.getState()){
            return CustomProcess.success()
        }
        return CustomProcess.failure(editAmazon.getError())
    }

    override suspend fun getAmazon(): ResultO<BaseAmazon> {
      getAmazon.execute()
        if(getAmazon.getState()){
            return ResultO.success(getAmazon.getValueCase()!!)
        }
        return ResultO.failure(getAmazon.getError())
    }

    override suspend fun calculateFinalValueOfProducts(products: List<BaseProduct>,amazon: BaseAmazon): ResultO<List<BaseProduct>> {
        finalValueOfProducts.execute(products,amazon)
        if(getAmazon.getState()){
            return ResultO.success(finalValueOfProducts.getValueCase()!!)
        }
        return ResultO.failure(getAmazon.getError())
    }

}