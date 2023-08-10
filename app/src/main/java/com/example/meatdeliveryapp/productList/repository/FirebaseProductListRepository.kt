package com.example.meatdeliveryapp.productList.repository

import com.example.meatdeliveryapp.categoryList.viewmodel.Category
import com.example.meatdeliveryapp.data.Product
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseProductListRepository: ProductListRepository {

    override suspend fun loadProductList(): List<Product> = withContext(Dispatchers.IO) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("Categories")
        val productList = mutableListOf<Product>()

        for (categorySnapshot in databaseReference.get().await().children) {
            val id = categorySnapshot.child("id").getValue(Int::class.java)
            val name = categorySnapshot.child("name").getValue(String::class.java)
            val price = categorySnapshot.child("imageUrl").getValue(String::class.java)
            val imageUrl = categorySnapshot.child("imageUrl").getValue(String::class.java)
            val quantity = 1



            if (name != null && id != null && imageUrl != null) {
                val product = Product(id, name, price, imageUrl, quantity)
                productList.add(product)
            }
        }

        return@withContext productList

    }
}