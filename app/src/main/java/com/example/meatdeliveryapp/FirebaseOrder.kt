package com.example.meatdeliveryapp

import com.example.meatdeliveryapp.data.Product

data class FirebaseOrder(
val totalPrice: Double,
val productList: List<Product>
)
