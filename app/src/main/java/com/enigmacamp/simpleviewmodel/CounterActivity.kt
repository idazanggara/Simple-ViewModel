package com.enigmacamp.simpleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enigmacamp.simpleviewmodel.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCounterBinding
    private lateinit var counterData: CounterData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        counterData = CounterData()

        binding.apply {
            btnIncrement.setOnClickListener {
                counterData.counter++
                textViewCounter.text = counterData.counter.toString()
            }
        }

        if(savedInstanceState != null){
            counterData = savedInstanceState.getParcelable("counter_data")!!
            binding.textViewCounter.text = counterData.counter.toString()
        } else {
            counterData = CounterData()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("counter_data", counterData)
    }
}