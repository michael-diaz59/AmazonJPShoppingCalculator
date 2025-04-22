package com.onix.comprasamazon.core.di.modules

import com.onix.comprasamazon.features.amazon.appliation.cases.EditAmazonCase
import com.onix.comprasamazon.features.amazon.appliation.cases.FinalValueOfProductsCase
import com.onix.comprasamazon.features.amazon.appliation.cases.GetAmazonCase
import com.onix.comprasamazon.features.amazon.domain.business.useCases.EditAmazon
import com.onix.comprasamazon.features.amazon.domain.business.useCases.FinalValueOfProducts
import com.onix.comprasamazon.features.amazon.domain.business.useCases.GetAmazon
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AmazonUseCasesModule {
    @Binds
    abstract fun bindCreateProductCase(
        imple: EditAmazonCase
    ): EditAmazon

    @Binds
    abstract fun bindGetAmazonCase(
        impl: GetAmazonCase
    ): GetAmazon

    @Binds
    abstract fun bindFinaleValueOfProductsCase(
        impl: FinalValueOfProductsCase
    ): FinalValueOfProducts
}