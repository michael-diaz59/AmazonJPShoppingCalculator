package com.onix.comprasamazon.features.products.domain.business.entitites

import com.onix.comprasamazon.features.buyer.domian.Buyer

abstract class BaseProduct(
    open var id: Int,
    open var name: String,
    open var shippingValue: Double,
    open var productValue: Double,
    open var finalValue: Double,
    open var buyer: Int
)
