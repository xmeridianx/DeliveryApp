package com.example.meatdeliveryapp.SharedPref

import android.content.Context

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.meatdeliveryapp.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


public class SharedPreference (private val context: Context) {

    companion object {
        const val PREFS_NAME = "MyPrefs"
        const val KEY_CART_COUNT = "cartCount"
    }

    private fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getCartCount(): Int {
        val sharedPreferences = getSharedPreferences()
        return sharedPreferences.getInt(KEY_CART_COUNT, 0)
    }

    fun setCartCount(count: Int, productList: List<Product>) {
        val sharedPreferences = getSharedPreferences()
        val editor = sharedPreferences.edit()
        val jsonProductList = Gson().toJson(productList)
        editor.putString("productList", jsonProductList)
        editor.apply()
    }
}