package com.onix.comprasamazon.features.products.data.local.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.onix.comprasamazon.core.data.local.room.AppRoomDB
import com.onix.comprasamazon.features.amazon.data.local.room.DAOAmazon
import com.onix.comprasamazon.features.amazon.data.local.room.RoomAmazon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBRoomProduct {

    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context): AppRoomDB =
        Room.databaseBuilder(
            context.applicationContext,
            AppRoomDB::class.java,
            "compras-db"
        ).addCallback(callback =object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    val amazonDAO = getDatabase(context).dAOAmazon()
                    amazonDAO.insertAmazon(
                        RoomAmazon(amazonToPay = 0.0, amazonRealToPay = 0.0)
                    )
                }
            }
        }).build()


    @Singleton
    @Provides
    fun getDAOProduct(appRoomDB: AppRoomDB): DAOProduct = appRoomDB.dAOProduct()

    @Singleton
    @Provides
    fun getDAOAmazon(appRoomDB: AppRoomDB): DAOAmazon = appRoomDB.dAOAmazon()

}