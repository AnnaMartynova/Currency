package com.example.currency.retrofit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.currency.data.CurrencyListResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class CurrencyListViewModel(application: Application): AndroidViewModel(application) {


    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun fetchCurrencyList(currencyApi: CurrencyApi): Single<CurrencyListResponse> {
        return currencyApi.getCurrencyList()
    }
}