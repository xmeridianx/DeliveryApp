package com.example.meatdeliveryapp

interface CartListener {
    fun onProductAdded(product: Product)
    fun onProductRemoved(product: Product)
    fun onCartCleared()
}