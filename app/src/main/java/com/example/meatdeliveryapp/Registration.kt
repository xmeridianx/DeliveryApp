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
            val confirmPassword = binding.editTextRegistrationPasswordConfirm
            if (email.text.isEmpty() || password.text.isEmpty() || confirmPassword.text.isEmpty()) {
                Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show()
            }
            val inputEmail = email.text.toString()
            val inputPassword = password.text.toString()
            val inputConfirmPassword = confirmPassword.text.toString()

            if (inputPassword != inputConfirmPassword) {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        ref.child("Users").child(auth.currentUser!!.uid)
                            .child("email")
                            .setValue(email.getText().toString())
                        /*ref.child("Users").child(auth.getCurrentUser()!!.getUid())
                            .child("password")
                            .setValue(password.getText().toString())

                         */

                        ref.child("Users").child(auth.getCurrentUser()!!.getUid())
                            .child("Orders").setValue("Нет заказов")

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