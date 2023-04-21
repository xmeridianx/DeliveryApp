package com.example.meatdeliveryapp

interface OnCartChangeListener {
    fun onProductAdded(product: Product)
    fun onProductRemoved(product: Product)
}