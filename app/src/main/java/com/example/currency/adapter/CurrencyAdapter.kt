package com.example.currency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.data.CurrencyListResponse
import com.example.currency.databinding.ItemCurrencyBinding

class CurrencyAdapter(val list: List<CurrencyListResponse.Valute>) :
    RecyclerView.Adapter<CurrencyAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val list = list[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemCurrencyBinding.bind(itemView)

        fun bind(item: CurrencyListResponse.Valute) {
            with(binding) {

                charCode.text = item.char_code
                nominal.text = item.nominal
                name.text = item.name
                value.text = item.value
                val values = item.value

                val value = item.value.toString().toFloat()
                val des = (Math.round(value * 100.0) / 100.0).toString()
                values.setText("₽"+" "+des)
            }
        }
    }
}