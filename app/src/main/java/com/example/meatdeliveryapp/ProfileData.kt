package com.example.meatdeliveryapp

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
import com.example.meatdeliveryapp.databinding.FragmentProfileDataBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class ProfileData : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private val prefFileName = "MyPrefs"
    private lateinit var binding: FragmentProfileDataBinding
    private var singletonLogin = SingletonLogin
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileDataBinding.inflate(inflater)
        sharedPreferences =
            requireActivity().getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val isUserLoggedIn = sharedPreferences.getBoolean("isUserLoggedIn", false)

        val nameRef = FirebaseDatabase.getInstance().reference.child("Users").child(
            Firebase.auth.currentUser?.uid ?: ""
        ).child("имя")

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.buttonSave.setOnClickListener {
            val phoneNumber = binding.phoneNumberEditText.text.toString()
            val city = binding.cityEditText.text.toString()
            val street = binding.streetEditText.text.toString()
            val house = binding.houseEditText.text.toString()
            val apartment = binding.apartmentEditText.text.toString()

            val uid = FirebaseAuth.getInstance().currentUser?.uid

            if (uid != null) {
                val userRef = FirebaseDatabase.getInstance().reference
                    .child("Users")
                    .child(uid)



                userRef.child("Телефон").setValue(phoneNumber)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Телефон успешно сохранен", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(
                            activity,
                            "Ошибка при сохранении телефона",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                userRef.child("город").setValue(city)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Город успешно сохранен", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(activity, "Ошибка при сохранении города", Toast.LENGTH_SHORT)
                            .show()
                    }

                userRef.child("улица").setValue(street)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Улица успешно сохранена", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(activity, "Ошибка при сохранении улицы", Toast.LENGTH_SHORT)
                            .show()
                    }

                userRef.child("дом").setValue(house)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Дом успешно сохранен", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(activity, "Ошибка при сохранении дома", Toast.LENGTH_SHORT)
                            .show()
                    }

                userRef.child("квартира").setValue(apartment)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Квартира успешно сохранена", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(
                            activity,
                            "Ошибка при сохранении квартиры",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


            } else {
                binding.phoneNumberEditText.visibility = View.INVISIBLE
                binding.cityEditText.visibility = View.INVISIBLE
                binding.streetEditText.visibility = View.INVISIBLE
                binding.houseEditText.visibility = View.INVISIBLE
                binding.apartmentEditText.visibility = View.INVISIBLE


            }

        }
    }
}