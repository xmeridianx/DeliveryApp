package com.example.meatdeliveryapp.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meatdeliveryapp.R
import com.example.meatdeliveryapp.SingletonCart
import com.example.meatdeliveryapp.data.Product
import com.example.meatdeliveryapp.databinding.FragmentHomeBinding
import com.example.meatdeliveryapp.recyclerProduct.AdapterProduct
import com.example.meatdeliveryapp.recyclerProduct.OnProductClickListener
import com.example.meatdeliveryapp.view.categories.*
import com.example.meatdeliveryapp.categoryList.viewmodel.CategoryListViewModel
import com.google.android.gms.tasks.Tasks
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import java.util.concurrent.ExecutionException


class HomeFragment : Fragment(), OnProductClickListener {
    private lateinit var adapters: Array<AdapterProduct>
    private lateinit var productRefs: Array<DatabaseReference>
    private lateinit var thread: Thread
    private lateinit var database: FirebaseDatabase
    private val handler = Handler()
    private lateinit var categoryRef: DatabaseReference
    private lateinit var viewModel: CategoryListViewModel
    private lateinit var binding: FragmentHomeBinding

    //val sharedPref = SharedPreference()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // viewmodel через фабрику

        database = FirebaseDatabase.getInstance()
        categoryRef = database.getReference("Categories")

        SingletonCart.loadProductList(requireContext())

        adapters = Array(1) { AdapterProduct(mutableListOf(), this) }
        productRefs = arrayOf(
            categoryRef.child("Popular").child("popular")
        )

        thread = Thread {
            val productList = loadData(productRefs[0])
            adapters[0] = AdapterProduct(productList, this)
            val layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            handler.post {
                binding.popularRecycler.adapter = adapters[0]
                binding.popularRecycler.layoutManager = layoutManager
            }
        }
        thread.start()


        binding.vegetablesView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, VegetablesAndFruitsFragment())
                ?.addToBackStack(null)?.commit()
        }


        binding.breadView.setOnClickListener {
            val cartFragment = CartFragment()
            val args = Bundle()
            cartFragment.arguments = args

            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, BreadFragment())?.addToBackStack(null)?.commit()
        }
        binding.groceryView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, GroceryFragment())?.addToBackStack(null)?.commit()
        }
        binding.milkView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, MilkFragment())?.addToBackStack(null)?.commit()
        }
        binding.sweetsView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, SweetsFragment())?.addToBackStack(null)?.commit()
        }
        binding.fishView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, FishFragment())?.addToBackStack(null)?.commit()
        }
        binding.meatView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, MeatFragment())?.addToBackStack(null)?.commit()
        }
        binding.drinksView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, DrinksFragment())?.addToBackStack(null)?.commit()
        }
        binding.cannedFoodView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, CannedFoodFragment())?.addToBackStack(null)
                ?.commit()
        }
        binding.frozenFoodView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, FrozenFoodFragment())?.addToBackStack(null)
                ?.commit()
        }
        binding.oilAndSpicesView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, OilAndSpicesFragment())?.addToBackStack(null)
                ?.commit()
        }
        binding.snacksView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, SnacksFragment())?.addToBackStack(null)?.commit()
        }
        binding.coffeeAndTeaView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, CoffeeAndTeaFragment())?.addToBackStack(null)
                ?.commit()
        }
        binding.babyFoodView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, BabyFoodFragment())?.addToBackStack(null)?.commit()
        }
        binding.cleaningView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, CleaningFragment())?.addToBackStack(null)?.commit()
        }
        binding.medicineView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, MedicineFragment())?.addToBackStack(null)?.commit()
        }


    }

    private fun loadData(productRefs: DatabaseReference): MutableList<Product> {
        val productList = mutableListOf<Product>()

        try {
            val products = Tasks.await(productRefs.get())
            val p = ArrayList<Product>(products.getValue<Map<String, Product>>()!!.values)

            productList.addAll(p)
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
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
                imageUrl = product.imageUrl
            )
        )
        Toast.makeText(activity, "Добавлено в корзину", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteProduct(product: Product) {
        SingletonCart.deleteProduct(product)
        Toast.makeText(activity, "Удалено из корзины", Toast.LENGTH_SHORT).show()
    }
}

