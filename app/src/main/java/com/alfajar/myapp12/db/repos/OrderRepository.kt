package com.alfajar.myapp12.db.repos

import androidx.lifecycle.LiveData
import com.alfajar.myapp12.db.dao.OrderDao
import com.alfajar.myapp12.db.entity.OrderData
import com.alfajar.myapp12.db.firebase.FirebaseData
import com.alfajar.myapp12.db.room.AppDB
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderRepository(
    private val dao: OrderDao,
    private val firestore: FirebaseFirestore
) {
    fun getAllOrders(): LiveData<List<OrderData>> = dao.getAllOrders()

    suspend fun

}