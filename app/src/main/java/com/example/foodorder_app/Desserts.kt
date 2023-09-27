package com.example.foodorder_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder_app.MyAdapter.Companion.DessertList
import com.example.foodorder_app.model.Food
import com.example.foodorder_app.model.MyViewModel

class Desserts : Fragment() {
    lateinit var listView : RecyclerView
    lateinit var adapter: MyAdapter
    lateinit var viewmodel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val DessertsView = inflater.inflate(R.layout.desserts, container, false)
        val button = DessertsView.findViewById<Button>(R.id.button_next)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_desserts_to_lastFragment_list)
        }

        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)

        DessertList = mutableListOf<Food>()

        DessertList.add(Food(getString(R.string.banh_duaws), R.drawable.banh_duaws))
        DessertList.add(Food(getString(R.string.bingsu_xoai), R.drawable.bingsu_xoai))
        DessertList.add(Food(getString(R.string.mochi), R.drawable.mochi))
        DessertList.add(Food(getString(R.string.banh_tart), R.drawable.banh_tart))
        DessertList.add(Food(getString(R.string.tiramisu), R.drawable.tiramisu))
        DessertList.add(Food(getString(R.string.banh_kep), R.drawable.banh_kep))
        DessertList.add(Food(getString(R.string.panna_cotta), R.drawable.panna_cotta))
        DessertList.add(Food(getString(R.string.trai_cay), R.drawable.trai_cay))

        listView = DessertsView.findViewById(R.id.listViewDesserts)
        adapter = MyAdapter(4, viewLifecycleOwner, viewmodel)
        listView.layoutManager = LinearLayoutManager(view?.context)
        listView.adapter = adapter

        adapter.setOnItemClickListener { selectedFood ->
            viewmodel.selectedFoods.add(selectedFood)
        }

        return DessertsView
    }

}