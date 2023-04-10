package com.enigmacamp.simpleviewmodel.presentation.transaction.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class TransactionRepository {
    var balanceTR = MutableLiveData(0)

    fun handleBuyBalanceTR(buy: Int) {
        balanceTR.postValue(balanceTR.value?.plus(buy))
    }

    fun handleSellBalance(sell: Int): Boolean {
        val currentBalance =  balanceTR.value?:0
        if(currentBalance >= sell) {
            balanceTR.postValue(balanceTR.value?.minus(sell))
            return true
        }
        return false
    }
}