package com.example.meatdeliveryapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.meatdeliveryapp.databinding.FragmentProfileBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private val prefFileName = "MyPrefs"
    private lateinit var binding: FragmentProfileBinding
    private var singletonLogin = SingletonLogin
    private lateinit var auth: FirebaseAuth
    private lateinit var orderStatusRef: DatabaseReference
    private lateinit var database: FirebaseDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        sharedPreferences =
            requireActivity().getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameRef = FirebaseDatabase.getInstance().reference.child("Users").child(
            Firebase.auth.currentUser?.uid ?: ""
        ).child("имя")
        database = FirebaseDatabase.getInstance()
        auth = Firebase.auth

        orderStatusRef = database.reference.child("Users")
            .child(auth.currentUser!!.uid)
            .child("orderStatus")
        nameRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val name = snapshot.value as? String ?: ""
                binding.nameTextView.text = "Здравствуйте $name"
            }

            override fun onCancelled(error: DatabaseError) {
                // Обработка ошибки чтения данных
            }
        })


        checkAndUpdateOrderStatus()
        database.reference.child("Users")
            .child(auth.currentUser!!.uid)
            .child("orderStatus")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val orderStatus = dataSnapshot.getValue(String::class.java)
                    binding.textViewOrder.text = orderStatus ?: "Есть активный заказ"
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Обработка ошибок
                }
            })





        val userRef = FirebaseDatabase.getInstance().reference
            .child("Users")
            .child(auth.currentUser?.uid ?: "")

        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.value as? Map<*, *>
                user?.let {
                    val phoneNumber = user["Телефон"] as? String
                    val city = user["город"] as? String
                    val street = user["улица"] as? String
                    val house = user["дом"] as? String
                    val apartment = user["квартира"] as? String

                    binding.phoneNumberTextView.text = "Ваш телефон: $phoneNumber"
                    binding.cityTextView.text = "Ваш город: $city"
                    binding.streetTextView.text = "Ваша улица: $street"
                    binding.houseTextView.text = "Ваш номер дома: $house"
                    binding.apartmentTextView.text = "Ваша квартира: $apartment"
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


        if (auth.currentUser != null) {
            binding.loginButton.visibility = View.GONE
            binding.buttonChangeData.visibility = View.VISIBLE
            binding.nameTextView.visibility = View.VISIBLE
            (activity as? MainActivity)?.setBottomAppBarVisibility(true)
        } else {
            binding.textViewOrders.visibility = View.GONE
            binding.loginButton.visibility = View.VISIBLE
            binding.buttonChangeData.visibility = View.GONE
            binding.buttonExit.visibility = View.GONE
            binding.phoneNumberTextView.visibility = View.GONE
            binding.cityTextView.visibility = View.GONE
            binding.streetTextView.visibility = View.GONE
            binding.houseTextView.visibility = View.GONE
            binding.apartmentTextView.visibility = View.GONE
            binding.dataTextView.visibility = View.GONE
            (activity as? MainActivity)?.setBottomAppBarVisibility(false)
            binding.loginButton.setOnClickListener {
                val intent = Intent(activity, Login::class.java)
                activity?.startActivity(intent)
            }
        }

        binding.buttonChangeData.setOnClickListener {
            val profileData = ProfileData()
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.container, profileData)
                .addToBackStack(null)
                .commit()

        }
        binding.buttonExit.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val editor = sharedPreferences.edit()
            editor.putBoolean("isUserLoggedIn", false)
            editor.apply()
            val intent = Intent(activity, Login::class.java)
            startActivity(intent)
            // закрываем текущую активность, чтобы пользователь не мог вернуться на экран профиля по кнопке "Назад"
            activity?.finish()
        }


    }

    private fun checkAndUpdateOrderStatus() {

        orderStatusRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val orderStatus = dataSnapshot.getValue(String::class.java)
                if (orderStatus == "Есть активный заказ") {
                    val orderCreationTimeRef = database.getReference("Users")
                        .child(auth.currentUser!!.uid)
                        .child("orderCreationTime")

                    orderCreationTimeRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(timeSnapshot: DataSnapshot) {
                            val orderCreationTime = timeSnapshot.getValue(Long::class.java)
                            if (orderCreationTime != null && isOrderExpired(orderCreationTime)) {
                                // Обновить статус заказа на "Доставлено"
                                orderStatusRef.setValue("Доставлено")
                            }
                        }

                        private fun isOrderExpired(orderCreationTime: Long): Boolean {
                            val currentTime = System.currentTimeMillis()
                            val threeHoursInMillis = 3 * 60 * 60 * 1000
                            return currentTime - orderCreationTime > threeHoursInMillis
                        }

                        override fun onCancelled(error: DatabaseError) {
                            // Обработка ошибок
                        }
                    })
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Обработка ошибок
            }
        })
    }


    }

