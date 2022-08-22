package com.example.recyclerclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerclicklistener.data.Food

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val food = intent.getParcelableExtra<Food>("food")
        if (food != null) {
            val textView: TextView = findViewById(R.id.textViewDetail)
            val imageView: ImageView = findViewById(R.id.imageViewDetail)

            textView.text = food.name
            imageView.setImageResource(food.image)
        }
    }
}