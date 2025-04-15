package com.onix.comprasamazon.features.products.domain

data class Product(
    val id: Int,
    var name: String,
    var isSelected: Boolean = false
)
