package com.example.meatdeliveryapp.productList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meatdeliveryapp.productList.repository.ProductListRepository
import kotlinx.coroutines.launch

class ProductListViewModel (private val repository: ProductListRepository): ViewModel(){
    private val _state: MutableLiveData<ProductListScreenState> = MutableLiveData()
    val state: LiveData<ProductListScreenState> = _state

    init {
        loadProductList()
    }

    private fun loadProductList() {
        viewModelScope.launch {
            val productList = repository.loadProductList()
            val newState = ProductListScreenState(productList)
            _state.value = newState
        }
    }
}