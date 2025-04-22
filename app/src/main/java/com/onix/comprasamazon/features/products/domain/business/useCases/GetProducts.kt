package com.onix.comprasamazon.features.products.domain.business.useCases;

import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.core.domain.UseCase

abstract class GetProducts : UseCase<List<BaseProduct>>(){

    abstract suspend fun execute()

}
