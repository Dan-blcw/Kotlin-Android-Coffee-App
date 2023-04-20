package com.dan.nothing.adapter2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dan.nothing.R

class RvAdapterOD(var list:List<OD>, val util: Util_demo): RecyclerView.Adapter<RvAdapterOD.TilleView>() {
    // class Viewholder
    inner class TilleView(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TilleView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_typ, parent,false)
        return TilleView(view)
    }

    override fun onBindViewHolder(holder: TilleView, position: Int) {
        holder.itemView.apply {
            val image = findViewById<ImageView>(R.id.imgRvItem2)
            val title = findViewById<TextView>(R.id.txtRvItem1_2)
            val price = findViewById<TextView>(R.id.txtRvItem2)

            title.text = list[position].title
            price.text = list[position].price
            Glide.with(context).load(list[position].image).into(image)

            // lắng nghe item click chọn
            holder.itemView.setOnClickListener {
                util.OnClickTitle(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}