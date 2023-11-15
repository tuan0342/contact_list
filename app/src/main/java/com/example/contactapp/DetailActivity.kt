package com.example.contactapp

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

//        try {
//            val param1 = intent.getStringExtra("param1")?.toInt()
//            val param2 = intent.getStringExtra("param2")?.toInt()
//            val result = param1!! + param2!!
//
//            val textView = findViewById<TextView>(R.id.textView)
//            textView.text = "Param1: $param1\nParam2: $param2\nResult: $result\n"
//
//            intent.putExtra("result", result)
//
//            setResult(Activity.RESULT_OK, intent)
//        } catch (ex: Exception) {
//            setResult(Activity.RESULT_CANCELED)
//        }
    }
}