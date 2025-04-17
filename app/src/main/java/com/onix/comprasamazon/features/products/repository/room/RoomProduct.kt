package com.onix.comprasamazon.features.products.repository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct

@Entity
data class RoomProduct(
    @PrimaryKey(autoGenerate = true) override var id: Int=0,
    @ColumnInfo(name = "name")override var name : String,
    @ColumnInfo(name = "shippingValue")override var shippingValue: Double =0.0,
    @ColumnInfo(name = "productValue")override var productValue: Double =0.0,
    @ColumnInfo(name = "finalValue")override var finalValue: Double =0.0,
    @ColumnInfo(name = "buyer")override var buyer: Int
) : BaseProduct(id,name,shippingValue,productValue,finalValue,buyer) {



}