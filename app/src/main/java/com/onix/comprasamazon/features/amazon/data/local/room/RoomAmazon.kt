package com.onix.comprasamazon.features.amazon.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon

@Entity
class RoomAmazon(
    @PrimaryKey(autoGenerate = true) override var id: Long=0,
    @ColumnInfo(name = "buyer") override var amazonToPay: Double,
    @ColumnInfo(name = "amazonRealToPay") override var amazonRealToPay: Double
): BaseAmazon() {
    companion object{
        fun baseToRoom(amazon: BaseAmazon):RoomAmazon{
            return RoomAmazon(amazonToPay = amazon.amazonToPay, amazonRealToPay = amazon.amazonRealToPay)
        }

    }
}