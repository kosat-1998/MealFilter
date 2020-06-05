package com.example.mealfilter.ui.beef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealfilter.R
import com.example.mealfilter.adapter.MealAdapter
import com.example.mealfilter.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_beef.*

class BeefFragment : Fragment() {

    private lateinit var beefViewModel: MealViewModel
    private lateinit var beefAdapter: MealAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_beef, container, false)
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beefAdapter = MealAdapter()
        recyclerBeef.apply {
            adapter = beefAdapter
            layoutManager = LinearLayoutManager(context)
        }
        obserViewModel()
    }

    override fun onResume() {
        super.onResume()
        beefViewModel.loadMeal("Beef")
    }

    fun obserViewModel() {
        beefViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        beefViewModel.getMeal().observe(viewLifecycleOwner,
            Observer {
                beefAdapter.upDateList(it)
            })
    }

}