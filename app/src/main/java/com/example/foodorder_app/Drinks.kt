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
import com.example.foodorder_app.MyAdapter.Companion.DrinksList
import com.example.foodorder_app.model.Food
import com.example.foodorder_app.model.MyViewModel

class Drinks : Fragment() {
    lateinit var listView : RecyclerView
    lateinit var adapter: MyAdapter
    lateinit var viewmodel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val drinksView = inflater.inflate(R.layout.drinks, container, false)
        val button = drinksView.findViewById<Button>(R.id.button_next)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_drinks_to_desserts)
        }

        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)

        DrinksList = mutableListOf<Food>()

        DrinksList.add(Food(getString(R.string.coca), R.drawable.coca))
        DrinksList.add(Food(getString(R.string.pepsi), R.drawable.pepsi))
        DrinksList.add(Food(getString(R.string.fanta), R.drawable.fanta))
        DrinksList.add(Food(getString(R.string.nuoc_cam), R.drawable.nuoc_cam_ep))
        DrinksList.add(Food(getString(R.string.nuoc_dua_hau), R.drawable.nuoc_dua_hau))
        DrinksList.add(Food(getString(R.string.ruou_vang), R.drawable.ruou_vang))
        DrinksList.add(Food(getString(R.string.nuoc_chanh), R.drawable.nuoc_chanh))
        DrinksList.add(Food(getString(R.string.nuoc_ep_carot), R.drawable.nuoc_ca_rot))

        listView = drinksView.findViewById(R.id.listViewDrinks)
        adapter = MyAdapter(3, viewLifecycleOwner, viewmodel)
        listView.layoutManager = LinearLayoutManager(view?.context)
        listView.adapter = adapter

        adapter.setOnItemClickListener { selectedFood ->
            viewmodel.selectedFoods.add(selectedFood)
        }

        return drinksView
    }

}