package com.example.meatdeliveryapp.categoryList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meatdeliveryapp.categoryList.repository.CategoriesRepository
import kotlinx.coroutines.launch

class CategoryListViewModel(private val repository: CategoriesRepository) : ViewModel() {
    private val _state: MutableLiveData<CategoryListScreenState> = MutableLiveData()
    val state: LiveData<CategoryListScreenState> = _state

    private val _effect: MutableLiveData<CategoryListEffect> = MutableLiveData<CategoryListEffect>()
    val effect: LiveData<CategoryListEffect> = _effect

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            val categoryList = repository.loadCategories()
            val newState = CategoryListScreenState(categoryList)
            _state.value = newState
        }
    }
}