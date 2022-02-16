package com.example.currency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.model_data.CurrencyListResponse

class CurrencyAdapter( var arrayList: ArrayList<CurrencyListResponse.CurrencyListItem>) :
    RecyclerView.Adapter<CurrencyAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val currencyListItem = arrayList[position]
        holder.bind(currencyListItem)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: CurrencyListResponse.CurrencyListItem) {
            with(itemView) {

                findViewById<TextView>(R.id.char_code).text = item.char_code
                findViewById<TextView>(R.id.nominal).text = item.nominal
                findViewById<TextView>(R.id.name).text = item.name
                findViewById<TextView>(R.id.value).text = item.value


                findViewById<CardView>(R.id.cardview).elevation = 0f
            }
        }
    }
}