package com.dan.nothing

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.dan.nothing.databinding.ActivityPersonBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityPersonBinding
class Person : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComeback.setOnClickListener {
            val comback = Intent(this,Home::class.java)
            startActivity(comback)
            finish()
        }
    }


}