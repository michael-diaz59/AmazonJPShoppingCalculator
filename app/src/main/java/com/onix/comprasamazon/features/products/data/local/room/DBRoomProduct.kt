package com.onix.comprasamazon.features.products.data.local.room

import android.content.Context
import androidx.room.Room
import com.onix.comprasamazon.core.data.local.room.RoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBRoomProduct {

    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context): RoomDB =
        Room.databaseBuilder(
            context.applicationContext,
            RoomDB::class.java,
            "compras-db"
        ).build()


    @Singleton
    @Provides
    fun getDAOProduct(roomDB: RoomDB): DAOProduct = roomDB.dAOProduct()

}