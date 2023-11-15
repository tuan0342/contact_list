package com.example.contactapp

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.databinding.ContactDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ContactDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactDetailBinding.inflate(layoutInflater)
//        setContentView(R.layout.contact_detail)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val avt = intent.getStringExtra("avt")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        binding.avtDetail.text = avt
        binding.nameDetail.text = name
        binding.emailDetail.text = email
        binding.phoneDetail.text = phone
    }
}