package com.onix.comprasamazon.features.products.domain.business.entitites


abstract class BaseProduct(
    open var id: Long,
    open var name: String,
    open var shippingValue: Double,
    open var productValue: Double,
    open var finalValue: Double,
    open var buyer: Long
){
    fun copy(product:BaseProduct){
        id=product.id
        name=product.name
        shippingValue=product.shippingValue
        productValue=product.productValue
        finalValue=product.finalValue
    }

    override fun toString(): String {
        return "id: $id, name: $name, shippingValue: $shippingValue, productValue: $productValue, finalValue: $finalValue"
    }
}
