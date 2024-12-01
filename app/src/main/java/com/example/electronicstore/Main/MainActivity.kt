package com.example.electronicstore.Main

import android.os.Bundle
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.electronicstore.R
import com.example.electronicstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener {
            val home=R.id.home
            val icon =R.drawable.home

            if(it.itemId==home){



                supportFragmentManager.beginTransaction()
                    .replace(R.id.container,HomeFragment())
                    .commit()

            }
            else if(it.itemId==R.id.cart){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container,CartFragment())
                    .commit()


            }
            else if(it.itemId==R.id.setting){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container,SettingFragment())
                    .commit()

            }



            return@setOnItemSelectedListener true

        }

    }
}