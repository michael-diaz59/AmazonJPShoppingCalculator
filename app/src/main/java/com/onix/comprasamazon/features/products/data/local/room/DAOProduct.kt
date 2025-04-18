package com.onix.comprasamazon.features.products.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAOProduct {
    @Insert
    suspend fun insert(product: RoomProduct): Long

    @Delete
    suspend fun delete(product: RoomProduct): Long

    @Update
    suspend fun update(product: RoomProduct): Long

    @Query("SELECT * FROM RoomProduct")
    suspend fun getAll(): List<RoomProduct>
}