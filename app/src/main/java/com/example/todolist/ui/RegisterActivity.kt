package com.example.todolist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolist.R
import com.example.todolist.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }


    private fun initListeners() {
        binding.btnNavigateToLogin.setOnClickListener {
            navigateToLogin()
        }

        binding.btnRegister.setOnClickListener {
            register()
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun register() {
        if(validateFields()) {
            // Registrar el usuario

        } else {
            Toast.makeText(this, "Porfavor complete los campos", Toast.LENGTH_SHORT)
        }
    }

    private fun validateFields(): Boolean {
        with(binding) {
            return if(etPassword.text.isBlank() || etUsername.text.isBlank()) {
                false
            }
            else {
                true
            }
        }
    }
}