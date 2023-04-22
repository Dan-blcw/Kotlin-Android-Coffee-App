package com.dan.nothing

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dan.nothing.adapter2.OD
import com.dan.nothing.adapter2.RvAdapterOD
import com.dan.nothing.adapter2.Util_demo
import com.dan.nothing.databinding.ActivityHomeBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityHomeBinding
class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buildRVCategoryItems(null)
//        binding.textView3.setText("Some of the best selling drinks")
        buildRVCategory()

        buildIntent()

    }



    private fun buildIntent() {
        binding.btnCartHome.setOnClickListener {
            val intent = Intent(this@Home,CartMenu::class.java)
            startActivity(intent)
        }
        binding.btnPersonHome.setOnClickListener {
            val intent = Intent(this@Home,Person::class.java)
            startActivity(intent)
        }
    }

    private fun buildRVCategoryItems(type: String?) {
        val list = mutableListOf<OD>()
        if (type == "Coffee" || type == null){
            list.add(const.ojItem0)
            list.add(const.ojItem1)
            list.add(const.ojItem2)
            list.add(const.ojItem3)
        }else if(type == "Smoothies"){
            list.add(const.ojItem4)
            list.add(const.ojItem5)
            list.add(const.ojItem6)
            list.add(const.ojItem7)
        }else if(type == "Desserts"){
            list.add(const.ojItem8)
            list.add(const.ojItem9)
            list.add(const.ojItem10)
            list.add(const.ojItem11)
        }else if(type == "Tea"){
            list.add(const.ojItem12)
            list.add(const.ojItem13)
            list.add(const.ojItem14)
            list.add(const.ojItem15)
        }
        val rvAdapter = RvAdapterOD(list,object: Util_demo{
            override fun OnClickTitle(pos: Int) {
                Toast.makeText(
                    this@Home,
                    "Click ${list[pos].title}",
                    Toast.LENGTH_SHORT
                ).show()
                val intoDet = Intent(this@Home,Det::class.java)
                intoDet.putExtra("id",list[pos].idItem)
                startActivity(intoDet)
            }
        })
        binding.rvListItem1.adapter = rvAdapter
        binding.rvListItem1.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )    }

    @SuppressLint("SetTextI18n")
    private fun buildRVCategory() {
        val list = mutableListOf<ODCatogory>()
        list.add(const.ojCategory0)
        list.add(const.ojCategory1)
        list.add(const.ojCategory2)
        list.add(const.ojCategory3)
        val rvAdapter = RvAdapter(list,object: RvUtil{
            override fun OnClickTitle(pos: Int) {
                Toast.makeText(
                    this@Home,
                    "Click ${list[pos].title}",
                    Toast.LENGTH_SHORT
                ).show()
                buildRVCategoryItems(list[pos].title)
            }

        })
        binding.rvListItem0.adapter = rvAdapter
        binding.rvListItem0.layoutManager = GridLayoutManager(
            this,
            2,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}