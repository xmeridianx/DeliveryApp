package com.example.meatdeliveryapp.categories


import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentBreadBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class BreadFragment : Fragment() {
    private lateinit var binding: FragmentBreadBinding
    private val storageRef = Firebase.storage.reference

    private lateinit var sharedPreferences: SharedPreferences
    private val TAG = "BreadFragment"

    private lateinit var productRefs: Array<DatabaseReference>
    private val list = SingletonCart
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreadBinding.inflate(inflater)
        return binding.root
    }

    private fun updateQuantity() {
        val quantities = arrayOf(
            SingletonCart.getQuantity(101).toString(),
            SingletonCart.getQuantity(102).toString(),
            SingletonCart.getQuantity(103).toString()
        )
        binding.textViewQuantity11.text = quantities[0]
        binding.textViewQuantity12.text = quantities[1]
        binding.textViewQuantity13.text = quantities[2]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val categoryRef = database.getReference("Categories")
        binding.toolbarBread.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        SingletonCart.loadProductList(requireContext())
        //val imageRef = storageRef.child("images/banani.jpg")
        productRefs = arrayOf(
            categoryRef.child("Хлеб").child("products").child("product101"),
            categoryRef.child("Хлеб").child("products").child("product102"),
            categoryRef.child("Хлеб").child("products").child("product103")
        )




        productRefs[0].get().addOnSuccessListener { dataSnapshot ->
            val product101 = dataSnapshot.getValue<Product>()
            binding.textViewName11.text = "${product101?.name}"
            binding.textViewPrice11.text = "${product101?.price}"
            val productImage = "${product101?.image}"
            loadImageWithGlide(productImage, binding.imageView101)

            binding.buttonAddToCart11.setOnClickListener {
                addProduct(product101!!)
                hideView(binding.buttonDelete11, binding.textViewQuantity11, binding.buttonAdd11, binding.buttonAddToCart11)
            }
            binding.buttonAdd11.setOnClickListener {
                addProduct(product101!!)
            }
            binding.buttonDelete11.setOnClickListener {
                    deleteProduct(product101!!)
                if (SingletonCart.getQuantity(101) == 0){
                    showView(binding.buttonDelete11, binding.textViewQuantity11, binding.buttonAdd11, binding.buttonAddToCart11)
                }
            }
        }

        productRefs[1].get().addOnSuccessListener { dataSnapshot ->
            val product102 = dataSnapshot.getValue<Product>()
            binding.textViewName12.text = "${product102?.name}"
            binding.textViewPrice12.text = "${product102?.price}"
            val productImage = "${product102?.image}"
            loadImageWithGlide(productImage, binding.imageView102)

            binding.buttonAddToCart12.setOnClickListener {
                addProduct(product102!!)
                hideView(
                    binding.buttonDelete12,
                    binding.textViewQuantity12,
                    binding.buttonAdd12,
                    binding.buttonAddToCart12
                )
            }
            binding.buttonAdd12.setOnClickListener {
                addProduct(product102!!)
            }
            binding.buttonDelete12.setOnClickListener {
                deleteProduct(product102!!)
                if (SingletonCart.getQuantity(102) == 0) {
                    showView(
                        binding.buttonDelete12,
                        binding.textViewQuantity12,
                        binding.buttonAdd12,
                        binding.buttonAddToCart12
                    )
                }
            }
        }

        productRefs[2].get().addOnSuccessListener { dataSnapshot ->
            val product103 = dataSnapshot.getValue<Product>()
            binding.textViewName13.text = "${product103?.name}"
            binding.textViewPrice13.text = "${product103?.price}"
            val productImage = "${product103?.image}"
            loadImageWithGlide(productImage, binding.imageView103)

            binding.buttonAddToCart13.setOnClickListener {
                addProduct(product103!!)
                hideView(
                    binding.buttonDelete13,
                    binding.textViewQuantity13,
                    binding.buttonAdd13,
                    binding.buttonAddToCart13
                )
            }
            binding.buttonAdd13.setOnClickListener {
                addProduct(product103!!)
            }
            binding.buttonDelete13.setOnClickListener {
                deleteProduct(product103!!)
                if (SingletonCart.getQuantity(103) == 0) {
                    showView(
                        binding.buttonDelete13,
                        binding.textViewQuantity13,
                        binding.buttonAdd13,
                        binding.buttonAddToCart13
                    )
                }
            }
        }


    }
    override fun onPause() {
        super.onPause()
        SingletonCart.saveProductList(requireContext())
        saveData()
    }

    override fun onResume() {
        super.onResume()
        updateQuantity()
            hideView(binding.buttonDelete11, binding.textViewQuantity11, binding.buttonAdd11, binding.buttonAddToCart11)

            hideView(binding.buttonDelete12, binding.textViewQuantity12, binding.buttonAdd12, binding.buttonAddToCart12)

            hideView(binding.buttonDelete13, binding.textViewQuantity13, binding.buttonAdd13, binding.buttonAddToCart13)

    }

    private fun loadImageWithGlide(imageUrl: String, imageView: ImageView) {
        Glide.with(this@BreadFragment)
            .load(imageUrl)
            .error(R.drawable.ic_baseline_error_24)
            .into(imageView)
    }

    private fun deleteProduct(product: Product) {
        SingletonCart.deleteProduct(product)
        updateQuantity()
        Toast.makeText(activity, "Удалено из корзины", Toast.LENGTH_SHORT).show()
    }

    private fun addProduct(product: Product) {
        list.addProduct(
            Product(
                quantity = 1,
                name = product.name,
                id = product.id,
                price = product.price,
                image = product.image
            )
        )
        updateQuantity()
        Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
    }

    private fun hideView(buttonDelete: ImageButton, textViewQuantity: TextView, buttonAdd: ImageButton, buttonAddToCart: Button) {
        buttonDelete.visibility = VISIBLE
        textViewQuantity.visibility = VISIBLE
        buttonAdd.visibility = VISIBLE
        buttonAddToCart.visibility = GONE
    }

    private fun showView(buttonDelete: ImageButton, textViewQuantity: TextView, buttonAdd: ImageButton, buttonAddToCart: Button) {
        buttonDelete.visibility = GONE
        textViewQuantity.visibility = GONE
        buttonAdd.visibility = GONE
        buttonAddToCart.visibility = VISIBLE
    }


    private fun saveData() {

    }


    companion object {
        @JvmStatic
        fun newInstance() = BreadFragment()
    }
}




