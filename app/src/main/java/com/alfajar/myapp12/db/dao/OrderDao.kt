package com.alfajar.myapp12.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alfajar.myapp12.db.entity.OrderData

@Dao
interface OrderDao {
    @Query("SELECT * FROM orders")
    fun getAllOrders(): LiveData<List<OrderData>>

    @Query("DELETE FROM orders ")
    suspend fun clearOrders()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(order: List<OrderData>)
}