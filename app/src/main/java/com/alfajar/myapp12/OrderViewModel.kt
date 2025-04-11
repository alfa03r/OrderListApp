package com.alfajar.myapp12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alfajar.myapp12.model.Order

class OrderViewModel : ViewModel() {
    private val allOrders = mutableListOf(
        Order("Laptop", "Andi", "Jakarta", "2025-04-05"),
        Order("Buku", "Budi", "Bandung", "2025-04-07"),
        Order("Printer", "Cici", "Surabaya", "2025-04-03"),
        Order("Kamera", "Dedi", "Yogyakarta", "2025-04-07")
    )

    private val _filteredOrders = MutableLiveData<List<Order>>(allOrders)
    val filteredOrders: LiveData<List<Order>> = _filteredOrders

    fun filterOrders(query: String, filterType: FilterType) {
        _filteredOrders.value = if (query.isBlank()) {
            allOrders
        } else {
            allOrders.filter {
                when (filterType) {
                    FilterType.ITEM_NAME -> it.itemName.contains(query, ignoreCase = true)
                    FilterType.SENDER -> it.sender.contains(query, ignoreCase = true)
                    FilterType.DESTINATION -> it.destination.contains(query, ignoreCase = true)
                    FilterType.DATE -> it.deliveryDate == query
                }
            }
        }
    }

    enum class FilterType {
        ITEM_NAME, SENDER, DESTINATION, DATE
    }
}