package com.example.meatdeliveryapp.categories


import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.Adapter
import com.example.meatdeliveryapp.Product
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.databinding.FragmentBreadBinding
import com.example.meatdeliveryapp.recyclerProduct.AdapterProduct
import com.example.meatdeliveryapp.recyclerProduct.OnProductClickListener
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class BreadFragment : Fragment(), OnProductClickListener {
    private lateinit var binding: FragmentBreadBinding
    private lateinit var adapter: AdapterProduct
    private lateinit var adapter2: AdapterProduct
    private lateinit var adapter3: AdapterProduct
    private lateinit var productRefs: Array<DatabaseReference>
    private lateinit var productRefs2: Array<DatabaseReference>
    private lateinit var productRefs3: Array<DatabaseReference>
    private lateinit var thread: Thread



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreadBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val categoryRef = database.getReference("Categories")
        val handler = Handler()

        binding.toolbarBread.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        SingletonCart.loadProductList(requireContext())
        //val imageRef = storageRef.child("images/banani.jpg")

        productRefs = arrayOf(
            categoryRef.child("Хлеб").child("products").child("product101"),
            categoryRef.child("Хлеб").child("products").child("product102"),
            categoryRef.child("Хлеб").child("products").child("product103"),
            categoryRef.child("Хлеб").child("products").child("product104"),
            categoryRef.child("Хлеб").child("products").child("product105"),
        )
        thread = Thread {
            val productList = loadData()

            adapter = AdapterProduct(productList, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            handler.post {
                binding.recyclerBread.adapter = adapter
                binding.recyclerBread.layoutManager = layoutManager

            }
        }
        thread.start()



        productRefs2 = arrayOf(
            categoryRef.child("Хлеб").child("products").child("product111"),
            categoryRef.child("Хлеб").child("products").child("product112"),
            categoryRef.child("Хлеб").child("products").child("product113"),
        )
        val productList2 = mutableListOf<Product>()

        adapter2 = AdapterProduct(productList2, this)
        val layoutManager2 = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )


        binding.recyclerBread2.adapter = adapter2
        binding.recyclerBread2.layoutManager = layoutManager2

        productRefs2[0].get().addOnSuccessListener { dataSnapshot ->
            val product111 = dataSnapshot.getValue<Product>()
            product111?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fsdoba.jpg?alt=media&token=92ca2c18-92f9-4695-a764-61f5360ba7e8"
                productList2.add(it)
                adapter2.notifyDataSetChanged()
            }
        }
        productRefs2[1].get().addOnSuccessListener { dataSnapshot ->
            val product112 = dataSnapshot.getValue<Product>()
            product112?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fsochni2.jpg?alt=media&token=d6c4a8a4-5454-433d-9492-d43fce00f9a1"
                productList2.add(it)
                adapter2.notifyDataSetChanged()
            }
        }
        productRefs2[2].get().addOnSuccessListener { dataSnapshot ->
            val product113 = dataSnapshot.getValue<Product>()
            product113?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(6).jpg?alt=media&token=acaa4be8-a623-48fb-b2b6-fce6f1185a0f"
                productList2.add(it)
                adapter2.notifyDataSetChanged()
            }


    }

    productRefs3 = arrayOf(
        categoryRef.child("Хлеб").child("products").child("product121"),
        categoryRef.child("Хлеб").child("products").child("product122"),
        categoryRef.child("Хлеб").child("products").child("product123"),
        categoryRef.child("Хлеб").child("products").child("product124"),
        categoryRef.child("Хлеб").child("products").child("product125"),
    )
    val productList3 = mutableListOf<Product>()

    adapter3 = AdapterProduct(productList3, this)
    val layoutManager3 = LinearLayoutManager(
        requireContext(),
        LinearLayoutManager.HORIZONTAL, false
    )


    binding.recyclerBread3.adapter = adapter3
    binding.recyclerBread3.layoutManager = layoutManager3

    productRefs3[0].get().addOnSuccessListener { dataSnapshot ->
        val product121 = dataSnapshot.getValue<Product>()
        product121?.let {
            it.image =
                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(5).jpg?alt=media&token=e940079d-7e26-4f0e-ada2-28063986e450"
            productList3.add(it)
            adapter3.notifyDataSetChanged()
        }
    }
    productRefs3[1].get().addOnSuccessListener { dataSnapshot ->
        val product122 = dataSnapshot.getValue<Product>()
        product122?.let {
            it.image =
                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(4).jpg?alt=media&token=7d43535f-cdab-457b-a4b8-479527fa0a58"
            productList3.add(it)
            adapter3.notifyDataSetChanged()
        }
    }
    productRefs3[2].get().addOnSuccessListener { dataSnapshot ->
        val product123 = dataSnapshot.getValue<Product>()
        product123?.let {
            it.image =
                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(3).jpg?alt=media&token=12101d29-ce58-48e3-86a9-09307307425e"
            productList3.add(it)
            adapter3.notifyDataSetChanged()
        }
    }
        productRefs3[3].get().addOnSuccessListener { dataSnapshot ->
            val product124 = dataSnapshot.getValue<Product>()
            product124?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(2).jpg?alt=media&token=fdfcb4e7-78e8-4583-9fa6-9b2884f3ca0e"
                productList3.add(it)
                adapter3.notifyDataSetChanged()
            }
        }
        productRefs3[4].get().addOnSuccessListener { dataSnapshot ->
            val product125 = dataSnapshot.getValue<Product>()
            product125?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04.jpg?alt=media&token=84b70cd4-1dc5-4c32-b46e-a04257e87a49"
                productList3.add(it)
                adapter3.notifyDataSetChanged()
            }
        }
}

    private fun loadData(): MutableList<Product> {
        val productList = mutableListOf<Product>()
        productRefs[0].get().addOnSuccessListener { dataSnapshot ->
            val product101 = dataSnapshot.getValue<Product>()
            product101?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab"
                productList.add(it)
                adapter.notifyDataSetChanged()
            }
        }
        productRefs[1].get().addOnSuccessListener { dataSnapshot ->
            val product102 = dataSnapshot.getValue<Product>()
            product102?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-03%20(2).jpg?alt=media&token=4a63c4fa-8f0d-47f6-aaef-690a29cebc75"
                productList.add(it)
                adapter.notifyDataSetChanged()
            }
        }
        productRefs[2].get().addOnSuccessListener { dataSnapshot ->
            val product103 = dataSnapshot.getValue<Product>()
            product103?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-03%20(3).jpg?alt=media&token=7d729940-22e1-41ba-b829-51fc27d05ff8"
                productList.add(it)
                adapter.notifyDataSetChanged()
            }
        }
        productRefs[3].get().addOnSuccessListener { dataSnapshot ->
            val product104 = dataSnapshot.getValue<Product>()
            product104?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fborodin.jpg?alt=media&token=aab7e9d2-e8a8-4bec-af2f-ee8db6155b59"
                productList.add(it)
                adapter.notifyDataSetChanged()
            }
        }
        productRefs[4].get().addOnSuccessListener { dataSnapshot ->
            val product105 = dataSnapshot.getValue<Product>()
            product105?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"
                productList.add(it)
                adapter.notifyDataSetChanged()
            }
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


/*


        //


            /*
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

             */


        /*
        productRefs[1].get().addOnSuccessListener { dataSnapshot ->
            val product101 = dataSnapshot.getValue<Product>()
            productList.add(product101!!)
            binding.textViewName11.text = "${product101?.name}"
            binding.textViewPrice11.text = "${product101?.price}"

            val productImage = "${product101?.image}"
            adapter = AdapterProduct(productList, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            binding.recyclerBread.adapter = adapter
            binding.recyclerBread.layoutManager = layoutManager
        }

        productRefs[2].get().addOnSuccessListener { dataSnapshot ->
            val product101 = dataSnapshot.getValue<Product>()
            productList.add(product101!!)
            binding.textViewName11.text = "${product101?.name}"
            binding.textViewPrice11.text = "${product101?.price}"

            val productImage = "${product101?.image}"
            adapter = AdapterProduct(productList, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            binding.recyclerBread.adapter = adapter
            binding.recyclerBread.layoutManager = layoutManager
        }

         */
            /*
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

         */
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