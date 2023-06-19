package com.example.meatdeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meatdeliveryapp.databinding.ActivityTermsOfUseBinding

class TermsOfUse : AppCompatActivity() {
    private lateinit var binding: ActivityTermsOfUseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsOfUseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView2.text

    }
}