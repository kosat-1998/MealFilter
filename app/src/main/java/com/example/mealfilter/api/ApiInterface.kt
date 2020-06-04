package com.example.mealfilter.api

import com.example.mealfilter.model.Meal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("filter.php")
    fun getBeef(@Query("c") search: String):Call<Meal>

    @GET("filter.php")
    fun getChicken (@Query("c") search: String): Call<Meal>

    @GET("filter.php")
    fun getSeaFood(@Query("c") search: String):Call<Meal>


}