package com.onix.comprasamazon.features.products.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAOProduct {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: RoomProduct): Long

    @Delete
    suspend fun delete(product: RoomProduct): Int

    @Update
    suspend fun update(product: RoomProduct): Int

    @Query("SELECT * FROM RoomProduct")
    suspend fun getAll(): List<RoomProduct>
}