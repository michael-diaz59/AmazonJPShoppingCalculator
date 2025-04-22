package com.onix.comprasamazon.features.amazon.domain.business.useCases

import com.onix.comprasamazon.core.domain.UseCase
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon

abstract class EditAmazon: UseCase<Boolean>() {
    abstract suspend fun execute(amazon: BaseAmazon)
}