/*
        product1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val product = snapshot.getValue(Product::class.java)
                binding.textViewName11.text = "${product?.name}"
                binding.textViewPrice11.text = "${product?.price}"
                Glide.with(this@BreadFragment)
                    .load("https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab")
                    .error(R.drawable.ic_baseline_error_24)
                    .into(binding.imageView11)


                binding.buttonAddToCart11.setOnClickListener {

                    list.addProduct(
                        Product(
                            quantity = 1,
                            id = 1,
                            name = "${product?.name}",
                            price = product?.price!!.toDouble(),
                            imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab"
                        )
                    )
                    updateQuantity()
                    hideView()
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                }



                binding.buttonAdd11.setOnClickListener {

                    list.addProduct(
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
                    Toast.makeText(activity, "Удалено из корзины", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

 */


/*
product1Ref.addValueEventListener(object : ValueEventListener {
    override fun onDataChange(snapshot: DataSnapshot) {
        val product = snapshot.getValue(Product::class.java)
        binding.textViewName11.text = "${product?.name}"
        binding.textViewPrice11.text = "${product?.price}"
        Glide.with(this@BreadFragment)
            .load("https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab")
            .error(R.drawable.ic_baseline_error_24)
            .into(binding.imageView11)
        binding.buttonAddToCart11.setOnClickListener {
            val list = SingletonCart
            list.addProduct(
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
            binding.buttonDelete11.visibility = VISIBLE
            binding.textViewQuantity11.visibility = VISIBLE
            binding.buttonAdd11.visibility = VISIBLE
            binding.buttonAddToCart11.visibility = GONE
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
        }
        binding.buttonAdd11.setOnClickListener {
            val list = SingletonCart
            list.addProduct(
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
            Toast.makeText(activity, "Удалено из корзины", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCancelled(error: DatabaseError) {

    }
})

 */


