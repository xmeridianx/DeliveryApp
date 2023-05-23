package com.example.meatdeliveryapp.categories

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
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
            categoryRef.child("Овощи и фрукты").child("products").child("product216"),
            categoryRef.child("Овощи и фрукты").child("products").child("product217"),

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
            val product210 = dataSnapshot.getValue<Product>()
            product210?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fbanani.jpg?alt=media&token=60e1e537-8b80-411d-afc7-801fdf648967"
                productList2.add(it)
            }
            adapter2.notifyDataSetChanged()
        }
        productRefs2[1].get().addOnSuccessListener { dataSnapshot ->
            val product211 = dataSnapshot.getValue<Product>()
            product211?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fyabloki_golden.jpg?alt=media&token=60dce40c-539c-4764-8663-bcfd4ae0f4a6"
                productList2.add(it)
                adapter2.notifyDataSetChanged()
            }
        }
        productRefs2[2].get().addOnSuccessListener { dataSnapshot ->
            val product212 = dataSnapshot.getValue<Product>()
            product212?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fyabloki_krasn.jpg?alt=media&token=4cbdeb24-03c7-432f-988e-1236c6c32441"
                productList2.add(it)
                adapter2.notifyDataSetChanged()
            }
        }
            productRefs2[3].get().addOnSuccessListener { dataSnapshot ->
                val product213 = dataSnapshot.getValue<Product>()
                product213?.let {
                    it.image =
                        "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-54-02.jpg?alt=media&token=81cb472e-3420-4238-921a-7eeb7d2bf0c9"
                    productList2.add(it)
                    adapter2.notifyDataSetChanged()
                }
            }
                productRefs2[4].get().addOnSuccessListener { dataSnapshot ->
                    val product214 = dataSnapshot.getValue<Product>()
                    product214?.let {
                        it.image =
                            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Flimon.jpg?alt=media&token=a94671a8-e5b5-4479-9e74-b8e9f17cccb7"
                        productList2.add(it)
                        adapter2.notifyDataSetChanged()
                    }
                }
                    productRefs2[5].get().addOnSuccessListener { dataSnapshot ->
                        val product215 = dataSnapshot.getValue<Product>()
                        product215?.let {
                            it.image =
                                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-54-03.jpg?alt=media&token=f930dc09-cd35-4df2-98f0-ef1c57c0862f"
                            productList2.add(it)
                            adapter2.notifyDataSetChanged()
                        }
                    }
                    productRefs2[6].get().addOnSuccessListener { dataSnapshot ->
                        val product216 = dataSnapshot.getValue<Product>()
                        product216?.let {
                            it.image =
                                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-23_17-12-58%20(2).jpg?alt=media&token=45dcbe3d-22e1-490f-92ae-ea14eee03407"
                            productList2.add(it)
                            adapter2.notifyDataSetChanged()
                        }
                    }
                    productRefs2[7].get().addOnSuccessListener { dataSnapshot ->
                        val product217 = dataSnapshot.getValue<Product>()
                        product217?.let {
                            it.image =
                                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-23_17-12-58.jpg?alt=media&token=03d64087-d37f-4767-a26d-3822a3adb0a9"
                            productList2.add(it)
                            adapter2.notifyDataSetChanged()
                        }
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
                        product220?.let {
                            it.image =
                                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-49-55.jpg?alt=media&token=9856e476-003b-4d01-ab39-67a1f06586af"
                            productList3.add(it)
                        }
                        adapter3.notifyDataSetChanged()
                    }
                    productRefs3[1].get().addOnSuccessListener { dataSnapshot ->
                        val product221 = dataSnapshot.getValue<Product>()
                        product221?.let {
                            it.image =
                                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fluk_zelen.jpg?alt=media&token=9f4a42a2-ef79-4e8e-aac5-849a2057fa33"
                            productList3.add(it)
                        }
                        adapter3.notifyDataSetChanged()
                    }
                    productRefs3[2].get().addOnSuccessListener { dataSnapshot ->
                        val product222 = dataSnapshot.getValue<Product>()
                        product222?.let {
                            it.image =
                                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-49-55%20(2).jpg?alt=media&token=6e708607-ae0d-4be3-bcda-61e1b1ec69cd"
                            productList3.add(it)
                        }
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
                        val product301 = dataSnapshot.getValue<Product>()
                        product301?.let {
                            it.image =
                                "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-38-44.jpg?alt=media&token=cd64542e-d915-43b0-bc1b-63a43316f99c"
                            productList4.add(it)
                        }
                        adapter4.notifyDataSetChanged()
                    }
                }



    private fun loadData(): MutableList<Product> {
        val productList = mutableListOf<Product>()
        productRefs[0].get().addOnSuccessListener { dataSnapshot ->
            val product201 = dataSnapshot.getValue<Product>()
            product201?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fkartofel.jpg?alt=media&token=31d46aeb-5a2d-4f15-a06d-50f72882867c"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[1].get().addOnSuccessListener { dataSnapshot ->
            val product202 = dataSnapshot.getValue<Product>()
            product202?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fmorkov.jpg?alt=media&token=d8321ac4-ffbb-481d-91dd-d0fe48fde79e"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[2].get().addOnSuccessListener { dataSnapshot ->
            val product203 = dataSnapshot.getValue<Product>()
            product203?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fluk.jpg?alt=media&token=e6fc4644-469a-4a79-8a59-15fb6a160817"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[3].get().addOnSuccessListener { dataSnapshot ->
            val product204 = dataSnapshot.getValue<Product>()
            product204?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fpomidori.jpg?alt=media&token=b00a87f6-b319-4bc1-9a78-ff0272725403"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[4].get().addOnSuccessListener { dataSnapshot ->
            val product205 = dataSnapshot.getValue<Product>()
            product205?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fogyrci.jpg?alt=media&token=8e87e08e-e3c9-4eb8-9d6c-44a17348da66"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[5].get().addOnSuccessListener { dataSnapshot ->
            val product206 = dataSnapshot.getValue<Product>()
            product206?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-22_16-19-05.jpg?alt=media&token=7641fef9-3954-4aeb-b19c-0b1752297cab"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[6].get().addOnSuccessListener { dataSnapshot ->
            val product207 = dataSnapshot.getValue<Product>()
            product207?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-22_16-19-06.jpg?alt=media&token=742be7c5-33f3-4e77-8cb6-3894f0219da4"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[7].get().addOnSuccessListener { dataSnapshot ->
            val product208 = dataSnapshot.getValue<Product>()
            product208?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fkapusta.jpg?alt=media&token=8b9d4f7e-f2b8-4e91-a276-a309b2a400cc"
                productList.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        productRefs[8].get().addOnSuccessListener { dataSnapshot ->
            val product209 = dataSnapshot.getValue<Product>()
            product209?.let {
                it.image =
                    "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-22_16-19-06%20(3).jpg?alt=media&token=f7287965-60d5-4f2a-8840-87af19ffc200"
                productList.add(it)
            }
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