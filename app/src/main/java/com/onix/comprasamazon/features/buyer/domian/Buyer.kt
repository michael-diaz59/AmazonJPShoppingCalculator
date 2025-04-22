package com.onix.comprasamazon.features.buyer.domian

data class Buyer(
    val id: Int = 0,
    var name: String="",
    val totalToPay:Long= 0L,
)