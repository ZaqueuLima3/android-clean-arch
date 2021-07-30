package com.maker.cleanandroid.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maker.cleanandroid.databinding.ActivityMainBinding
import com.maker.cleanandroid.main.factories.AppFragmentFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAppFragmentFactory()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupAppFragmentFactory() {
        supportFragmentManager.fragmentFactory = AppFragmentFactory()
    }
}
