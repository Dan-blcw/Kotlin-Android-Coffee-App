package com.dan.nothing

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.dan.nothing.databinding.ActivityDetailItemBinding
import com.dan.nothing.databinding.CustomBuyItemBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityDetailItemBinding
class Det : AppCompatActivity() {
//    companion object{
//        val listCart = mutableListOf<Int>()
//    }
    lateinit var diolog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buildDetailItem()
        buildBuyNow()
    }

    private fun buildBuyNow() {
        binding.btnBuy.setOnClickListener {
            val build = AlertDialog.Builder(this,R.style.ThemeCustom)
            val diologBinding = CustomBuyItemBinding.inflate(LayoutInflater.from(this))
            build.setView(diologBinding.root)
            val id = intent.getIntExtra("id",0)
            val oj = const.findByID(id)
            diologBinding.txtBuyTil.setText(oj?.title)
            Glide.with(applicationContext).load(oj?.image).into(diologBinding.imgBuy)
            diologBinding.btnExitimg.setOnClickListener { diolog.dismiss() }
            diologBinding.btnOrder.setOnClickListener{
//                Toast.makeText(this@Det,"You just click on Order", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Det,CartMenu::class.java)
//                listCart.add(id)
                startActivity(intent)

            }
            diologBinding.btnCartImg.setOnClickListener {
                Toast.makeText(this@Det,"You just click on add cart", Toast.LENGTH_SHORT).show()
//                listCart.add(id)

            }
            diolog = build.create()
            diolog.show()
        }
    }

    private fun buildDetailItem() {
        val id = intent.getIntExtra("id",0)
        val oj = const.findByID(id)
        binding.btnExitDetail.setOnClickListener {
            val intent = Intent(this@Det,Home::class.java)
            startActivity(intent)
        }
        binding.txtDetailTit.setText(oj?.title)
        binding.txtDescrip0.setText(oj?.ingredients)
        binding.txtDescrip1.setText(oj?.recipe)
        binding.txtDescrip2.setText(oj?.instructions)
        binding.txtPrice.setText("Just ${oj?.price}")
        Glide.with(applicationContext).load(oj?.image).into(binding.imgDetail)
    }
}