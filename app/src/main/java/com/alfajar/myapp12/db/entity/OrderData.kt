package com.alfajar.myapp12.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderData(
    @PrimaryKey val id: String,
    val itemName: String,
    val sender: String,
    val destination: String,
    val date: String
)
