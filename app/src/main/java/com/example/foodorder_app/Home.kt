package com.example.foodorder_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Home : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeStartFrag =  inflater.inflate(R.layout.home, container, false)
        val button = homeStartFrag.findViewById<Button>(R.id.buttonStart)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_home_fragment_to_mainDish)
        }

        return homeStartFrag
    }
}
