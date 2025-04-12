package com.alfajar.myapp12.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alfajar.myapp12.db.dao.OrderDao
import com.alfajar.myapp12.db.entity.OrderData

@Database(entities = [OrderData::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun orderDao(): OrderDao

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getDatabase(context: Context): AppDB {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "order_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}

