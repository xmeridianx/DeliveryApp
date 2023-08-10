package com.example.meatdeliveryapp

import com.example.meatdeliveryapp.data.Product

interface OnProductChangeListener {
    fun onProductAdded(product: Product)
    fun onProductRemoved(product: Product)

}