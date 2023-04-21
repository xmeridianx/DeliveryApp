package com.example.meatdeliveryapp.Data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meatdeliveryapp.R

class AdminActivity : AppCompatActivity() {
    private val testAdmin = productBase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

         testAdmin.test()


    }
}