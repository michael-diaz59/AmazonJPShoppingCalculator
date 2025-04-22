package com.onix.comprasamazon.core.di.modules

import LocalAmazonManager
import com.onix.comprasamazon.features.amazon.domain.infraestructure.AmazonGateway
import dagger.Binds

abstract class AmazonGatewayModule {
    @Binds
    abstract fun bindProductGateway(
        localAmazonManager: LocalAmazonManager
    ): AmazonGateway
}