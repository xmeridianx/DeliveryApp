package com.example.meatdeliveryapp.productList.viewmodel

data class Product (
    var id: Int ,
    var name: String ,
    var price: Double ,
    var imageUrl: String ,
    var quantity: Int = 0,
)
