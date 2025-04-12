package com.alfajar.myapp12.db.firebase

import android.util.Log
import com.alfajar.myapp12.db.entity.OrderData
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class FirebaseData {
    private val firestore = FirebaseFirestore.getInstance()


    fun fetchData(callback: (List<OrderData>) -> Unit) {

    }
}