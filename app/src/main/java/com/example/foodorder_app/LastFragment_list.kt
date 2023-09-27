package com.example.foodorder_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder_app.model.MyViewModel

class LastFragment_list : Fragment() {
//    lateinit var lastFragBinding : LastFragmentListBinding

    private val viewmodel: MyViewModel by activityViewModels()
    private lateinit var selectedFoodAdapter: MyAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lastFrag = inflater.inflate(R.layout.last_fragment_list, container, false)
        val button = lastFrag.findViewById<Button>(R.id.button_next)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_lastFragment_list_to_mainDish)
        }

        recyclerView = lastFrag.findViewById(R.id.RV_lastFrag)
        selectedFoodAdapter = MyAdapter(5, viewLifecycleOwner, viewmodel)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = selectedFoodAdapter


        return lastFrag
    }

}