package com.example.meatdeliveryapp

import android.content.Context
import com.example.meatdeliveryapp.categories.MyApp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SingletonCart {
    private var productList = mutableListOf<Product>()
    private val gson = Gson()

    fun addProduct(product: Product) {
        val existingProduct = productList.find { it.id == product.id }
        if (existingProduct != null) {
            existingProduct.quantity += product.quantity
        } else {
            productList.add(product)
        }
    }
    /*
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

     */
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



    fun saveProductList(context: Context) {
        val sharedPref = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("product_list", gson.toJson(productList))
            apply()
        }
    }

    fun loadProductList(context: Context) {
        val sharedPref = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val productListJson = sharedPref.getString("product_list", null)
        if (productListJson != null) {
            val productListType = object : TypeToken<MutableList<Product>>() {}.type
            productList = Gson().fromJson(productListJson, productListType)
        }
    }
}
