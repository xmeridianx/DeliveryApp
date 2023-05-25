package com.example.meatdeliveryapp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Product(
    var id: Int = 101,
    var name: String = "",
    var price: Double = 0.0,
    var imageUrl: String = "",
    var quantity: Int = 0,

) {

    companion object {
        fun fromJson(json: String): Product = Gson().fromJson(json, Product::class.java)

        fun toJson(product: Product): String = Gson().toJson(product)

        fun toJsonList(productList: List<Product>): String = Gson().toJson(productList)

        fun fromJsonList(json: String): List<Product> =
            Gson().fromJson(json, object : TypeToken<List<Product>>() {}.type)
    }
}

