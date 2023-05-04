package com.example.meatdeliveryapp

import android.annotation.SuppressLint
import android.content.Context
import com.example.meatdeliveryapp.categories.MyApp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object SingletonCart {
    private var productListType = object : TypeToken<MutableList<Product>>() {}.type
    private var productList = mutableListOf<Product>()
    private val gson = Gson()
//addProduct(product: Product) - добавляет продукт в список продуктов в корзине.
// Если продукт с таким же идентификатором уже существует в корзине, увеличивает количество этого продукта на количество добавляемого продукта.
// В противном случае добавляет новый продукт в список.
    fun addProduct(product: Product) {
        val existingProduct = productList.find { it.id == product.id }
        if (existingProduct == null) {
            productList.add(product)
        } else {
            existingProduct.quantity ++
        }
    }
//deleteProduct(product: Product) - удаляет один экземпляр продукта из корзины.
// Если удаляемый продукт имеет количество больше одного, уменьшает количество продукта на один.
// Если количество продукта после уменьшения становится равным нулю, удаляет продукт из списка.
@SuppressLint("NotifyDataSetChanged")
fun deleteProduct(product: Product) {
    val productToDelete = productList.find { it.id == product.id }
    if (productToDelete != null ) {
        productToDelete.quantity--
        if (productToDelete.quantity == 0) {
            productList.remove(productToDelete)
        }
    }
}
//getQuantity(id: Int): Int - возвращает количество продукта с заданным идентификатором в корзине.
// Если продукта с таким идентификатором нет в корзине, возвращает ноль.
        fun getQuantity(id: Int): Int {
            if (productList.isEmpty()) {
                return 0
            }
            val product = productList?.find { it.id == id }
            return product?.quantity ?: 0
        }

    fun clear() {
        productList.clear()
    }

    //getProductList(): MutableList<Product> - возвращает список продуктов в корзине.
    @JvmName("getProductList1")
    fun getProductList(): MutableList<Product> {
        return productList

    }


//saveProductList(context: Context) - сохраняет список продуктов в корзине в файл настроек приложения в формате JSON.
    fun saveProductList(context: Context) {
        val sharedPref = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("product_list", gson.toJson(productList))
            apply()
        }
    }

    //loadProductList(context: Context) - загружает список продуктов из файла настроек приложения в формате JSON.
    // Если файл настроек не содержит списка продуктов, ничего не происходит.
    fun loadProductList(context: Context) {
        val sharedPref = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val productListJson = sharedPref.getString("product_list", null)
        if (productListJson != null) {
            productList = Gson().fromJson(productListJson, productListType)
        }
    }
}
