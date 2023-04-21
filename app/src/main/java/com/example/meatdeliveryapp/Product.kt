package com.example.meatdeliveryapp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Product(
    var id: Int = 0,
    var type: Int = 0,
    var name: String = "",
    var price: Double = 0.0,
    var imageUrl: String = "",
    var quantity: Int = 1
) {
    companion object {
        fun fromJson(json: String): Product {
            return Gson().fromJson(json, Product::class.java)
        }

        fun toJsonList(products: List<Product>): String {
            return Gson().toJson(products)
        }

        fun fromJsonList(json: String): List<Product> {
            val type = object : TypeToken<List<Product>>() {}.type
            return Gson().fromJson(json, type)
        }
    }
}