package com.dan.nothing

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dan.nothing.databinding.ActivityCartMenuBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityCartMenuBinding
class CartMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}