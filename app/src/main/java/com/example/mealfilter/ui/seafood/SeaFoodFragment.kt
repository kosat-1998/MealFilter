package com.example.mealfilter.ui.seafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealfilter.R
import com.example.mealfilter.adapter.MealAdapter
import com.example.mealfilter.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_seafood.*

class SeaFoodFragment : Fragment() {

    private lateinit var seaFoodViewModel: MealViewModel
    private lateinit var seafoodAdapter: MealAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_seafood, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seafoodAdapter = MealAdapter()
        recyclerSeaFood.apply {
            adapter = seafoodAdapter
            layoutManager = LinearLayoutManager(context)
        }
        obserViewModel()
    }

    override fun onResume() {
        super.onResume()
        seaFoodViewModel.loadMeal("Seafood")
    }

    fun obserViewModel() {
        seaFoodViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        seaFoodViewModel.getMeal().observe(viewLifecycleOwner,
            Observer {
                seafoodAdapter.upDateList(it)
            })
    }


}