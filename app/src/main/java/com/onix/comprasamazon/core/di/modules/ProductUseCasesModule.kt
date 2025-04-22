package com.onix.comprasamazon.core.di.modules

import com.onix.comprasamazon.features.products.application.cases.CreateProductCase
import com.onix.comprasamazon.features.products.application.cases.DeleteProductCase
import com.onix.comprasamazon.features.products.application.cases.EditProductCase
import com.onix.comprasamazon.features.products.application.cases.GetProductCase
import com.onix.comprasamazon.features.products.domain.business.useCases.CreateProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.DeleteProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.EditProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.GetProducts
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductUseCasesModule {
    @Binds
    abstract fun bindCreateProductCase(
        impl: CreateProductCase
    ): CreateProduct

    @Binds
    abstract fun bindEditProductCase(
        impl: EditProductCase
    ): EditProduct

    @Binds
    abstract fun bindDeleteProductCase(
        impl: DeleteProductCase
    ): DeleteProduct

    @Binds
    abstract fun bindGetProductsCase(
        impl: GetProductCase
    ): GetProducts
}