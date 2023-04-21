package com.example.meatdeliveryapp.categories

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentBabyFoodBinding
import com.example.meatdeliveryapp.Data.ProductTest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class BabyFoodFragment : Fragment() {
    private lateinit var binding : FragmentBabyFoodBinding
    val storageRef = Firebase.storage.reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBabyFoodBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val productsRef = database.getReference("товары")
/*
        val imageRef = storageRef.child("images/banani.jpg")
        ////////////////////////////
        val product1Ref = productsRef.child("товар1")
        product1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d(ContentValues.TAG, "Data retrieved from Firebase: $snapshot")
                val product = snapshot.getValue(ProductTest::class.java)
                binding.textViewName11.text = "${product?.name}"
                binding.textViewPrice11.text = "${product?.price}"
                Glide.with(this@BabyFoodFragment)
                    .load("https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbanani.jpg?alt=media&token=21736ef8-918a-447a-9d5a-98f509fbeeb7")
                    .error(R.drawable.ic_baseline_error_24)
                    .into(binding.imageView11)

                binding.buttonAdd11.setOnClickListener {
                    SingletonCart.addProduct(
                        product = Product(
                            id = SingletonCart.getProductList().size,
                            1,
                            "${product?.name}",
                            product?.price!!.toDouble(),
                            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbanani.jpg?alt=media&token=21736ef8-918a-447a-9d5a-98f509fbeeb7"
                        )
                    )
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                    binding.buttonDelete11.setOnClickListener {
                        SingletonCart.deleteProduct(type = 1)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, "Error retrieving data from Firebase", error.toException())
            }
        })
        val product2Ref = productsRef.child("товар2")
        product2Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val product = snapshot.getValue(ProductTest::class.java)
                binding.textViewName12.text = "${product?.name}"
                binding.textViewPrice12.text = "${product?.price}"
                binding.buttonAdd12.setOnClickListener {
                    SingletonCart.addProduct(
                        product = Product(
                            id = SingletonCart.getProductList().size,
                            2,
                            "${product?.name}",
                            product?.price!!.toDouble(),
                            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbanani.jpg?alt=media&token=21736ef8-918a-447a-9d5a-98f509fbeeb7"
                        )
                    )
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                    binding.buttonDelete12.setOnClickListener {
                        SingletonCart.deleteProduct(type = 2)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        val product3Ref = productsRef.child("товар3")
        product3Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val product = snapshot.getValue(ProductTest::class.java)
                binding.textViewName13.text = "${product?.name}"
                binding.textViewPrice13.text = "${product?.price}"
                binding.buttonAdd13.setOnClickListener {
                    SingletonCart.addProduct(
                        product = Product(
                            id = SingletonCart.getProductList().size,
                            3,
                            "${product?.name}",
                            product?.price!!.toDouble(),
                            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbanani.jpg?alt=media&token=21736ef8-918a-447a-9d5a-98f509fbeeb7"
                        )
                    )
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                    binding.buttonDelete13.setOnClickListener {
                        SingletonCart.deleteProduct(type = 3)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }





    companion object {
        @JvmStatic
        fun newInstance() =
            BabyFoodFragment()
    }

 */
    }
}