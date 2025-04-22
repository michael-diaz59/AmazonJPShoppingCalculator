package com.onix.comprasamazon.core.di.modules

import com.onix.comprasamazon.features.amazon.data.local.LocalAmazonManager
import com.onix.comprasamazon.features.amazon.domain.infraestructure.AmazonGateway
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AmazonGatewayModule {
    @Binds
    abstract fun bindAmazonGateway(
        localAmazonManager: LocalAmazonManager
    ): AmazonGateway
}