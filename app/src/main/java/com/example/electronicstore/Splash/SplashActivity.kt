package com.example.electronicstore.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.electronicstore.Main.MainActivity
import com.example.electronicstore.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Start the home screen after a delay
        startHomeScreen()
    }

    private fun startHomeScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Ensures the splash screen is removed from the back stack
        }, 1500) // Delay of 1.5 seconds
    }
}
