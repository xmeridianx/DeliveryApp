package com.example.meatdeliveryapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meatdeliveryapp.databinding.FragmentCartBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CartFragment : Fragment(), OnProductChangeListener, OnProductCountChangeListener {
    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: Adapter
    private lateinit var auth: FirebaseAuth
    private lateinit var ref: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var sharedPreferences: SharedPreferences

    //private var totalPrice = 0.0
    var cart = SingletonCart
    private val gson = Gson()
    private var cartSize = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater)
        sharedPreferences =
            requireContext().getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        cartSize = arguments?.getInt("cartSize") ?: 0
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = Adapter(readProductsFromSharedPreferences().toMutableList())
        cart.addProducts(readProductsFromSharedPreferences())

        binding.cartRecycler.layoutManager = LinearLayoutManager(context)
        binding.cartRecycler.adapter = adapter

        adapter.setOnProductChangeListener(this)
        adapter.setOnProductCountChangeListener(this)
        adapter.notifyDataSetChanged()

        binding.clearCartButton.setOnClickListener {
            (cart.productList as MutableList<Product>).clear()
            adapter.notifyDataSetChanged()
            saveProductsToSharedPreferences(cart.productList)
            updateTotalPrice()
        }

        auth = FirebaseAuth.getInstance()
        ref = FirebaseDatabase.getInstance("https://delivery-bf3b3-default-rtdb.firebaseio.com/")
            .getReference("Users").child(auth.currentUser!!.uid)


        binding.orderCartButton.setOnClickListener {
            ref.child("Users").child(auth.currentUser!!.uid).child("products")
                .setValue(cart.productList.toString())
            ref =
                FirebaseDatabase.getInstance("https://delivery-bf3b3-default-rtdb.firebaseio.com/")
                    .getReference("Users").child(auth.currentUser!!.uid)

            setDatabaseListener()
            cart.clear()
            updateTotalPrice()
            //
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(@NonNull snapshot: DataSnapshot) {

                }

                override fun onCancelled(@NonNull error: DatabaseError) {}
            })
        }


    }

    override fun onProductAdded(product: Product) {
        val index = cart.productList.indexOfFirst { it.name == product.name }
        if (index != -1) {

            cart.productList[index].quantity++

        } else {

            cart.addProduct(product)
        }
        saveProductsToSharedPreferences(cart.productList)
        updateTotalPrice()
    }

    override fun onProductRemoved(product: Product) {
        val index = cart.productList.indexOfFirst { it.name == product.name }
        if (index != -1) {
            cart.productList[index].quantity--
            if (cart.productList[index].quantity == 0) {
                cart.productList.removeAt(index)
            }
            updateTotalPrice()
        }
    }

    private fun updateTotalPrice() {
        val totalPriceTextView: TextView = binding.totalPriceTextView
        val productList: List<Product> = cart.productList
        val totalPrice = calculateTotalPrice(productList)
        totalPriceTextView.text = "Итого: ${"%.2f".format(totalPrice + 190)} Р"
    }

    fun calculateTotalPrice(cart: List<Product>): Double {
        var totalPrice = 0.0
        for (product in cart) {
            totalPrice += product.price * product.quantity
        }
        return totalPrice
    }

    private fun setDatabaseListener() {
        ref.child("Users").child(auth.currentUser!!.uid).child("products")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val products = snapshot.value as? MutableList<String>
                    if (products != null) {
                        cart.productList = products.map { json ->
                            Gson().fromJson(
                                json,
                                Product::class.java
                            )
                        } as MutableList<Product>
                        adapter.notifyDataSetChanged()
                        updateTotalPrice()
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    companion object {

        @JvmStatic
        fun newInstance() = CartFragment()
    }

    override fun onProductCountChanged(count: Int) {

    }

    private fun saveProductsToSharedPreferences(products: List<Product>) {
        val gson = Gson()
        val productsJson = gson.toJson(products)
        sharedPreferences.edit().putStringSet("products", setOf(productsJson)).apply()
    }

    private fun readProductsFromSharedPreferences(): MutableList<Product> {
        val gson = Gson()
        val productsJson = sharedPreferences.getString("product_list", null)
        val productList = if (productsJson != null) {
            gson.fromJson(productsJson, object : TypeToken<MutableList<Product>>() {}.type)
        } else {
            emptyList<Product>()
        }

        return productList as MutableList<Product>
    }
}
    /*
override fun onStart() {
    super.onStart()
    val productListJson = sharedPreferences.getString("product_list", "[]")
    val productListType = object : TypeToken<ArrayList<Product>>() {}.type
    val productList: ArrayList<Product> = gson.fromJson(productListJson, productListType)
    for (product in productList) {
        SingletonCart.addProduct(product)
    }

}
override fun onResume() {
    super.onResume()
    val productListJson = sharedPreferences.getString("product_list", "[]")
    val productListType = object : TypeToken<ArrayList<Product>>() {}.type
    val productList: ArrayList<Product> = gson.fromJson(productListJson, productListType)
    for (product in productList) {
        SingletonCart.addProduct(product)
    }

}

//потом добавлю адрес
val adressCity = FirebaseDatabase.getInstance().reference.child("Users").child(
            Firebase.auth.currentUser?.uid ?: ""
        ).child("город")
        adressCity.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val city = snapshot.value as? String ?: ""

                val adressStreet = FirebaseDatabase.getInstance().reference.child("Users").child(
                    Firebase.auth.currentUser?.uid ?: ""
                ).child("улица")
                adressStreet.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val street = snapshot.value as? String ?: ""

                        val adressHouse = FirebaseDatabase.getInstance().reference.child("Users").child(
                            Firebase.auth.currentUser?.uid ?: ""
                        ).child("дом")
                        adressHouse.addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val house = snapshot.value as? String ?: ""

                                val adressApartment = FirebaseDatabase.getInstance().reference.child("Users").child(
                                    Firebase.auth.currentUser?.uid ?: ""
                                ).child("квартира")
                                adressApartment.addValueEventListener(object : ValueEventListener {
                                    override fun onDataChange(snapshot: DataSnapshot) {
                                        val apartment = snapshot.value as? String ?: ""

                                        binding.address.text = "Ваш адрес: $city, ул: $street, дом: $house, квартира: $apartment"
                                    }

                                    override fun onCancelled(error: DatabaseError) {

                                    }
                                })
                            }

                            override fun onCancelled(error: DatabaseError) {

                            }
                        })
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }
                })
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

 */
