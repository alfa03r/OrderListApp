package com.alfajar.myapp12.model

data class Order (
    val itemName: String,
    val sender: String,
    val destination: String,
    val deliveryDate: String // Format: "yyyy-MM-dd"
)