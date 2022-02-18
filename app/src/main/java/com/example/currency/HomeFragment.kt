package com.example.currency

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.ArrayMap
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.adapter.CurrencyAdapter
import com.example.currency.retrofit.CurrencyApp
import com.example.currency.retrofit.CurrencyListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomeFragment : Fragment(R.layout.home_fragment) {


    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val currencyListViewModel = ViewModelProvider(this).get(CurrencyListViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)


        currencyListViewModel.fetchCurrencyList((requireActivity().application as CurrencyApp).currencyApi)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                recyclerView?.adapter = CurrencyAdapter(it.data.values.toList())
            }, { error ->
                Log.e(HomeFragment::class.simpleName, "Error", error)
            })


    }


}



