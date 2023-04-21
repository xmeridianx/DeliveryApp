package com.example.meatdeliveryapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meatdeliveryapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityLoginBinding
    private var singletonLogin = SingletonLogin
    private lateinit var sharedPreferences: SharedPreferences
    private val prefFileName = "MyPrefs"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("username", "")
        val savedPassword = sharedPreferences.getString("password", "")


        auth = Firebase.auth
        binding.textViewRegistration.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener {

            val email = binding.editTextLogin
            val password = binding.editTextPassword

            if (email.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show()
            }

            val emailInput = email.text.toString()
            singletonLogin.login = emailInput
            val passwordInput = password.text.toString()

            auth.signInWithEmailAndPassword(emailInput, passwordInput)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        saveCredentials(email.toString(), password.toString())
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(
                            baseContext, "Успешно.",
                            Toast.LENGTH_SHORT
                        ).show()
                        //
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.toString(),
                            password.toString()
                        )
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    // Сохраняем информацию о том, что пользователь авторизован в SharedPreferences
                                    val editor = sharedPreferences.edit()
                                    editor.putBoolean("isUserLoggedIn", true)
                                    editor.apply()
                                    // Обновляем UI для отображения авторизованного пользователя
                                    //(FirebaseAuth.getInstance().currentUser)
                                } else {
                                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        Toast.makeText(
                            baseContext, "Неверный логин или пароль",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

        }
        }
    private fun saveCredentials(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }
}