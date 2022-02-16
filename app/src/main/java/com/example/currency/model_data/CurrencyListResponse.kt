package com.example.currency.model_data

import com.google.gson.annotations.SerializedName

class CurrencyListResponse(val quotes: List<CurrencyListItem>) {

    data class CurrencyListItem(
        @SerializedName("CharCode")
        var char_code: String?,

        @SerializedName("Nominal")
        var nominal: String?,

        @SerializedName("Name")
        var name: String?,

        @SerializedName("Value")
        var value: String?

    )
}