package com.example.currency.retrofit

import com.example.currency.model_data.CurrencyListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CurrencyApi {

    @GET("daily_json.js")
    fun getCurrencyList(): Single<CurrencyListResponse>
}