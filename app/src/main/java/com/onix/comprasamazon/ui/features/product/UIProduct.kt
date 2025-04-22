package com.onix.comprasamazon.ui.features.product

import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct

class UIProduct(
    override var id: Long=0,
    override var name : String="",
    override var shippingValue: Double =0.0,
    override var productValue: Double =0.0,
    override var finalValue: Double =0.0,
    override var buyer: Long=0L
): BaseProduct(id,name,shippingValue,productValue,finalValue,buyer) {

    companion object {
        fun baseToUI(product : BaseProduct): UIProduct {
            return UIProduct(product.id,product.name,product.shippingValue, product.productValue, product.finalValue, product.buyer)
        }
    }

    fun copy(product : UIProduct?){
        if(product!=null){
            name=product.name
            shippingValue=product.shippingValue
            finalValue=product.finalValue
            buyer=product.buyer
        }
    }

}