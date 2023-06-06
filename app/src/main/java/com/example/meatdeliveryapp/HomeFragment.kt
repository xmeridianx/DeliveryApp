package com.example.meatdeliveryapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.meatdeliveryapp.SharedPref.SharedPreference
import com.example.meatdeliveryapp.categories.*
import com.example.meatdeliveryapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
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

        binding.vegetablesView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, VegetablesAndFruitsFragment())?.addToBackStack(null)?.commit()
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
            transaction?.replace(R.id.container, CannedFoodFragment())?.addToBackStack(null)?.commit()
        }
        binding.frozenFoodView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, FrozenFoodFragment())?.addToBackStack(null)?.commit()
        }
        binding.oilAndSpicesView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, OilAndSpicesFragment())?.addToBackStack(null)?.commit()
        }
        binding.snacksView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, SnacksFragment())?.addToBackStack(null)?.commit()
        }
        binding.coffeeAndTeaView.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, CoffeeAndTeaFragment())?.addToBackStack(null)?.commit()
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


    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}