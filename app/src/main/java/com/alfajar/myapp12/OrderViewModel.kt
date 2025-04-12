package com.alfajar.myapp12

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfajar.myapp12.db.dao.OrderDao
import com.alfajar.myapp12.db.entity.OrderData
import com.alfajar.myapp12.db.firebase.FirebaseData
import com.alfajar.myapp12.db.repos.OrderRepository
import com.alfajar.myapp12.db.room.AppDB
import kotlinx.coroutines.launch

class OrderViewModel(private val repo: OrderRepository) : ViewModel() {

    private val mOrder = MutableLiveData<List<OrderData>>()
    val orders: LiveData<List<OrderData>> get() = mOrder

    private val mFilter = MutableLiveData<List<OrderData>>()
    val filterData: LiveData<List<OrderData>> get() = mFilter

    private var currentFilter: String = "Item" //Default

    init {
        fetchOrderFromFirebase()
    }

    private fun fetchOrderFromFirebase() {
        viewModelScope.launch {
            val fetchOrders = repo.getAllOrders()
        }
    }
}
