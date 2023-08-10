package com.example.meatdeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.meatdeliveryapp.databinding.ActivityMainBinding
import com.example.meatdeliveryapp.categoryList.CategoryListFragment
import com.example.meatdeliveryapp.view.CartFragment
import com.example.meatdeliveryapp.view.HomeFragment
import com.example.meatdeliveryapp.view.ProfileFragment
import com.example.meatdeliveryapp.view.SupportFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel
    private lateinit var binding: ActivityMainBinding
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)
//поменял временно HomeFragment на HomeTestFragment
        if(isUserLoggedIn()){
            supportFragmentManager.beginTransaction().replace(R.id.container, CategoryListFragment())
                .commit()
        }else {
            supportFragmentManager.beginTransaction().replace(R.id.container, ProfileFragment()).commit()
        }
        binding.bottomAppBar.setOnItemSelectedListener { menuItem -> itemSelected(menuItem) }
    }

    private fun isUserLoggedIn(): Boolean {
        val currentUser = auth.currentUser
        return currentUser != null
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_bottom_app_bar, menu)
        return true
    }
    private fun itemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_home-> supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
            R.id.menu_item_profile->  supportFragmentManager.beginTransaction().replace(R.id.container, ProfileFragment()).commit()
            R.id.menu_item_help ->  supportFragmentManager.beginTransaction().replace(R.id.container, SupportFragment()).commit()
            R.id.menu_item_cart ->  supportFragmentManager.beginTransaction().replace(R.id.container, CartFragment()).commit()
        }

        return true
    }
    fun setBottomAppBarVisibility(visible: Boolean) {
        binding.bottomAppBar.visibility = if (visible) View.VISIBLE else View.GONE
    }




}