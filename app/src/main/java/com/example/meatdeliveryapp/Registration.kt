package com.example.meatdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meatdeliveryapp.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var ref: DatabaseReference
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        database = FirebaseDatabase.getInstance()
        ref = database.reference

        binding.buttonRegistration.setOnClickListener {
            val email = binding.editTextRegistrationLogin
            val password = binding.editTextRegistrationPassword
            val name = binding.editTextRegistrationName
            val phoneNumber = binding.editTextRegistrationPhone
            val city = binding.editTextRegistrationCity
            val street = binding.editTextRegistrationStreet
            val house = binding.editTextRegistrationHouse
            val apartment = binding.editTextRegistrationApartment
            if (email.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show()
            }
            val inputEmail = email.text.toString()
            val inputPassword = password.text.toString()

            auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        ref.child("Users").child(auth.currentUser!!.uid)
                            .child("email")
                            .setValue(email.getText().toString())
                        ref.child("Users").child(auth.getCurrentUser()!!.getUid())
                            .child("password")
                            .setValue(password.getText().toString())
                        ref.child("Users").child(auth.getCurrentUser()!!.getUid()).child("имя")
                            .setValue(name.getText().toString())
                        ref.child("Users").child(auth.getCurrentUser()!!.getUid()).child("Телефон")
                            .setValue(phoneNumber.getText().toString())
                        ref.child("Users").child(auth.getCurrentUser()!!.getUid()).child("город")
                            .setValue(city.getText().toString())
                        ref.child("Users").child(auth.getCurrentUser()!!.getUid()).child("улица")
                            .setValue(street.getText().toString())
                        ref.child("Users").child(auth.getCurrentUser()!!.getUid()).child("дом")
                            .setValue(house.getText().toString())
                        ref.child("Users").child(auth.getCurrentUser()!!.getUid()).child("квартира")
                            .setValue(apartment.getText().toString())
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(
                            baseContext, "Успешно.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            baseContext, "Ошибка.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}