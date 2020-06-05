package com.example.mealfilter.api

import com.example.mealfilter.model.Meal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("filter.php")
    fun getMeal(@Query("c") search: String): Call<Meal>

}