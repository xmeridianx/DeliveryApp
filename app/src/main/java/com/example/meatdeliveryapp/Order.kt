package com.example.meatdeliveryapp

data class Order(
    val orderId: String,
    val products: List<Product>,
    val status: String
)
