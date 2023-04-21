package com.example.meatdeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import com.example.meatdeliveryapp.categories.BreadFragment
import com.example.meatdeliveryapp.categories.MeatFragment
import com.example.meatdeliveryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
        binding.bottomAppBar.setOnItemSelectedListener { menuItem -> itemSelected(menuItem)}


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




}