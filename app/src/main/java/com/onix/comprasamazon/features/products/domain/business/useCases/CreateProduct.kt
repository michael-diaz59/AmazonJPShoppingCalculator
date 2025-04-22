package com.onix.comprasamazon.features.products.domain.business.useCases

import com.onix.comprasamazon.core.domain.UseCase
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct

abstract class CreateProduct : UseCase<Long>(){

    abstract suspend fun execute(baseProduct: BaseProduct)
}


