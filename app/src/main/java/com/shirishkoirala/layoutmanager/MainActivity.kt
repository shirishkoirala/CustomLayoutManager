package com.shirishkoirala.layoutmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_list)

        recyclerView.adapter = ListItemAdapter(
            listOf(
                ListItem(0, "Item 1", "Description 1", R.raw.video_1),
                ListItem(1, "Item 2", "Description 2", R.raw.video_2),
                ListItem(0, "Item 3", "Description 3", R.raw.video_3),
            )
        )
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.setHasFixedSize(true)
    }
}