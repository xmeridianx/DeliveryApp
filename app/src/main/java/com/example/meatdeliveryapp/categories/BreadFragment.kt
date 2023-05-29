package com.example.meatdeliveryapp.categories

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentBreadBinding
import com.example.meatdeliveryapp.recyclerProduct.AdapterProduct
import com.example.meatdeliveryapp.recyclerProduct.OnProductClickListener
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import java.util.concurrent.ExecutionException


class BreadFragment : Fragment(), OnProductClickListener {

    private lateinit var binding: FragmentBreadBinding
    private lateinit var adapters: Array<AdapterProduct>
    private lateinit var productRefs: Array<DatabaseReference>
    private lateinit var thread: Array<Thread>
    private lateinit var database: FirebaseDatabase
    private val handler = Handler()
    private lateinit var categoryRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreadBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = FirebaseDatabase.getInstance()
        categoryRef = database.getReference("Categories")

        binding.toolbarBread.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        SingletonCart.loadProductList(requireContext())
        adapters = Array(3) { AdapterProduct(mutableListOf(), this) }
        productRefs = arrayOf(
            categoryRef.child("Bread_products").child("Bread"),
            categoryRef.child("Bread_products").child("Bakery") ,
            categoryRef.child("Bread_products").child("Crackers"))

        thread = Array(3) { Thread() }

        //val categoryNames = arrayOf("Bread_products", "Bakery_products", "Crackers_products")

        thread[0] = Thread {
            val productList = loadData(productRefs[0])
            adapters[0] = AdapterProduct(productList, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            handler.post {
                binding.recyclerBread.adapter = adapters[0]
                binding.recyclerBread.layoutManager = layoutManager

            }
        }
        thread[0].start()

        thread[1] = Thread {
            val productList2 = loadData(productRefs[1])
            adapters[1] = AdapterProduct(productList2, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            handler.post {
                binding.recyclerBread2.adapter = adapters[1]
                binding.recyclerBread2.layoutManager = layoutManager

            }
        }
        thread[1].start()


        thread[2] = Thread {
            val productList3 = loadData(productRefs[2])

            adapters[2] = AdapterProduct(productList3, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            handler.post {
                binding.recyclerBread3.adapter = adapters[2]
                binding.recyclerBread3.layoutManager = layoutManager

            }
        }
        thread[2].start()
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

    override fun onDestroy() {
        super.onDestroy()
        thread[0].interrupt()
        thread[1].interrupt()
        thread[2].interrupt()
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