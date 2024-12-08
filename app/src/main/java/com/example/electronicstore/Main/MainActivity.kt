package com.example.electronicstore.Main

import android.os.Bundle
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.electronicstore.R
import com.example.electronicstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load HomeFragment as the default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment())
                .commit()
        }

        // Setup Bottom Navigation Listener
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment())
                        .commit()
                }
                R.id.cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CartFragment())
                        .commit()
                }
                R.id.setting -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingFragment())
                        .commit()
                }
            }
            true
        }
    }
}
