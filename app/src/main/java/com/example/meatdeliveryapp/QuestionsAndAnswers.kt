package com.example.meatdeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.meatdeliveryapp.databinding.ActivityQuestionsAndAnswersBinding
import com.example.meatdeliveryapp.databinding.FragmentSupportBinding

class QuestionsAndAnswers : AppCompatActivity() {
    private lateinit var binding : ActivityQuestionsAndAnswersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsAndAnswersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {

        }

        binding.mainTextView1.setOnClickListener {
            if (binding.dropdownTextView1.visibility == View.GONE) {
                binding.dropdownTextView1.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView1.visibility = View.GONE
            }
        }
        binding.arrowButton1.setOnClickListener {
            if (binding.dropdownTextView1.visibility == View.GONE) {
                binding.dropdownTextView1.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView1.visibility = View.GONE
            }
        }

        binding.mainTextView2.setOnClickListener {
            if (binding.dropdownTextView2.visibility == View.GONE) {
                binding.dropdownTextView2.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView2.visibility = View.GONE
            }
        }
        binding.arrowButton2.setOnClickListener {
            if (binding.dropdownTextView2.visibility == View.GONE) {
                binding.dropdownTextView2.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView2.visibility = View.GONE
            }
        }

        binding.mainTextView3.setOnClickListener {
            if (binding.dropdownTextView3.visibility == View.GONE) {
                binding.dropdownTextView3.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView3.visibility = View.GONE
            }
        }
        binding.arrowButton3.setOnClickListener {
            if (binding.dropdownTextView3.visibility == View.GONE) {
                binding.dropdownTextView3.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView3.visibility = View.GONE
            }
        }

        binding.mainTextView4.setOnClickListener {
            if (binding.dropdownTextView4.visibility == View.GONE) {
                binding.dropdownTextView4.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView4.visibility = View.GONE
            }
        }
        binding.arrowButton4.setOnClickListener {
            if (binding.dropdownTextView4.visibility == View.GONE) {
                binding.dropdownTextView4.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView4.visibility = View.GONE
            }
        }

        binding.mainTextView5.setOnClickListener {
            if (binding.dropdownTextView5.visibility == View.GONE) {
                binding.dropdownTextView5.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView5.visibility = View.GONE
            }
        }
        binding.arrowButton5.setOnClickListener {
            if (binding.dropdownTextView5.visibility == View.GONE) {
                binding.dropdownTextView5.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView5.visibility = View.GONE
            }
        }
        binding.mainTextView6.setOnClickListener {
            if (binding.dropdownTextView6.visibility == View.GONE) {
                binding.dropdownTextView6.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView6.visibility = View.GONE
            }
        }
        binding.arrowButton6.setOnClickListener {
            if (binding.dropdownTextView6.visibility == View.GONE) {
                binding.dropdownTextView6.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView6.visibility = View.GONE
            }
        }

        binding.mainTextView7.setOnClickListener {
            if (binding.dropdownTextView7.visibility == View.GONE) {
                binding.dropdownTextView7.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView7.visibility = View.GONE
            }
        }
        binding.arrowButton7.setOnClickListener {
            if (binding.dropdownTextView7.visibility == View.GONE) {
                binding.dropdownTextView7.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView7.visibility = View.GONE
            }
        }

        binding.mainTextView8.setOnClickListener {
            if (binding.dropdownTextView8.visibility == View.GONE) {
                binding.dropdownTextView8.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView8.visibility = View.GONE
            }
        }
        binding.arrowButton8.setOnClickListener {
            if (binding.dropdownTextView8.visibility == View.GONE) {
                binding.dropdownTextView8.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView8.visibility = View.GONE
            }
        }
        binding.mainTextView9.setOnClickListener {
            if (binding.dropdownTextView9.visibility == View.GONE) {
                binding.dropdownTextView9.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView9.visibility = View.GONE
            }
        }
        binding.arrowButton9.setOnClickListener {
            if (binding.dropdownTextView9.visibility == View.GONE) {
                binding.dropdownTextView9.visibility = View.VISIBLE
            } else {
                binding.dropdownTextView9.visibility = View.GONE
            }
        }
    }
}