package com.example.meatdeliveryapp.categories

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentBreadBinding
import com.example.meatdeliveryapp.databinding.FragmentVegetablesBinding
import com.example.meatdeliveryapp.recyclerProduct.AdapterProduct
import com.example.meatdeliveryapp.recyclerProduct.OnProductClickListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue


class VegetablesAndFruitsFragment : Fragment(), OnProductClickListener {
    private lateinit var binding: FragmentVegetablesBinding
    private lateinit var adapter: AdapterProduct
    private lateinit var adapter2: AdapterProduct
    private lateinit var adapter3: AdapterProduct
    private lateinit var adapter4: AdapterProduct
    private lateinit var productRefs: Array<DatabaseReference>
    private lateinit var productRefs2: Array<DatabaseReference>
    private lateinit var productRefs3: Array<DatabaseReference>
    private lateinit var productRefs4: Array<DatabaseReference>
    private lateinit var thread: Thread



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVegetablesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val categoryRef = database.getReference("Categories")
        val handler = Handler()

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        SingletonCart.loadProductList(requireContext())
        //val imageRef = storageRef.child("images/banani.jpg")

        productRefs = arrayOf(
            categoryRef.child("Овощи и фрукты").child("products").child("product201"),
            categoryRef.child("Овощи и фрукты").child("products").child("product202"),
            categoryRef.child("Овощи и фрукты").child("products").child("product203"),
            categoryRef.child("Овощи и фрукты").child("products").child("product204"),
            categoryRef.child("Овощи и фрукты").child("products").child("product205"),
            categoryRef.child("Овощи и фрукты").child("products").child("product206"),
            categoryRef.child("Овощи и фрукты").child("products").child("product207"),
            categoryRef.child("Овощи и фрукты").child("products").child("product208"),
            categoryRef.child("Овощи и фрукты").child("products").child("product209"),
        )
        thread = Thread {
            val productList = loadData()

            adapter = AdapterProduct(productList, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            handler.post {
                binding.recycler.adapter = adapter
                binding.recycler.layoutManager = layoutManager

            }
        }
        thread.start()



        productRefs2 = arrayOf(
            categoryRef.child("Овощи и фрукты").child("products").child("product210"),
            categoryRef.child("Овощи и фрукты").child("products").child("product211"),
            categoryRef.child("Овощи и фрукты").child("products").child("product212"),
            categoryRef.child("Овощи и фрукты").child("products").child("product213"),
            categoryRef.child("Овощи и фрукты").child("products").child("product214"),
            categoryRef.child("Овощи и фрукты").child("products").child("product215"),

        )
        val productList2 = mutableListOf<Product>()
        adapter2 = AdapterProduct(productList2, this)
        val layoutManager2 = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )

        binding.recycler2.adapter = adapter2
        binding.recycler2.layoutManager = layoutManager2

        productRefs2[0].get().addOnSuccessListener { dataSnapshot ->
            val product301 = dataSnapshot.getValue<Product>()
            productList2.add(product301!!)
            adapter2.notifyDataSetChanged()
        }
        productRefs2[1].get().addOnSuccessListener { dataSnapshot ->
            val product211 = dataSnapshot.getValue<Product>()
            productList2.add(product211!!)
            //val productImage = "${product101?.image}"
            adapter2.notifyDataSetChanged()
        }
        productRefs2[2].get().addOnSuccessListener { dataSnapshot ->
            val product212 = dataSnapshot.getValue<Product>()
            productList2.add(product212!!)
            //val productImage = "${product101?.image}"
            adapter2.notifyDataSetChanged()
        }
        productRefs2[3].get().addOnSuccessListener { dataSnapshot ->
            val product213 = dataSnapshot.getValue<Product>()
            productList2.add(product213!!)
            //val productImage = "${product101?.image}"
            adapter2.notifyDataSetChanged()
        }
        productRefs2[4].get().addOnSuccessListener { dataSnapshot ->
            val product214 = dataSnapshot.getValue<Product>()
            productList2.add(product214!!)
            //val productImage = "${product101?.image}"
            adapter2.notifyDataSetChanged()
        }
        productRefs2[5].get().addOnSuccessListener { dataSnapshot ->
            val product215 = dataSnapshot.getValue<Product>()
            productList2.add(product215!!)
            //val productImage = "${product101?.image}"
            adapter2.notifyDataSetChanged()
        }


        productRefs3 = arrayOf(
            categoryRef.child("Овощи и фрукты").child("products").child("product220"),
            categoryRef.child("Овощи и фрукты").child("products").child("product221"),
            categoryRef.child("Овощи и фрукты").child("products").child("product222"),
        )
        val productList3 = mutableListOf<Product>()

        adapter3 = AdapterProduct(productList3, this)
        val layoutManager3 = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.recycler3.adapter = adapter3
        binding.recycler3.layoutManager = layoutManager3

        productRefs3[0].get().addOnSuccessListener { dataSnapshot ->
            val product220 = dataSnapshot.getValue<Product>()
            productList3.add(product220!!)
            adapter3.notifyDataSetChanged()
        }
        productRefs3[1].get().addOnSuccessListener { dataSnapshot ->
            val product221 = dataSnapshot.getValue<Product>()
            productList3.add(product221!!)
            adapter3.notifyDataSetChanged()
        }
        productRefs3[2].get().addOnSuccessListener { dataSnapshot ->
            val product222 = dataSnapshot.getValue<Product>()
            productList3.add(product222!!)
            adapter3.notifyDataSetChanged()
        }

        productRefs4 = arrayOf(
            categoryRef.child("Овощи и фрукты").child("products").child("product230"),


        )
        val productList4 = mutableListOf<Product>()

        adapter4 = AdapterProduct(productList4, this)
        val layoutManager4 = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.recycler4.adapter = adapter4
        binding.recycler4.layoutManager = layoutManager4

        productRefs4[0].get().addOnSuccessListener { dataSnapshot ->
            val product230 = dataSnapshot.getValue<Product>()
            productList4.add(product230!!)
            adapter4.notifyDataSetChanged()
        }



    }




    private fun loadData(): MutableList<Product> {
        val productList = mutableListOf<Product>()
        productRefs[0].get().addOnSuccessListener { dataSnapshot ->
            val product101 = dataSnapshot.getValue<Product>()
            productList.add(product101!!)
            //val productImage = "${product101?.image}"
            adapter.notifyDataSetChanged()
        }
        productRefs[1].get().addOnSuccessListener { dataSnapshot ->
            val product101 = dataSnapshot.getValue<Product>()
            productList.add(product101!!)
            adapter.notifyDataSetChanged()
        }
        productRefs[2].get().addOnSuccessListener { dataSnapshot ->
            val product101 = dataSnapshot.getValue<Product>()
            productList.add(product101!!)
            adapter.notifyDataSetChanged()
        }
        return productList
    }


    override fun onPause() {
        super.onPause()
        SingletonCart.saveProductList(requireContext())

    }

    override fun onDestroy() {
        super.onDestroy()
        thread.interrupt()
    }

    override fun onResume() {
        SingletonCart.loadProductList(requireContext())
        super.onResume()
    }

    override fun onAddProduct(product: Product) {
        SingletonCart.addProduct(
            Product(
                quantity = 1,
                name = product.name,
                id = product.id,
                price = product.price,
                image = product.image
            )
        )
        Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteProduct(product: Product) {
        SingletonCart.deleteProduct(product)
        Toast.makeText(activity, "Удалено из корзины", Toast.LENGTH_SHORT).show()
    }
}