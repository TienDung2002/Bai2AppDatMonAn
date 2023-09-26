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
import com.example.foodorder_app.MyAdapter.Companion.SubDishList
import com.example.foodorder_app.model.Food
import com.example.foodorder_app.model.MyViewModel

class SubDish : Fragment() {
    lateinit var listView : RecyclerView
    lateinit var adapter: MyAdapter
    lateinit var viewmodel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val SubDishView = inflater.inflate(R.layout.sub_dish, container, false)
        val button = SubDishView.findViewById<Button>(R.id.button_next)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_subDish_to_drinks)
        }

        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)

        SubDishList = mutableListOf<Food>()

        SubDishList.add(Food(getString(R.string.com_chien), R.drawable.com_chien_hai_san))
        SubDishList.add(Food(getString(R.string.khoai_tay_chien), R.drawable.khoai_tay_chien))
        SubDishList.add(Food(getString(R.string.ngo_chien_bo), R.drawable.ngo_chien))
        SubDishList.add(Food(getString(R.string.kimbap_chien), R.drawable.kimbap_chien))
        SubDishList.add(Food(getString(R.string.chao_ga), R.drawable.chao_ga))
        SubDishList.add(Food(getString(R.string.banh_xeo), R.drawable.banh_xeo))
        SubDishList.add(Food(getString(R.string.banh_bot_loc), R.drawable.banh_bot_loc))
        SubDishList.add(Food(getString(R.string.phong_tom), R.drawable.phong_tom))

        listView = SubDishView.findViewById(R.id.listViewSubDish)
        adapter = MyAdapter(2, viewLifecycleOwner, viewmodel)
        listView.layoutManager = LinearLayoutManager(view?.context)
        listView.adapter = adapter

        return SubDishView
    }
}