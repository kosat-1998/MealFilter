package com.example.mealfilter.ui.seafood

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

class SeaFoodViewModel : ViewModel() {

    var result: MutableLiveData<List<MealX>> = MutableLiveData()

    fun getSeaFood(): LiveData<List<MealX>> = result
    private val mealApi = MealApi()

    fun loadResult(search: String) {
        val apiCall = mealApi.getSeaFood(search)

        apiCall.enqueue(object : Callback<Meal> {
            override fun onFailure(call: Call<Meal>, t: Throwable) {
                Log.i("Error>>>>>>>", "Loading Fail")
            }

            override fun onResponse(call: Call<Meal>, response: Response<Meal>) {
                response.isSuccessful.let {
                    var seafoodList: List<MealX> = response.body()?.meals ?: emptyList()
                    result.value = seafoodList
                }
            }
        })
    }
}