package com.example.meatdeliveryapp.recyclerProduct

import com.example.meatdeliveryapp.Product

interface OnProductClickListener {
    fun onAddProduct(product: Product)
    fun onDeleteProduct(product: Product)
}