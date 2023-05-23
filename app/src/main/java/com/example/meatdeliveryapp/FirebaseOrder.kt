package com.example.meatdeliveryapp

data class FirebaseOrder(
val totalPrice: Double,
val productList: List<Product>
)
