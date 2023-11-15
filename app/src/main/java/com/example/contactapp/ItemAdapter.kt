package com.example.contactapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val items: ArrayList<ItemModel>): RecyclerView.Adapter<ItemAdapter.RVItemViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return RVItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.avt.text = items[position].avatar
    }

    class RVItemViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val avt: TextView
        init {
            avt = itemView.findViewById(R.id.avt)
            name = itemView.findViewById(R.id.name)
        }
    }
}