package com.alfajar.myapp12.db.repos

import androidx.lifecycle.LiveData
import com.alfajar.myapp12.db.entity.OrderData
import com.alfajar.myapp12.db.room.AppDB
import com.alfajar.myapp12.model.Order
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderRepository(private val db: AppDB) {
    fun getAllOrders(): LiveData<List<OrderData>> = db.orderDao().getAllOrders()

    suspend fun syncWithFirebase() {
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("orders")
            .get()
            .addOnSuccessListener { result ->
                val orders = result.map { doc ->
                    OrderData(
                        id = doc.id,
                        itemName = doc.getString("itemName") ?: "",
                        sender = doc.getString("sender") ?: "",
                        destination = doc.getString("destination") ?: "",
                        date = doc.getString("date") ?: ""
                    )
                }
                CoroutineScope(Dispatchers.IO).launch {
                    db.orderDao().insertOrders(orders)
                }
            }
    }
}