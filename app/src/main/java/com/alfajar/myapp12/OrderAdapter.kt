package com.alfajar.myapp12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alfajar.myapp12.databinding.ItemOrderBinding
import com.alfajar.myapp12.db.entity.OrderData

class OrderAdapter(private var orderList: List<OrderData>, private val onItemClick: (OrderData)) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(val binding : ItemOrderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orderList[position]
        holder.binding.apply {
            itemName.text = order.itemName
            sender.text = order.sender
            destination.text = order.destination
            deliveryDate.text = order.deliveryDate
        }
    }

    fun updateList(newList: List<OrderData>) {
        orderList = newList
        notifyDataSetChanged()
    }
}