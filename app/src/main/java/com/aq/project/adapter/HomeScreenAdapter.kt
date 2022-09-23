package com.aq.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aq.project.databinding.ItemCardBinding

class HomeScreenAdapter(): RecyclerView.Adapter<HomeScreenAdapter.ViewHolder>() {
    private lateinit var binding: ItemCardBinding

    inner class ViewHolder(itemView: ItemCardBinding): RecyclerView.ViewHolder(itemView.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}