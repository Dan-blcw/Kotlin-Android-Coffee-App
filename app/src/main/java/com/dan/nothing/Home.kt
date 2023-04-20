package com.dan.nothing

import android.annotation.SuppressLint
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
    }

    private fun buildRVCategoryItems(id: Int?) {
        var list = mutableListOf<OD>()
        if (id == 1 || id == null){
            list.add(OD(1, "https://i.pinimg.com/736x/51/55/9f/51559fe844a31f64ddf1c8f5c4bcdeed.jpg", "Eiskaffee ", "10$"))
            list.add(OD(1, "https://i.pinimg.com/736x/f8/ad/b1/f8adb1dffd0c001f8627afc9c2d043d3.jpg", "Whipped Coffee", "8$"))
            list.add(OD(1, "https://i.pinimg.com/564x/9f/4d/86/9f4d8601885faf1bc06ec50674d52a9c.jpg", "Coffee Cream", "4$"))
            list.add(OD(1, "https://i.pinimg.com/564x/49/a5/a6/49a5a6176829b484ea0ffa635c368ae4.jpg", "Iced Espresso", "20$"))
        }else if(id == 2){
            list.add(OD(2, "https://i.pinimg.com/564x/87/ad/79/87ad791d2fe1d1cc3f88b017a67af60f.jpg", "Frozen fruit", "1$"))
            list.add(OD(2, "https://i.pinimg.com/564x/b6/32/39/b632397869d81c8062e0f6de348520b7.jpg", "Mint Refreshers", "10$"))
            list.add(OD(2, "https://i.pinimg.com/564x/7b/bd/fa/7bbdfa5280f3a3e60f1ccabef69a513c.jpg", "PineappleCoconut", "8$"))
            list.add(OD(2, "https://i.pinimg.com/564x/ee/3c/58/ee3c58a30dace6e1f327c55a35fabaec.jpg", "Red Mint", "2$"))
        }else if(id == 3){
            list.add(OD(3, "https://i.pinimg.com/564x/c9/56/85/c9568529f010530eaf845ecc6a1f3217.jpg", "Grapes cake", "7$"))
            list.add(OD(3, "https://i.pinimg.com/564x/b0/4e/cb/b04ecb0234ab75a7ffd0a12ca0e27140.jpg", "Black chocolate", "31$"))
            list.add(OD(3, "https://i.pinimg.com/564x/63/4a/c3/634ac30ca8120de22c3f825511bff69b.jpg", "Chocolate Chessecake", "16$"))
            list.add(OD(3, "https://i.pinimg.com/564x/27/10/e1/2710e153e551e5d86c59dca544f832b6.jpg", "cream strawberry", "40$"))
        }else if(id == 4){
            list.add(OD(3, "https://i.pinimg.com/564x/35/8e/86/358e864f14af16778ca1cffbbbee1870.jpg", "Lychee Iced Tea", "4$"))
            list.add(OD(3, "https://i.pinimg.com/564x/cb/d4/34/cbd4345e78317665535b255501ee3945.jpg", "Lavender Black Iced ", "28$"))
            list.add(OD(3, "https://i.pinimg.com/564x/a3/5f/6f/a35f6ff6f00e1ae2b01bafb9873296e7.jpg", "Iced Peach Green ", "18$"))
            list.add(OD(3, "https://i.pinimg.com/564x/84/c3/0d/84c30d782d3b2bd923456acd5b5b0786.jpg", "Iced Lemon Tea", "42$"))
        }
        val rvAdapter = RvAdapterOD(list,object: Util_demo{
            override fun OnClickTitle(pos: Int) {
                Toast.makeText(
                    this@Home,
                    "Click ${list[pos].title}",
                    Toast.LENGTH_SHORT
                ).show()
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
        val list = mutableListOf<OutDataRecycler>()
        list.add(OutDataRecycler(1,"https://i.pinimg.com/564x/60/37/43/6037438a8f699e55db62750b688f3217.jpg","Coffee","just order 1 cup of coffee, it will help you be more productive"))
        list.add(OutDataRecycler(2,"https://i.pinimg.com/736x/c9/f9/f7/c9f9f7be07bb347317971cb85812f930.jpg","Smoothies","A little bit of freshness?"))
        list.add(OutDataRecycler(3,"https://i.pinimg.com/736x/3f/d3/1e/3fd31e00dc228fba12823cb9b1cc3604.jpg","Desserts","Are you hungry and need some snacks?"))
        list.add(OutDataRecycler(4,"https://i.pinimg.com/564x/41/d7/d5/41d7d595031141c25dfb89c77092267e.jpg", "Tea","Do you like warmth and serenity?It will make you feel better"))

        val rvAdapter = RvAdapter(list,object: RvUtil{
            override fun OnClickTitle(pos: Int) {
                Toast.makeText(
                    this@Home,
                    "Click ${list[pos].title}",
                    Toast.LENGTH_SHORT
                ).show()
                buildRVCategoryItems(list[pos].id)
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