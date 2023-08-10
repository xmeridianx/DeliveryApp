package com.example.meatdeliveryapp.categoryList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.meatdeliveryapp.categoryList.repository.FirebaseCategoriesRepository
import com.example.meatdeliveryapp.databinding.FragmentHomeTestBinding
import com.example.meatdeliveryapp.categoryList.viewmodel.CategoryListViewModel


class CategoryListFragment : Fragment() {
    private lateinit var binding: FragmentHomeTestBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var viewModel: CategoryListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeTestBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = FirebaseCategoriesRepository() // Создайте экземпляр репозитория
        viewModel = CategoryListViewModel(repository)
        categoryAdapter = CategoryAdapter(emptyList()) // Передайте начальный пустой список

        binding.categoryRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = categoryAdapter
        }

        viewModel.state.observe(viewLifecycleOwner) { state ->
            categoryAdapter.updateCategories(state.categories)
        }
    }
}