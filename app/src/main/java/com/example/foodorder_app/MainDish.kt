package com.example.foodorder_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder_app.model.Food
import com.example.foodorder_app.model.MyViewModel
import com.example.foodorder_app.MyAdapter.Companion.MainDishList

//import com.example.foodorder_app.model.listFood



class MainDish : Fragment() {
    lateinit var listView : RecyclerView
    lateinit var adapter: MyAdapter
    lateinit var viewmodel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainDishView = inflater.inflate(R.layout.main_dish, container, false)
        val button = mainDishView.findViewById<Button>(R.id.button_next)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_mainDish_to_subDish)
        }

        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)

        MainDishList = mutableListOf<Food>()
        MainDishList.add(Food(getString(R.string.goi_ngo_sen), R.drawable.goi_ngo_sen))
        MainDishList.add(Food(getString(R.string.ca_phi_le), R.drawable.ca_phi_le))
        MainDishList.add(Food(getString(R.string.muc_chien_gion), R.drawable.muc_chien_gion))
        MainDishList.add(Food(getString(R.string.tom_hap), R.drawable.tom_hap))
        MainDishList.add(Food(getString(R.string.suon_cay_sot), R.drawable.suon_cay_sot_mat_ong))
        MainDishList.add(Food(getString(R.string.ga_ta_quay_lu), R.drawable.ga_ta_quay_lu))
        MainDishList.add(Food(getString(R.string.lau_ca_lang), R.drawable.lau_ca_lang))
        MainDishList.add(Food(getString(R.string.xoi_hat_sen), R.drawable.xoi_hat_sen))

        listView = mainDishView.findViewById(R.id.listViewMainDish)
        adapter = MyAdapter(1, viewLifecycleOwner, viewmodel)
        listView.layoutManager = LinearLayoutManager(view?.context)
        listView.adapter = adapter

        return mainDishView
    }

}