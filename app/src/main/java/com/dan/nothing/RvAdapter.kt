package com.dan.nothing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RvAdapter(var list:List<ODCatogory>, val rvUtil: RvUtil): RecyclerView.Adapter<RvAdapter.TilleView>() {
    // class Viewholder
    inner class TilleView(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TilleView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_category, parent,false)
        return TilleView(view)
    }

    override fun onBindViewHolder(holder: TilleView, position: Int) {
        holder.itemView.apply {
            val image = findViewById<ImageView>(R.id.imgRvItemType)
            val title = findViewById<TextView>(R.id.txtRvItemType)
            val desc = findViewById<TextView>(R.id.txtRvItemTypeDesc)

            title.text = list[position].title
            desc.text = list[position].descripl
            Glide.with(context).load(list[position].image).into(image)

            // lắng nghe item click chọn
            holder.itemView.setOnClickListener {
                rvUtil.OnClickTitle(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}