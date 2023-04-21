package com.example.meatdeliveryapp.categories


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentBreadBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class BreadFragment : Fragment() {
    private lateinit var binding: FragmentBreadBinding
    private val storageRef = Firebase.storage.reference
    private lateinit var sharedPreferences: SharedPreferences
    private val TAG = "BreadFragment"
    val gson = Gson()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreadBinding.inflate(inflater)
        sharedPreferences =
            requireContext().getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        val productListJson = sharedPreferences.getString("product_list", "[]")
        val productListType = object : TypeToken<ArrayList<Product>>() {}.type
        val productList: ArrayList<Product> = gson.fromJson(productListJson, productListType)
        for (product in productList) {
            SingletonCart.addProduct(product)
        }
        binding.textViewQuantity11.text = SingletonCart.getQuantity(1).toString()
    }
    override fun onResume() {
        super.onResume()
        val productListJson = sharedPreferences.getString("product_list", "[]")
        val productListType = object : TypeToken<ArrayList<Product>>() {}.type
        val productList: ArrayList<Product> = gson.fromJson(productListJson, productListType)
        for (product in productList) {
            SingletonCart.addProduct(product)
        }
        binding.textViewQuantity11.text = SingletonCart.getQuantity(1).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val productsRef = database.getReference("Categories")

        val productListJson = sharedPreferences.getString("product_list", "[]")
        val productListType = object : TypeToken<ArrayList<Product>>() {}.type
        val productList: ArrayList<Product> = gson.fromJson(productListJson, productListType)

        val imageRef = storageRef.child("images/banani.jpg")
        val product1Ref = productsRef.child("Хлеб").child("products").child("product1")
        product1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d(TAG, "Data retrieved from Firebase: $snapshot")
                val product = snapshot.getValue(Product::class.java)
                binding.textViewName11.text = "${product?.name}"
                binding.textViewPrice11.text = "${product?.price}"
                Glide.with(this@BreadFragment)
                    .load("https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab")
                    .error(R.drawable.ic_baseline_error_24)
                    .into(binding.imageView11)

                binding.buttonAdd11.setOnClickListener {
                    binding.textViewQuantity11.visibility = VISIBLE
                    SingletonCart.addProduct(
                        Product(
                            quantity = 1,
                            id = 1,
                            name = "${product?.name}",
                            price = product?.price!!.toDouble(),
                            imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab"
                        )
                    )
                    with(sharedPreferences.edit()) {
                        putString("product_list", gson.toJson(SingletonCart.getProductList()))
                        apply()
                    }
                    binding.textViewQuantity11.text = SingletonCart.getQuantity(1).toString()
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()

                }
                binding.buttonDelete11.setOnClickListener {

                    SingletonCart.deleteProduct(product!!)
                    with(sharedPreferences.edit()) {
                        putString("product_list", gson.toJson(SingletonCart.getProductList()))
                        apply()
                    }
                    binding.textViewQuantity11.text = SingletonCart.getQuantity(1).toString()


                }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }


    override fun onPause() {
        super.onPause()
        saveData()
    }
    override fun onStop() {
        super.onStop()
        saveData()
    }
    override fun onDestroy() {
        super.onDestroy()
        saveData()
    }

    private fun saveData() {
        with(sharedPreferences.edit()) {
            putString("product_list", gson.toJson(SingletonCart.getProductList()))
            apply()
        }
    }





    companion object {
        @JvmStatic
        fun newInstance() = BreadFragment()
    }
}