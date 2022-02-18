package com.example.currency.data

import com.google.gson.annotations.SerializedName

class CurrencyListResponse(
    @SerializedName("Valute")
    val data: Map<String, Valute>
) {

    data class Valute(

        @SerializedName("CharCode")
        val char_code: String?,

        @SerializedName("Nominal")
        val nominal: String?,

        @SerializedName("Name")
        val name: String?,

        @SerializedName("Value")
        val value: String?
    )
}

