package com.example.meatdeliveryapp.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentMeatBinding
import com.example.meatdeliveryapp.Data.ProductTest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MeatFragment : Fragment() {
    private lateinit var binding: FragmentMeatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMeatBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val productsRef = database.getReference("товары")
        ////////////////////////////
        /*
        val product1Ref = productsRef.child("товар4")
        product1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val product = snapshot.getValue(ProductTest::class.java)
                binding.textViewName11.text = "${product?.name}"
                binding.textViewPrice11.text = "${product?.price}"
                binding.buttonAdd11.setOnClickListener {
                    SingletonCart.addProduct(product = Product(
                        id = SingletonCart.getProductList().size,
                        1, "${product?.name}", product?.price!!.toDouble(),
                        "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbanani.jpg?alt=media&token=21736ef8-918a-447a-9d5a-98f509fbeeb7"
                        ,
                        1))
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                    binding.buttonDelete11.setOnClickListener {
                        SingletonCart.deleteProduct(type = 1)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })

        val product2Ref = productsRef.child("товар5")
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
        val product3Ref = productsRef.child("товар6")
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

/*
        binding.buttonAddCoffeeOne.setOnClickListener {
            SingletonCart.addProduct(product = Product(1, "${product?.name}", 160, R.drawable.myaso))
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
        }

        binding.buttonAddCoffeeTwo.setOnClickListener {
            SingletonCart.addProduct(product = Product(2, "${product?.name}", 80, R.drawable.meat))
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
        }
        binding.buttonAddCoffeeThree.setOnClickListener {
            SingletonCart.addProduct(product = Product(3, "${product?.name}", 200, R.drawable.meat))
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
        }




        binding.buttonRemoveCoffeeOne.setOnClickListener {
            SingletonCart.deleteProduct(type = 1)
        }
        binding.buttonRemoveCoffeeTwo.setOnClickListener {
            SingletonCart.deleteProduct(type = 2)
        }
        binding.buttonRemoveCoffeeThree.setOnClickListener {
            SingletonCart.deleteProduct(type = 3)
        }
    }

 */
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MeatFragment()

         */
    }
}