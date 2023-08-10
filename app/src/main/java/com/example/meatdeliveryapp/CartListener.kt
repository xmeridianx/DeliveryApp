package com.example.meatdeliveryapp

import com.example.meatdeliveryapp.data.Product

interface CartListener {
    fun onProductAdded(product: Product)
    fun onProductRemoved(product: Product)
    fun onCartCleared()
}