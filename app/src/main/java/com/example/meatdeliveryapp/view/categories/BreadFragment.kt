package com.example.meatdeliveryapp.view.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meatdeliveryapp.data.Product
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentBreadBinding
import com.example.meatdeliveryapp.recyclerProduct.AdapterProduct
import com.example.meatdeliveryapp.recyclerProduct.OnProductClickListener
import com.google.firebase.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class BreadFragment() : Fragment(), OnProductClickListener {
    //private val productRepositoryImpl = ProductRepositoryImpl(FirebaseDatabase.getInstance())
    private lateinit var binding: FragmentBreadBinding
    private val adapters = Array(3) { AdapterProduct(mutableListOf(), this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreadBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBread.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        SingletonCart.loadProductList(requireContext())

            /*
        lifecycleScope.launch {
            val productList = withContext(Dispatchers.IO) {
                productRepositoryImpl.loadProducts("Bread_products", "Bread")
            }
            adapters[0] = AdapterProduct(productList, this@BreadFragment)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            binding.recycler.adapter = adapters[0]
            binding.recycler.layoutManager = layoutManager
        }
        lifecycleScope.launch {
            val productList2 = withContext(Dispatchers.IO) {
                productRepositoryImpl.loadProducts("Bread_products", "Bakery")
            }
            adapters[1] = AdapterProduct(productList2, this@BreadFragment)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            binding.recycler2.adapter = adapters[1]
            binding.recycler2.layoutManager = layoutManager
        }
        lifecycleScope.launch {
            val productList3 = withContext(Dispatchers.IO) {
                productRepositoryImpl.loadProducts("Bread_products", "Crackers")
            }
            adapters[2] = AdapterProduct(productList3, this@BreadFragment)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            binding.recycler3.adapter = adapters[2]
            binding.recycler3.layoutManager = layoutManager
        }

             */
    }
    override fun onPause() {
        super.onPause()
        SingletonCart.saveProductList(requireContext())

    }

    override fun onResume() {
        SingletonCart.loadProductList(requireContext())
        super.onResume()
    }

    companion object {
        @JvmStatic
        fun newInstance() = BreadFragment()
    }

    override fun onAddProduct(product: Product) {
        SingletonCart.addProduct(
            Product(
                quantity = 1,
                name = product.name,
                id = product.id,
                price = product.price,
                imageUrl = product.imageUrl
            )
        )
        Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteProduct(product: Product) {
        SingletonCart.deleteProduct(product)
        Toast.makeText(activity, "Удалено из корзины", Toast.LENGTH_SHORT).show()
    }
}