package com.alfajar.myapp12

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfajar.myapp12.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : OrderAdapter
    private lateinit var viewModel: OrderViewModel
    private var currentFilter = OrderViewModel.FilterType.ITEM_NAME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[OrderViewModel::class.java]

        adapter = OrderAdapter(emptyList())


        binding.orderList.layoutManager = LinearLayoutManager(this)
        binding.orderList.adapter = adapter

        viewModel.filteredOrders.observe(this) {
            adapter.updateList(it)
        }

        binding.searchBar.setOnClickListener {
            if (currentFilter == OrderViewModel.FilterType.DATE) {
                showDatePicker()
            }
        }

        binding.searchBar.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.filterOrders(s.toString(), currentFilter)
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        binding.filterTypeButton.setOnClickListener{
            currentFilter = when (currentFilter) {
                OrderViewModel.FilterType.ITEM_NAME -> OrderViewModel.FilterType.SENDER
                OrderViewModel.FilterType.SENDER -> OrderViewModel.FilterType.DESTINATION
                OrderViewModel.FilterType.DESTINATION -> OrderViewModel.FilterType.DATE
                OrderViewModel.FilterType.DATE -> OrderViewModel.FilterType.ITEM_NAME
            }
            binding.filterTypeButton.text = "Filter: ${currentFilter.name.replace("_","")}"
            if (currentFilter == OrderViewModel.FilterType.DATE) {
                binding.searchBar.inputType = InputType.TYPE_NULL
                binding.searchBar.hint = "Select Date"
            } else {
                binding.searchBar.inputType = InputType.TYPE_CLASS_TEXT
                binding.searchBar.hint = "Search..."
            }
        }
    }

    @SuppressLint("DefaultLocale")
    private fun showDatePicker() {
        val calender = Calendar.getInstance()
        DatePickerDialog(this, { _, year,month,day ->
            val date = String.format("%04d-%02d-%02d", year, month + 1, day)
            binding.searchBar.setText(date)
            viewModel.filterOrders(date, OrderViewModel.FilterType.DATE)
        }, calender.get(Calendar.YEAR),calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH)).show()
    }
}
