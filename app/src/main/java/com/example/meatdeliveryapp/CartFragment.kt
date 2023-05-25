package com.example.meatdeliveryapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meatdeliveryapp.databinding.FragmentCartBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

const val PREFERENCES_NAME = "my_preferences"

class CartFragment : Fragment(),OnProductChangeListener, OnProductCountChangeListener {

    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: Adapter
    private lateinit var auth: FirebaseAuth
    private lateinit var ref: DatabaseReference
    private lateinit var sharedPreferences: SharedPreferences
    private var totalPrice = 0.0

    val onProductChangeListener = object : OnProductChangeListener {
        override fun onProductAdded(product: Product) {
            adapter.notifyDataSetChanged()
        }

        override fun onProductRemoved(product: Product) {
            adapter.notifyDataSetChanged()
        }
    }

    var cart = SingletonCart.getProductList()
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
        SingletonCart.loadProductList(requireContext())
        adapter = Adapter(SingletonCart.getProductList().toMutableList(), onProductChangeListener)
        adapter.setOnProductCountChangeListener(this)

        binding.toolbarCart.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.toolbarCart.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.menu_delete){
                    SingletonCart.clear()
                    SingletonCart.saveProductList(requireContext())
                    adapter.notifyDataSetChanged()
                    updateTotalPrice()
                true
            }else{
                false
            }

        }

        binding.cartRecycler.layoutManager = LinearLayoutManager(context)
        binding.cartRecycler.adapter = adapter

        //adapter.setOnProductCountChangeListener(this)
        adapter.notifyDataSetChanged()
        updateTotalPrice()

        auth = FirebaseAuth.getInstance()
        ref = FirebaseDatabase.getInstance("https://delivery-bf3b3-default-rtdb.firebaseio.com/")
            .getReference("Users").child(auth.currentUser!!.uid)


        binding.orderCartButton.setOnClickListener {
            ref.child(auth.currentUser!!.uid).child("products")
                .setValue(SingletonCart.getProductList().toString() + "общая стоимость: " + totalPrice.toString() + " + 190р доставка")
            adapter.notifyDataSetChanged()
            ref = FirebaseDatabase.getInstance("https://delivery-bf3b3-default-rtdb.firebaseio.com/")
                    .getReference("Users").child(auth.currentUser!!.uid)

            setDatabaseListener()
            SingletonCart.clear()
            SingletonCart.saveProductList(requireContext())

            adapter.notifyDataSetChanged()
            updateTotalPrice()
            //
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(@NonNull snapshot: DataSnapshot) {

                }

                override fun onCancelled(@NonNull error: DatabaseError) {}
            })
            adapter.notifyDataSetChanged()
        }

        updateTotalPrice()
        adapter.notifyDataSetChanged()

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
    }

    override fun onProductAdded(product: Product) {
            val index = SingletonCart.getProductList().indexOfFirst { it.name == product.name }
            if (index != -1) {
                SingletonCart.getProductList()[index].quantity++
            } else {
                SingletonCart.addProduct(product)
            }
            calculateTotalPrice(cart)
            adapter.notifyDataSetChanged()
    }
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
        updateTotalPrice()
    }

    override fun onProductRemoved(product: Product) {

            val index = SingletonCart.getProductList().indexOfFirst { it.name == product.name }
            if (index != -1) {
                if (SingletonCart.getProductList()[index].quantity == 1) {
                    SingletonCart.deleteProduct(product)
                } else {
                    SingletonCart.getProductList()[index].quantity--
                }
            calculateTotalPrice(cart)
            adapter.notifyDataSetChanged()
        }
    }

    private fun calculateTotalPrice(cart: MutableList<Product>): Double {
        totalPrice = 0.0
        for (product in cart) {
            totalPrice += product.price * product.quantity
        }
        return totalPrice
    }

    private fun updateTotalPrice() {
        val productList: MutableList<Product> = SingletonCart.getProductList() as MutableList<Product>
        totalPrice = calculateTotalPrice(productList)
        binding.totalPriceTextView.text = "Итого: ${"%.2f".format(totalPrice + 190)} Р"
    }



    private fun setDatabaseListener() {
        ref.child(auth.currentUser!!.uid).child("products")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val products = snapshot.value as? MutableList<String>
                    if (products != null) {
                        activity?.runOnUiThread {
                            SingletonCart.getProductList().addAll(products.map { json ->
                                Gson().fromJson(
                                    json,
                                    Product::class.java
                                )
                            }) as MutableList<Product>
                            adapter.notifyDataSetChanged()
                            SingletonCart.clear()
                            updateTotalPrice()
                            adapter.notifyDataSetChanged()
                        }
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


    override fun onPause() {
        super.onPause()
        adapter.notifyDataSetChanged()
        updateTotalPrice()
        SingletonCart.saveProductList(requireContext())
    }
/*
    private fun saveProductsToSharedPreferences(products: List<Product>) {

        val productsJson = gson.toJson(products)
        sharedPreferences.edit().putStringSet("products_list", setOf(productsJson)).apply()
    }

 */
/*
    private fun readProductsFromSharedPreferences(): MutableList<Product> {

        val productsJson = sharedPreferences.getString("product_list", null)
        val productList = if (productsJson != null) {
            gson.fromJson(productsJson, object : TypeToken<MutableList<Product>>() {}.type)
        } else {
            emptyList<Product>()
        }

        return productList as MutableList<Product>
    }

 */
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
