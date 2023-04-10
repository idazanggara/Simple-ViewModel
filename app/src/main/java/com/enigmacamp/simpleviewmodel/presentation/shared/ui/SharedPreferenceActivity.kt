package com.enigmacamp.simpleviewmodel.presentation.shared.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enigmacamp.simpleviewmodel.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}