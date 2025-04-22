package com.onix.comprasamazon.features.amazon.domain.business.entities

abstract class BaseAmazon {
    open var id: Long = 0L
    open var amazonToPay:Double = 0.0
    open var amazonRealToPay:Double = 0.0

    override fun toString(): String {
        return "id: $id, amazonToPay: $amazonToPay, amazonRealToPay: $amazonRealToPay"
    }


}