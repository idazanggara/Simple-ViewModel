package com.enigmacamp.simpleviewmodel.presentation.transaction.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.enigmacamp.simpleviewmodel.R
import com.enigmacamp.simpleviewmodel.databinding.ActivityTransactionBinding

class TransactionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTransactionBinding
    private lateinit var balanceFragment: BalanceFragment
    private lateinit var transactionFragment: TransactionFragment
    private  var balanceAc = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        balanceFragment = BalanceFragment()
        transactionFragment = TransactionFragment()
//        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,transactionFragment).commit()

        binding.apply {
            btnTransactionFM.setOnClickListener {
                fragment(transactionFragment)
            }
            btnBalanceFM.setOnClickListener {
                fragment(balanceFragment)
            }
        }

    }
    private fun fragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(R.id.fragmentContainer,fragment).commit()
    }

//    fun handleBuy(stock: Int) {
//        balanceAc += stock
//        balanceFragment.updateBalance(balanceAc)
//    }
//
//    fun handleSell(stock: Int) {
//        balanceAc -= stock
//        balanceFragment.updateBalance(balanceAc)
//    }


}