/*
        product2Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val product = snapshot.getValue(Product::class.java)
                binding.textViewName12.text = "${product?.name}"
                binding.textViewPrice12.text = "${product?.price}"
                Glide.with(this@BreadFragment)
                    .load("https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fborodin.jpg?alt=media&token=aab7e9d2-e8a8-4bec-af2f-ee8db6155b59")
                    .error(R.drawable.ic_baseline_error_24)
                    .into(binding.imageView12)
                binding.buttonAddToCart12.setOnClickListener {
                    val list = SingletonCart
                    list.addProduct(
                        Product(
                            quantity = 1,
                            id = 2,
                            name = "${product?.name}",
                            price = product?.price!!.toDouble(),
                            imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fborodin.jpg?alt=media&token=aab7e9d2-e8a8-4bec-af2f-ee8db6155b59"
                        )
                    )
                    Log.d(TAG, "Product added to cart: $product")
                    updateQuantity()
                    binding.buttonDelete12.visibility = VISIBLE
                    binding.textViewQuantity12.visibility = VISIBLE
                    binding.buttonAdd12.visibility = VISIBLE
                    binding.buttonAddToCart12.visibility = GONE
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                }


                binding.buttonAdd12.setOnClickListener {

                    val list = SingletonCart
                    list.addProduct(
                        Product(
                            quantity = 1,
                            id = 2,
                            name = "${product?.name}",
                            price = product?.price!!.toDouble(),
                            imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fborodin.jpg?alt=media&token=aab7e9d2-e8a8-4bec-af2f-ee8db6155b59"
                        )
                    )
                    Log.d(TAG, "Product added to cart: $product")

                    updateQuantity()
                    binding.buttonDelete12.visibility = VISIBLE
                    binding.buttonAdd12.visibility = VISIBLE
                    binding.buttonAddToCart12.visibility = GONE
                    binding.textViewQuantity12.visibility = VISIBLE
                    Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
                }

                binding.buttonDelete12.setOnClickListener {

                    SingletonCart.deleteProduct(product!!)

                    updateQuantity()
                    Toast.makeText(activity, "Удалено из корзины", Toast.LENGTH_SHORT).show()

                }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

/*
        product3Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val product = snapshot.getValue(Product::class.java)
        binding.textViewName13.text = "${product?.name}"
        binding.textViewPrice13.text = "${product?.price}"
        Glide.with(this@BreadFragment)
            .load("https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbulgarskiy.jpg?alt=media&token=45e491c3-3c65-4476-bbdd-9c2357345895")
            .error(R.drawable.ic_baseline_error_24)
            .into(binding.imageView13)

        binding.buttonAddToCart13.setOnClickListener {
            val list = SingletonCart
            list.addProduct (
                Product(
                    quantity = 1,
                    id = 3,
                    name = "${product?.name}",
                    price = product?.price!!.toDouble(),
                    imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbulgarskiy.jpg?alt=media&token=45e491c3-3c65-4476-bbdd-9c2357345895"
                )
            )
            Log.d(TAG, "Product added to cart: $product")

            updateQuantity()
            binding.buttonDelete13.visibility = VISIBLE
            binding.textViewQuantity13.visibility = VISIBLE
            binding.buttonAdd13.visibility = VISIBLE
            binding.buttonAddToCart13.visibility = GONE
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()

        }

 */


        binding.buttonAdd13.setOnClickListener {

            val list = SingletonCart
            list.addProduct (
                Product(
                    quantity = 1,
                    id = 3,
                    name = "${product?.name}",
                    price = product?.price!!.toDouble(),
                    imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbulgarskiy.jpg?alt=media&token=45e491c3-3c65-4476-bbdd-9c2357345895"
                )
            )
            Log.d(TAG, "Product added to cart: $product")

            updateQuantity()
            binding.textViewQuantity11.visibility = VISIBLE
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
        }

        binding.buttonDelete13.setOnClickListener {

            SingletonCart.deleteProduct(product!!)

            updateQuantity()
            Toast.makeText(activity, "Уделено из корзины", Toast.LENGTH_SHORT).show()

        }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

            }
 */
            /*
            binding.textViewName13.text = "${product?.name}"
        binding.textViewPrice13.text = "${product?.price}"
        Glide.with(this@BreadFragment)
            .load("https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbulgarskiy.jpg?alt=media&token=45e491c3-3c65-4476-bbdd-9c2357345895")
            .error(R.drawable.ic_baseline_error_24)
            .into(binding.imageView11)

        binding.buttonAddToCart13.setOnClickListener {
            val list = SingletonCart
            list.addProduct (
                Product(
                    quantity = 1,
                    id = 3,
                    name = "${product?.name}",
                    price = product?.price!!.toDouble(),
                    imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbulgarskiy.jpg?alt=media&token=45e491c3-3c65-4476-bbdd-9c2357345895"
                )
            )
            Log.d(TAG, "Product added to cart: $product")

            updateQuantity()
            binding.buttonDelete13.visibility = VISIBLE
            binding.textViewQuantity13.visibility = VISIBLE
            binding.buttonAdd13.visibility = VISIBLE
            binding.buttonAddToCart13.visibility = GONE
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()

        }


        binding.buttonAdd13.setOnClickListener {

            val list = SingletonCart
            list.addProduct (
                Product(
                    quantity = 1,
                    id = 3,
                    name = "${product?.name}",
                    price = product?.price!!.toDouble(),
                    imageUrl = "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbulgarskiy.jpg?alt=media&token=45e491c3-3c65-4476-bbdd-9c2357345895"
                )
            )
            Log.d(TAG, "Product added to cart: $product")

            updateQuantity()
            binding.textViewQuantity11.visibility = VISIBLE
            Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
        }

        binding.buttonDelete13.setOnClickListener {

            SingletonCart.deleteProduct(product!!)

            updateQuantity()
            Toast.makeText(activity, "Уделено из корзины", Toast.LENGTH_SHORT).show()

        }

             */