package com.onix.comprasamazon.features.amazon.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAOAmazon {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAmazon(amazon: RoomAmazon)

    @Update
    suspend fun update(amazon: RoomAmazon): Int

    @Query("SELECT * FROM RoomAmazon LIMIT 1")
    suspend fun getAll(): RoomAmazon
}