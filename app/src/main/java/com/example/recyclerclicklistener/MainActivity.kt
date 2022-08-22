package com.example.recyclerclicklistener

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerclicklistener.adapter.FoodAdapter
import com.example.recyclerclicklistener.data.Food

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setupRecyclerView
        apply {
            recyclerView = findViewById(R.id.layout_recyclerView)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this)

            foodList = ArrayList()

            //setupFoodList
            foodList.add(Food(R.drawable.a, "ต้มจิด"))
            foodList.add(Food(R.drawable.b, "สามชั้นทอด"))
            foodList.add(Food(R.drawable.c, "น้ำพริกอ่อง"))
            foodList.add(Food(R.drawable.d, "ต้มยำกุ้ง"))
            foodList.add(Food(R.drawable.e, "กระเพรา"))
            foodList.add(Food(R.drawable.f, "ผัดผัก"))
            foodList.add(Food(R.drawable.g, "ลาบ"))
            foodList.add(Food(R.drawable.h, "ยำ"))
            foodList.add(Food(R.drawable.j, "ข้าวผัด"))
            foodList.add(Food(R.drawable.k, "แกงส้ม"))

            foodAdapter = FoodAdapter(foodList)
            recyclerView.adapter = foodAdapter

            //onClick
            foodAdapter.onItemClick = {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("food", it)
                startActivity(intent)
            }
        }
    }
}