package com.dan.nothing

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dan.nothing.adapter.Util_demo
import com.dan.nothing.databinding.ActivityCartMenuBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityCartMenuBinding
class CartMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buildCartMenu()

        buildButton()
    }

    private fun buildButton() {
        binding.btnCartHome.setOnClickListener {
            val toHome = Intent(this@CartMenu,Home::class.java)
            startActivity(toHome)
        }
        binding.btnCartPay.setOnClickListener {
            Toast.makeText(this@CartMenu,"You just click on Pay",Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
        private fun buildCartMenu() {
            val list = const.listCart
            val rvAdapter = CartAdapter(list,object: Util_demo{
                override fun OnClickTitle(pos: Int) {
                    Toast.makeText(
                        this@CartMenu,
                        "Click ${list[pos].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            },)
            binding.rvListCart.adapter = rvAdapter
            binding.rvListCart.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
            binding.txtCartPay.setText("Total amount:      ${const.payments}$")
        }
}