package com.example.meatdeliveryapp.data

import com.example.meatdeliveryapp.data.Product

data class Order(
    val orderId: String,
    val products: List<Product>,
    val status: String
)
