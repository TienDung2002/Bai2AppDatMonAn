package com.example.foodorder_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MainDish : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainDishView = inflater.inflate(R.layout.main_dish, container, false)
        val button = mainDishView.findViewById<Button>(R.id.button_next)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_mainDish_to_subDish)
        }

        return mainDishView
    }

}