package com.example.electronicstore.Main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.electronicstore.R

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Make sure this matches your layout file

        // Set click listener for the login button
        loginButton.setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Here you can add your login logic (e.g., API call, validation, etc.)
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
        } else {
            // For demonstration, we will just show a success message
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java) // Navigate to the main activity
            startActivity(intent)
            finish()
        }
    }

    fun onRegisterClick(view: View) {
        // Navigate to the registration screen
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
