package com.example.recyclerclicklistener.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerclicklistener.R
import com.example.recyclerclicklistener.data.Food

class FoodAdapter(private val foodList: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    var onItemClick: ((Food) -> Unit)? = null

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_items, parent, false)

        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.apply {
            imageView.setImageResource(food.image)
            textView.text = food.name

            //detailActivity
            itemView.setOnClickListener {
                onItemClick?.invoke(food)
            }

        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}