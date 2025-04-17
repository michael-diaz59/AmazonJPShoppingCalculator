package com.onix.comprasamazon.utilities.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onix.comprasamazon.features.products.repository.room.DAOProduct
import com.onix.comprasamazon.features.products.repository.room.RoomProduct

/**
 * se encarga de montar la base de datos de la app en el cell
 */
@Database(entities = [RoomProduct::class], version = 1)
abstract class DBRoom : RoomDatabase(){
    //aqui se ponen todos los DAO de la aplicacion
    abstract fun dAOProduct(): DAOProduct
}