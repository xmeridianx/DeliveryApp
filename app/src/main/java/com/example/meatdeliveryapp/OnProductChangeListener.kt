package com.example.meatdeliveryapp

interface OnProductChangeListener {
    fun onProductAdded(product: Product)
    fun onProductRemoved(product: Product)

}