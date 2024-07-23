package com.shirishkoirala.layoutmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class ListItemAdapter(private val listItems: List<ListItem>) :
    RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val videoView: VideoView = view.findViewById(R.id.videoView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listItems[position]
        val path =
            "android.resource://" + holder.videoView.context.packageName + "/" + currentItem.video
        holder.videoView.setVideoPath(path)
        holder.videoView.setOnPreparedListener {
            it.start()
            it.isLooping = true
        }
    }
}