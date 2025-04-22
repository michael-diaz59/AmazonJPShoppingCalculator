package com.onix.comprasamazon.features.amazon.domain.business.useCases

import com.onix.comprasamazon.core.domain.UseCase
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct

abstract class FinalValueOfProducts: UseCase<List<BaseProduct>>() {
    abstract suspend fun execute(products: List<BaseProduct>,amazon: BaseAmazon)
}