package com.enigmacamp.simpleviewmodel.presentation.transaction.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.simpleviewmodel.databinding.FragmentBalanceBinding
import com.enigmacamp.simpleviewmodel.presentation.transaction.TransactionVM

class BalanceFragment : Fragment() {
//    var balance :Int = 0
    private lateinit var binding: FragmentBalanceBinding
    private lateinit var transactionVM: TransactionVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        transactionVM = ViewModelProvider(requireActivity())[TransactionVM::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBalanceBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.textViewResult.text = balance.toString()
        transactionVM.balanceLD.observe(viewLifecycleOwner, Observer {
            binding.textViewResult.text = it.toString()
        })
    }

//    fun updateBalance(balance: Int) {
//        this.balance = balance
//    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = BalanceFragment()
    }
}