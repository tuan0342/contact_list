package com.example.contactapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter(private val context : Activity, private val arrayList: ArrayList<ItemModel>):ArrayAdapter<ItemModel>(context,
    R.layout.contact_item, arrayList)      {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.contact_item,null);
        val avt : TextView = view.findViewById(R.id.avt)
        val name : TextView = view.findViewById(R.id.name)

        avt.text = arrayList[position].avatar
        name.text = arrayList[position].name

        return view
    }
}