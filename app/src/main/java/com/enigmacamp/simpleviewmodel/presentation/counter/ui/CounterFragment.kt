package com.enigmacamp.simpleviewmodel.presentation.counter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.simpleviewmodel.presentation.counter.CounterVM
import com.enigmacamp.simpleviewmodel.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {
    lateinit var binding: FragmentCounterBinding
    lateinit var viewModel: CounterVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // disini dia ngesetViewnya, jadi viewModel ditaroh di onCreate lebih recomended
//        viewModel = ViewModelProvider(requireActivity())[CounterVM::class.java] //
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.apply {
            textViewCounter.text = viewModel.counterVm.toString()

            btnIncrement.setOnClickListener {
                viewModel.increment()
                textViewCounter.text = viewModel.counterVm.toString()
            }
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CounterVM() as T
            }
        })[CounterVM::class.java]
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CounterFragment()
    }
}