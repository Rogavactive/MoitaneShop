package com.example.moitaneshop.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moitaneshop.databinding.ActivityMainBinding
import com.example.moitaneshop.presentation.adapter.ShopItemRecyclerAdapter
import com.example.moitaneshop.presentation.viewmodel.MainPageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: ShopItemRecyclerAdapter = ShopItemRecyclerAdapter()
    private val viewModel: MainPageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerShopList.layoutManager = LinearLayoutManager(this)
        binding.recyclerShopList.adapter = adapter
        initListeners()
        observeLiveData()
        viewModel.getShopList()
        setContentView(binding.root)
    }

    private fun observeLiveData() {
        viewModel.shopListLiveData.observe(this@MainActivity, {
            adapter.setData(it)
        })
    }

    private fun initListeners() {
        binding.viewSearch.setOnTextChangeListener {
            viewModel.filterShops(it)
        }
    }

}