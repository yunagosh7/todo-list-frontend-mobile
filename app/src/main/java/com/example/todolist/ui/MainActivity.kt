package com.example.todolist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolist.R
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(isLogged()) {

        }

        initListeners()
    }

    private fun initListeners() {
        binding.btnNavigateToRegister.setOnClickListener {
            navigateToRegister()
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
    }


    private fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun login() {
        if (validateFields()) {
            // Iniciar sesion
        } else {
            Toast.makeText(this, "Porfavor complete bien los campos", Toast.LENGTH_SHORT)
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

    private fun isLogged(): Boolean {
        // validar la sesion
        return false
    }

}