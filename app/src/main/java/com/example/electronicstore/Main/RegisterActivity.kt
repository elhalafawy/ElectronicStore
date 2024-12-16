package com.example.electronicstore.Main

import android.content.Intent
import android.view.View
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.electronicstore.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var registerButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        emailEditText = findViewById(R.id.emailEditText)
        registerButton = findViewById(R.id.registerButton)

        // Set click listener for the register button
        registerButton.setOnClickListener {
            performRegister()
        }
    }

    private fun performRegister() {
        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()

        if (validateInput(username, password, email)) {
            // Show success message
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

            // Navigate to the main activity screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close current activity
        }
    }

    private fun validateInput(username: String, password: String, email: String): Boolean {
        return when {
            username.isEmpty() -> {
                usernameEditText.error = "Username is required"
                usernameEditText.requestFocus()
                false
            }
            email.isEmpty() -> {
                emailEditText.error = "Email is required"
                emailEditText.requestFocus()
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                emailEditText.error = "Enter a valid email address"
                emailEditText.requestFocus()
                false
            }
            password.isEmpty() -> {
                passwordEditText.error = "Password is required"
                passwordEditText.requestFocus()
                false
            }
            password.length < 6 -> {
                passwordEditText.error = "Password must be at least 6 characters"
                passwordEditText.requestFocus()
                false
            }
            else -> true
        }
    }

    fun onLoginClick(view: View) {
        // Navigate to the login screen
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
