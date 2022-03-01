package com.example.currency

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.Nullable
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.adapter.CurrencyAdapter
import com.example.currency.retrofit.CurrencyApp
import com.example.currency.retrofit.CurrencyListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomeFragment : Fragment(R.layout.home_fragment) {

    private val LIST_STATE_KEY = "recycler_state"
    private var recyclerViewState : Parcelable? = null
    private lateinit var recyclerView: RecyclerView


    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            recyclerViewState = savedInstanceState.getParcelable(LIST_STATE_KEY)
        }


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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(LIST_STATE_KEY, recyclerView.layoutManager?.onSaveInstanceState())
    }

    @SuppressLint("NotifyDataSetChanged")
        override fun onResume() {
            super.onResume()
            if (recyclerViewState != null) {
                recyclerView.layoutManager?.onRestoreInstanceState(recyclerViewState)
                recyclerView.adapter?.notifyDataSetChanged()
            }


    }


}



