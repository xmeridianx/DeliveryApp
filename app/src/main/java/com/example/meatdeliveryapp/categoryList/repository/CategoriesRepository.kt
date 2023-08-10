package com.example.meatdeliveryapp.categoryList.repository

import com.example.meatdeliveryapp.categoryList.viewmodel.Category

interface CategoriesRepository {

    suspend fun loadCategories(): List<Category>

}