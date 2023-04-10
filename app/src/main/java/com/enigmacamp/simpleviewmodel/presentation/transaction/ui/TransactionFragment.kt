package com.enigmacamp.simpleviewmodel.presentation.transaction.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.simpleviewmodel.databinding.FragmentTransactionBinding
import com.enigmacamp.simpleviewmodel.presentation.transaction.TransactionVM

class TransactionFragment : Fragment() {
    private lateinit var binding: FragmentTransactionBinding
    private lateinit var transactionVM: TransactionVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transactionVM = ViewModelProvider(requireActivity())[TransactionVM::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var activity = activity as TransactionActivity
        binding.apply {
            buttonBuy.setOnClickListener {
//                activity.handleBuy(editTextTransaction.text.toString().toInt())
                transactionVM.handleBuyVM(editTextTransaction.text.toString().toInt())
            }
            buttonSell.setOnClickListener {
//                activity.handleSell(editTextTransaction.text.toString().toInt())
                transactionVM.handleSellVM(editTextTransaction.text.toString().toInt())
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = TransactionFragment()
    }
}