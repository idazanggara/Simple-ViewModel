package com.enigmacamp.simpleviewmodel.presentation.transaction

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enigmacamp.simpleviewmodel.presentation.transaction.repository.TransactionRepository

class TransactionVM(application: Application) : AndroidViewModel(application)  {
    private val repository = TransactionRepository()
    var balanceLD = repository.balanceTR
    // var balanceLD = MutableLiveData(0)


    fun handleBuyVM(buy: Int) {
        // balanceLD.postValue(balanceLD.value?.plus(buy))
        repository.handleBuyBalanceTR(buy)

    }
    fun handleSellVM(sell: Int) {
//        val currentBalance =  balanceLD.value?:0
//        if(currentBalance >= sell) {
//            balanceLD.postValue(balanceLD.value?.minus(sell))
//        } else {
//            Toast.makeText(getApplication<Application>(), "Nilai Tidak Boleh Dari 0", Toast.LENGTH_SHORT).show()
//        }
        val currentBalance =  repository.handleSellBalance(sell)
        if (!currentBalance) {
            Toast.makeText(getApplication<Application>(), "Nilai Tidak Boleh Dari 0", Toast.LENGTH_SHORT).show()

        }
    }

}