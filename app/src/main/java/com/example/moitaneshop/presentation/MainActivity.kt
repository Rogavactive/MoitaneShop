package com.example.moitaneshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.moitaneshop.R
import com.example.moitaneshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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