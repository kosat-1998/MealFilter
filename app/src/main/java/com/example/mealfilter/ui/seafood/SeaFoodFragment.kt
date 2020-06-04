package com.example.mealfilter.ui.seafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealfilter.R
import com.example.mealfilter.adapter.MealAdapter
import com.example.mealfilter.ui.chicken.ChickenViewModel
import kotlinx.android.synthetic.main.fragment_chicken.*
import kotlinx.android.synthetic.main.fragment_seafood.*

class SeaFoodFragment : Fragment() {

    private lateinit var seaFoodViewModel: SeaFoodViewModel
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
        seaFoodViewModel.loadResult("Seafood")
    }

    fun obserViewModel() {
        seaFoodViewModel = ViewModelProvider(this).get(SeaFoodViewModel::class.java)

        seaFoodViewModel.getSeaFood().observe(viewLifecycleOwner,
            Observer {
                seafoodAdapter.upDateList(it)
            })
    }


}