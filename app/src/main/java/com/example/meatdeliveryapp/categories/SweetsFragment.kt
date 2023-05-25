package com.example.meatdeliveryapp.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meatdeliveryapp.R


class SweetsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sweets, container, false)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SweetsFragment()

    }
}


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
    private fun createProductRefs(categoryName: String, subcategoryName: String): Array<DatabaseReference> {
        val productRefs = mutableListOf<DatabaseReference>()
        val categoryRef = database.getReference("Categories").child(categoryName).child(subcategoryName)
        val subcategoryIdOffset = (1 + 1) * 100

        for (i in 1..10) {
            val subcategoryId = subcategoryIdOffset + i
            val subcategoryRef = categoryRef.child("subcategory$subcategoryId")
            for (j in 1..10) {
                val productId = (subcategoryId * 10) + j
                val productRef = subcategoryRef.child("product$productId")
                productRefs.add(productRef)
            }
        }

        return productRefs.toTypedArray()
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


