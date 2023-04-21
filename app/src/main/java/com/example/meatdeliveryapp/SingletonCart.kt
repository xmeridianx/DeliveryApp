package com.example.meatdeliveryapp

import android.content.Context
import com.example.meatdeliveryapp.categories.MyApp

object SingletonCart {


    var productList: MutableList<Product> = mutableListOf()

    @JvmName("getProductList1")
    fun getProductList(): List<Product> {
        return productList
    }

    fun addProduct(product: Product) {
        val existingProduct = productList.find { it.id == product.id }
        if (existingProduct != null) {
            existingProduct.quantity += 1
        } else {
            productList.add(product)
        }
    }

    fun deleteProduct(product: Product) {
        val product = productList.findLast { it.type == product.type }
        if (product != null) {
            if (product.quantity > 1) {
                product.quantity -= 1
            } else {
                productList.remove(product)
            }
        }
    }

    fun getQuantity(type: Int): Int {
        val product = productList.find { it.id == type }
        return product?.quantity ?: 0
    }

    fun clear() {
        productList.clear()
    }
    fun addProducts(products: List<Product>) {
        for (product in products) {
            addProduct(product)
        }
    }
    private const val PREF_NAME = "cart_prefs"
    private const val PREF_PRODUCTS = "cart_products"

    private val sharedPreferences = MyApp.instance?.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    init {

        val serializedProducts = sharedPreferences?.getString(PREF_PRODUCTS, null)
        if (serializedProducts != null) {
            addProducts(Product.fromJsonList(serializedProducts))
        }
    }

    fun saveCartToPrefs() {
        val serializedProducts = Product.toJsonList(productList)
        sharedPreferences?.edit()?.putString(PREF_PRODUCTS, serializedProducts)?.apply()
    }

}
