package com.example.moitaneshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moitaneshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: ShopItemRecyclerAdapter = ShopItemRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerShopList.layoutManager = LinearLayoutManager(this)
        binding.recyclerShopList.adapter = adapter
        initListeners()
        setContentView(binding.root)
    }

    private fun initListeners() {
        binding.viewSearch.setOnTextChangeListener{
            // TODO: Filter shops here.
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

}