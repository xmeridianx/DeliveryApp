package com.example.meatdeliveryapp.categoryList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.databinding.ItemCategoryBinding
import com.example.meatdeliveryapp.categoryList.viewmodel.Category

class CategoryAdapter(private var categoryList: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setImageForProduct(imageUrl: String) {
            Glide.with(binding.categoryImage.context)
                .load(imageUrl)
                .placeholder(R.drawable.bakaleya)
                .error(R.drawable.ic_baseline_error_24)
                .into(binding.categoryImage)
        }

        fun bind(category: Category) {
            binding.categoryName.text = category.name
            setImageForProduct(category.imageUrl)

            //в отдельный метод, mapTobackground
            val backgroundDrawableId = when(category.name){
                "Детские товары" -> R.drawable.gradient_baby
                "Хлеб" -> R.drawable.gradient_bread
                "Консервы" -> R.drawable.gradient_canned
                "Для дома" -> R.drawable.gradient_hygiene
                "Кофе, чай" -> R.drawable.gradient_coffee
                "Напитки" -> R.drawable.gradient_drinks
                "Рыба" -> R.drawable.gradient_fish
                "Заморозка" -> R.drawable.gradient_frozen
                "Крупы, макароны" -> R.drawable.gradient_grocery
                "Мясные продукты" -> R.drawable.gradient_meat
                "Аптечка" -> R.drawable.gradient_medicine
                "Молоко, яйца" -> R.drawable.gradient_milk
                "Масло, специи" -> R.drawable.gradient_oil
                "Снэки" -> R.drawable.gradient_snacks
                "Сладости" -> R.drawable.gradient_sweet
                "Овощи и фрукты" -> R.drawable.gradient_vegetables
                else -> R.drawable.gradient_home
            }

            binding.categoryView.setBackgroundResource(backgroundDrawableId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]

       holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun updateCategories(newCategories: List<Category>) {
        categoryList = newCategories.toMutableList()
        notifyDataSetChanged() // Сообщите RecyclerView, что данные изменились
    }

}