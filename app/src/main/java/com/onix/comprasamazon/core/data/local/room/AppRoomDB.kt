package com.onix.comprasamazon.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onix.comprasamazon.features.amazon.data.local.room.DAOAmazon
import com.onix.comprasamazon.features.amazon.data.local.room.RoomAmazon
import com.onix.comprasamazon.features.products.data.local.room.DAOProduct
import com.onix.comprasamazon.features.products.data.local.room.RoomProduct

/**
 * se encarga de montar la base de datos de la app en el cell
 */
@Database(entities = [RoomProduct::class, RoomAmazon::class], version = 1)
abstract class AppRoomDB : RoomDatabase(){
    //aqui se ponen todos los DAO de la aplicacion
    abstract fun dAOProduct(): DAOProduct
    abstract fun dAOAmazon(): DAOAmazon
}