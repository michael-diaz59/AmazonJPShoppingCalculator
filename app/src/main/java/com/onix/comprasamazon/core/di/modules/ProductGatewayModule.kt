package com.onix.comprasamazon.core.di.modules

import com.onix.comprasamazon.features.products.data.local.LocalProductManager
import com.onix.comprasamazon.features.products.domain.infraestructure.ProductGateway
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductGatewayModule {
    @Binds
    abstract fun bindProductGateway(
        localProductManager: LocalProductManager
    ): ProductGateway
}