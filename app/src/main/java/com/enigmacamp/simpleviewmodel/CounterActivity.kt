package com.enigmacamp.simpleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.simpleviewmodel.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCounterBinding
    // private lateinit var counterData: CounterData // kita ganti ke ViewModel
    private lateinit var viewModel: CounterVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // counterData = CounterData() // ganti ke ViewModel
//        viewModel = ViewModelProvider(this@CounterActivity).get(CounterVM::class.java) // ini cara lama, seperti array
        viewModel = ViewModelProvider(this@CounterActivity)[CounterVM::class.java] // ini cara terbaru

        binding.apply {
            textViewCounter.text = viewModel.counterVm.toString() // agar setiap onCreate di masukkin nilainya

            btnIncrement.setOnClickListener {
//                viewModel.counterVm++ // kalau pakai ViewModel jangan ada logic
                viewModel.increment()
                textViewCounter.text = viewModel.counterVm.toString()
            }
        }

//        if(savedInstanceState != null){
//            counterData = savedInstanceState.getParcelable("counter_data")!!
//            binding.textViewCounter.text = counterData.counter.toString()
//        } else {
//            counterData = CounterData()
//        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putParcelable("counter_data", counterData)
//    }
}