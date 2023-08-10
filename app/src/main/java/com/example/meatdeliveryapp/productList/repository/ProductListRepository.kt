package com.example.meatdeliveryapp.productList.repository

import com.example.meatdeliveryapp.data.Product

interface ProductListRepository {
    suspend fun loadProductList(): List<Product>
    //fun loadProductList(category: String, subCategory: String): List<Product>
}