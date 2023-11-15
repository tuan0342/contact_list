package com.example.contactapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val items = arrayListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)

        setContentView(binding.root)

        items.add(ItemModel("N", "Ngô Văn Tuấn", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("B", "Bố", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("M", "Mẹ", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("C", "Cậu", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("M", "Mợ", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("C", "Cô", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("C","Chú", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("A", "Anh Trai", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("E", "Em Gái", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("C", "Cháu", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));
        items.add(ItemModel("C", "Chị Giá", "tuan.nv200559@sis.hust.edu.vn", "0988893728"));

        binding.recyclerView1.isClickable = true
        binding.recyclerView1.adapter = MyAdapter(this, items)
        registerForContextMenu(binding.recyclerView1)

        binding.recyclerView1.setOnItemClickListener { parent, view, position, id ->
            val name = items[position].name
            val avt = items[position].avatar
            val email = items[position].email
            val phone = items[position].phone

            val i = Intent(this, DetailActivity:: class.java)
            i.putExtra("name", name)
            i.putExtra("avt", avt)
            i.putExtra("email", email)
            i.putExtra("phone", phone)
            startActivity(i)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.sub_menu, menu)

    }
}