package com.alfajar.myapp12.db.room

import androidx.room.Database
import com.alfajar.myapp12.db.dao.OrderDao
import com.alfajar.myapp12.model.Order

@Database(entities = [Order::class], version = 1)
abstract class AppDB {
    abstract fun orderDao(): OrderDao
}