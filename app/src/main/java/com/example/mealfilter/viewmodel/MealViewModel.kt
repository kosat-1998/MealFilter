package com.example.mealfilter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealfilter.api.MealApi
import com.example.mealfilter.model.Meal
import com.example.mealfilter.model.MealX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealViewModel : ViewModel() {
    var result: MutableLiveData<List<MealX>> = MutableLiveData()

    fun getMeal(): LiveData<List<MealX>> = result
    private val mealApi = MealApi()

    fun loadMeal(search: String) {
        val apiCall = mealApi.getMeal(search)

        apiCall.enqueue(object : Callback<Meal> {
            override fun onFailure(call: Call<Meal>, t: Throwable) {
                Log.i("Error>>>>>>>", "Loading Fail")
            }

            override fun onResponse(call: Call<Meal>, response: Response<Meal>) {
                response.isSuccessful.let {
                    var mealList: List<MealX> = response.body()?.meals ?: emptyList()
                    result.value = mealList
                }
            }
        })
    }
}