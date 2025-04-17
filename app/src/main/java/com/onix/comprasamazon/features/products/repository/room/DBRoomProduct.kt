package com.onix.comprasamazon.features.products.repository.room

import android.content.Context
import androidx.room.Room
import com.onix.comprasamazon.utilities.repository.room.DBRoom

object DBRoomProduct {
    private var db: DBRoom? = null

    fun getDatabase(context: Context): DBRoom {
        if (db == null) {
            db = Room.databaseBuilder(
                context.applicationContext,
                DBRoom::class.java,
                "compras-db"
            ).build()
        }
        return db!!
    }
}