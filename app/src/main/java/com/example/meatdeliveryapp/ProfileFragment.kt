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
import com.example.meatdeliveryapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private val prefFileName = "MyPrefs"
    private lateinit var binding : FragmentProfileBinding
    private var singletonLogin = SingletonLogin
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        sharedPreferences = requireActivity().getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        return binding.root

    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val isUserLoggedIn = sharedPreferences.getBoolean("isUserLoggedIn", false)

        val nameRef = FirebaseDatabase.getInstance().reference.child("Users").child(
            Firebase.auth.currentUser?.uid ?: ""
        ).child("имя")


        nameRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val name = snapshot.value as? String ?: ""
                binding.nameTextView.text = "Здравствуйте, $name"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


        if (FirebaseAuth.getInstance().currentUser != null) {
            binding.nameTextView.text = "Здравствуйте, ${nameRef}"
            binding.loginButton.visibility = View.INVISIBLE// Скрываем кнопку авторизации

        } else {
            // Если пользователь еще не вошел, предлагаем ему авторизацию
            binding.nameTextView.text = getString(R.string.not_logged_in)
            binding.loginButton.visibility = View.VISIBLE // Показываем кнопку авторизации
            binding.loginButton.setOnClickListener {
                val intent = Intent(activity, Login::class.java)
                activity?.startActivity(intent)
            }
        }
        if (FirebaseAuth.getInstance().currentUser == null) {
            binding.buttonExit.visibility = View.GONE

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







    companion object {

        @JvmStatic
        fun newInstance() =
            ProfileFragment()
    }
}