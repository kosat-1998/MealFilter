package com.example.mealfilter.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealApi {

    private val apiInterface: ApiInterface

    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        apiInterface = retrofit.create(ApiInterface::class.java)

    }
    fun getMeal(search: String) = apiInterface.getMeal(search)

}