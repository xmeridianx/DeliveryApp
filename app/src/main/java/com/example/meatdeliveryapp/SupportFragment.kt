package com.example.meatdeliveryapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meatdeliveryapp.Data.AdminActivity
import com.example.meatdeliveryapp.databinding.FragmentSupportBinding


class SupportFragment : Fragment() {
    private lateinit var binding : FragmentSupportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSupportBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        binding.adminButton.setOnClickListener {
            val intent = Intent(activity, AdminActivity::class.java)
            activity?.startActivity(intent)
        }
         */

        binding.textView1.setOnClickListener {
            val intent = Intent(activity, TermsOfUse::class.java)
            activity?.startActivity(intent)
        }
        binding.textView2.setOnClickListener {
            val intent = Intent(activity, QuestionsAndAnswers::class.java)
            activity?.startActivity(intent)
        }
        binding.textView3.setOnClickListener {
            val intent = Intent(activity, Support::class.java)
            activity?.startActivity(intent)
        }


    }
}