package com.alfajar.myapp12.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alfajar.myapp12.db.model.Order
import java.io.Serializable

@Entity(tableName = "orders")
data class OrderData(
    val itemName: String,
    val sender: String,
    val destination: String,
    val date: String,
    @PrimaryKey val id: String
)
