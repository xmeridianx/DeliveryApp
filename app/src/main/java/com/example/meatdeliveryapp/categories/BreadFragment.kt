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
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.SingletonCart.gson
import com.example.meatdeliveryapp.databinding.FragmentBreadBinding
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class BreadFragment : Fragment() {
    private lateinit var binding: FragmentBreadBinding
    private val storageRef = Firebase.storage.reference
    //private lateinit var sharedPreferences: SharedPreferences
    private val TAG = "BreadFragment"


    private lateinit var product1Ref: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreadBinding.inflate(inflater)
        return binding.root
    }
/*
    override fun onResume() {
        super.onResume()
        updateQuantity()
    }

 */

    private fun updateQuantity() {
        binding.textViewQuantity11.text = SingletonCart.getQuantity(1).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val productsRef = database.getReference("Categories")
        binding.toolbarBread.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        val imageRef = storageRef.child("images/banani.jpg")
        product1Ref = productsRef.child("Хлеб").child("products").child("product1")
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

                    val list = SingletonCart
                    list.addProduct (
                        Product(
                            quantity = 1,
                            id = 1,
                            name = "${product?.name}",
                            price = product?.price!!.toDouble(),
                            imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab"
                        )
                    )
                    Log.d(TAG, "Product added to cart: $product")

                    updateQuantity()
                    binding.textViewQuantity11.visibility = VISIBLE
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                }

                binding.buttonDelete11.setOnClickListener {

                    SingletonCart.deleteProduct(product!!)

                    updateQuantity()
                    Toast.makeText(activity, "Уделено из корзины", Toast.LENGTH_SHORT).show()

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

    private fun saveData() {

    }


    companion object {
        @JvmStatic
        fun newInstance() = BreadFragment()
    }
}