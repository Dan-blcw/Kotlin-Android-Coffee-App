package com.dan.nothing

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dan.nothing.adapter2.OD
import com.dan.nothing.adapter2.Util_demo

class CartAdapter(var list:List<OD>, val util: Util_demo): RecyclerView.Adapter<CartAdapter.TilleView>() {
    // class Viewholder
    inner class TilleView(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TilleView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent,false)
        return TilleView(view)
    }

    @SuppressLint("WrongViewCast")
    override fun onBindViewHolder(holder: TilleView, position: Int) {
        holder.itemView.apply {

            val image = findViewById<ImageView>(R.id.imgCartItem)
            val title = findViewById<TextView>(R.id.txtCartItemTitle)
            val desc = findViewById<TextView>(R.id.txtCartItemCategory)
            val size = findViewById<TextView>(R.id.txtCartItemSize)
            val status = findViewById<TextView>(R.id.txtCartItemStatus)
            val price = findViewById<TextView>(R.id.txtcartItemBuy)

            val btnClose = findViewById<ImageButton>(R.id.btn_close_cart)
            val btnPrice = findViewById<ImageButton>(R.id.btn_change_cart)

            title.text = list[position].title
            desc.text = list[position].category
            size.text = list[position].size
            status.text = list[position].status
            price.text = "${list[position].price}$"
            Glide.with(context).load(list[position].image).into(image)

            // lắng nghe item click chọn
            holder.itemView.setOnClickListener {
                util.OnClickTitle(position)
            }
            btnClose.setOnClickListener{
                Toast.makeText(context,"Close",Toast.LENGTH_SHORT).show()
                const.subByID(list[position].idItem)
                const.payments = const.payments - list[position].price
            }
            btnPrice.setOnClickListener{
                Toast.makeText(context,"Change",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
