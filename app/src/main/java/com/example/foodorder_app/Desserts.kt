package com.example.foodorder_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Desserts : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val DessertsView = inflater.inflate(R.layout.desserts, container, false)
        val button = DessertsView.findViewById<Button>(R.id.button_next)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_desserts_to_lastFragment_list)
        }

        return DessertsView
    }

}