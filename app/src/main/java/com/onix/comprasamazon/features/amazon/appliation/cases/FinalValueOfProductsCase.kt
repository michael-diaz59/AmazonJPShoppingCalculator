package com.onix.comprasamazon.features.amazon.appliation.cases

import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon
import com.onix.comprasamazon.features.amazon.domain.business.useCases.FinalValueOfProducts
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import javax.inject.Inject

class FinalValueOfProductsCase @Inject constructor() :FinalValueOfProducts() {
    private var totalShippingValue=0.0
    override suspend fun execute(products: List<BaseProduct>, amazon: BaseAmazon) {
        calculateTotalShippingValue(products)
        products.forEach {
            it.finalValue=totalShippingCost(percentageOfShippingCost(it.shippingValue))+it.productValue
        }
    }
    private fun calculateTotalShippingValue(products: List<BaseProduct>){
        products.forEach {
            totalShippingValue+=it.shippingValue
        }
    }
    private fun percentageOfShippingCost(shippingValue:Double):Double{
        return (shippingValue/totalShippingValue)*100
    }

    private fun totalShippingCost(percentageOfShippingCost:Double):Double{
        return (percentageOfShippingCost/100)*totalShippingValue
    }

}