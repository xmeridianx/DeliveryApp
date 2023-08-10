package com.example.meatdeliveryapp.categoryList.viewmodel

sealed class CategoryListEffect {
    class ShowCategory(categoryId: Int): CategoryListEffect()

}