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

class MainActivity : AppCompatActivity() {

    val items = arrayListOf<ItemModel>()

    var actionMode: ActionMode? = null
    val actionModeCallBack = object: ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.sub_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            if (item?.itemId == R.id.action_call) {
                Log.v("TAG", "Call")
            } else if (item?.itemId == R.id.action_chat) {
                Log.v("TAG", "Chat")
            } else if (item?.itemId == R.id.action_email) {
                Log.v("TAG", "Email")
            }
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(ItemModel("N", "Ngô Văn Tuấn"));
        items.add(ItemModel("B", "Bố"));
        items.add(ItemModel("M", "Mẹ"));
        items.add(ItemModel("C", "Cậu"));
        items.add(ItemModel("M", "Mợ"));
        items.add(ItemModel("C", "Cô"));
        items.add(ItemModel("C","Chú"));
        items.add(ItemModel("A", "Anh Trai"));
        items.add(ItemModel("E", "Em Gái"));
        items.add(ItemModel("C", "Cháu"));
        items.add(ItemModel("C", "Chị Giá"));

        val adapter = ItemAdapter(items)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        registerForContextMenu(findViewById(R.id.recycler_view))
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.sub_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val pos = (item.menuInfo as AdapterView.AdapterContextMenuInfo).position
        if (item.itemId == R.id.action_call) {
            Log.v("TAG1", "Call ${items[pos]}")
        } else if (item.itemId == R.id.action_chat) {
            Log.v("TAG1", "Chat ${items[pos]}")
        } else if (item.itemId == R.id.action_email) {
            Log.v("TAG1", "Email ${items[pos]}")
        }
        return super.onContextItemSelected(item)
    }

}