package com.example.meatdeliveryapp.view.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meatdeliveryapp.data.Product
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentDrinksBinding
import com.example.meatdeliveryapp.recyclerProduct.AdapterProduct
import com.example.meatdeliveryapp.recyclerProduct.OnProductClickListener
import com.google.android.gms.tasks.Tasks
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutionException

class DrinksFragment : Fragment(), OnProductClickListener {
    private lateinit var binding: FragmentDrinksBinding
    private lateinit var adapters: Array<AdapterProduct>
    private lateinit var productRefs: Array<DatabaseReference>
    private lateinit var database: FirebaseDatabase
    private lateinit var categoryRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinksBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = FirebaseDatabase.getInstance()
        categoryRef = database.getReference("Categories")

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        SingletonCart.loadProductList(requireContext())

        adapters = Array(3) { AdapterProduct(mutableListOf(), this) }
        productRefs = arrayOf(
            categoryRef.child("Drinks").child("water"),
            categoryRef.child("Drinks").child("juices") ,
            categoryRef.child("Drinks").child("lemonade"))
        //
        lifecycleScope.launch {
            val productList = withContext(Dispatchers.IO){
                loadData(productRefs[0])
            }
            adapters[0] = AdapterProduct(productList, this@DrinksFragment)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
                binding.recycler.adapter = adapters[0]
                binding.recycler.layoutManager = layoutManager
        }
        lifecycleScope.launch {
            val productList2 = withContext(Dispatchers.IO){
                loadData(productRefs[1])
            }
            adapters[1] = AdapterProduct(productList2, this@DrinksFragment)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
                binding.recycler2.adapter = adapters[1]
                binding.recycler2.layoutManager = layoutManager
        }
        lifecycleScope.launch {
            val productList3 = withContext(Dispatchers.IO){
                loadData(productRefs[2])
            }
            adapters[2] = AdapterProduct(productList3, this@DrinksFragment)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
                binding.recycler3.adapter = adapters[2]
                binding.recycler3.layoutManager = layoutManager
        }
    }

    private fun loadData(productRefs: DatabaseReference): MutableList<Product> {
        val productList = mutableListOf<Product>()

        try {
            val products = Tasks.await(productRefs.get())
            val p = ArrayList<Product>(products.getValue<Map<String, Product>>()!!.values)

            productList.addAll(p)
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return productList
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