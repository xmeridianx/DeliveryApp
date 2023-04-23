package com.example.meatdeliveryapp

import android.content.Context
import com.example.meatdeliveryapp.categories.MyApp
import com.google.gson.Gson

object SingletonCart {
    private var productList = mutableListOf<Product>()
    val gson = Gson()

    fun addProduct(product: Product) {
        val existingProduct = productList.find { it.id == product.id }
        if (existingProduct != null) {
            existingProduct.quantity += product.quantity
        } else {
            productList.add(product)
        }
    }

    fun deleteProduct(product: Product) {
        val productToDelete = productList.findLast { it.id == product.id }
        if (productToDelete != null) {
            if (productToDelete.quantity > 1) {
                productToDelete.quantity -= 1
            } else {
                productList.remove(productToDelete)
            }
        }
    }

    fun increaseQuantity(id: Int) {
        val existingProduct = productList.find { it.id == id }
        if (existingProduct != null) {
            existingProduct.quantity += 1

        }
    }


    fun getQuantity(id: Int): Int {
        val product = productList.find { it.id == id }
        return product?.quantity ?: 0
    }

    fun clear() {
        productList.clear()
    }

    @JvmName("getProductList1")
    fun getProductList(): MutableList<Product> {
        return productList

    }

}
/*
    fun saveData(context: Context) {
        val jsonString = gson.toJson(productList)
        val file = File(context.filesDir, "product_list.json")
        file.writeText(jsonString)
    }
    fun loadData(context: Context) {
        val file = File(context.filesDir, "product_list.json")
        if (file.exists()) {
            val jsonString = file.readText()
            val listType = object : TypeToken<List<Product>>() {}.type
            productList = gson.fromJson(jsonString, listType)
        }
    }

      */