package com.example.meatdeliveryapp.categoryList.repository

import com.example.meatdeliveryapp.categoryList.viewmodel.Category
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseCategoriesRepository: CategoriesRepository {

    override suspend fun loadCategories(): List<Category> = withContext(Dispatchers.IO) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("Categories")
        val categoryList = mutableListOf<Category>()

        for (categorySnapshot in databaseReference.get().await().children) {
            val id = categorySnapshot.child("id").getValue(Int::class.java)
            val name = categorySnapshot.child("name").getValue(String::class.java)
            val imageUrl = categorySnapshot.child("imageUrl").getValue(String::class.java)

            if (name != null && id != null && imageUrl != null) {
                val category = Category(id, name, imageUrl)
                categoryList.add(category)
            }
        }

        return@withContext categoryList
    }
}
