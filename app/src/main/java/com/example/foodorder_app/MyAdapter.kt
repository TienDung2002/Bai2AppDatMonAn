package com.example.foodorder_app

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder_app.databinding.FoodItemBinding
import com.example.foodorder_app.model.Food
import androidx.lifecycle.ViewModelProvider
import com.example.foodorder_app.model.MyViewModel

class MyAdapter(var foodtype : Int, private val lifecycleOwner: LifecycleOwner, val viewmodel: MyViewModel) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private lateinit var binding : FoodItemBinding
    private lateinit var context: Context
    companion object {
        var MainDishList : MutableList<Food> = mutableListOf()
        var SubDishList : MutableList<Food> = mutableListOf()
        var DrinksList : MutableList<Food> = mutableListOf()
        var DessertList : MutableList<Food> = mutableListOf()
        var LastFragment_List : MutableList<Food> = mutableListOf()
        var Other : MutableList<Food> = mutableListOf()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = FoodItemBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun getItemCount(): Int {
        when (foodtype) {
            1 -> return MainDishList.size
            2 -> return SubDishList.size
            3 -> return DrinksList.size
            4 -> return DessertList.size
//            5 -> return LastFragment_List.size
            else -> return Other.size
        }
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        when (foodtype) {
            1 -> return holder.bind(MainDishList[position])
            2 -> return holder.bind(SubDishList[position])
            3 -> return holder.bind(DrinksList[position])
            4 -> return holder.bind(DessertList[position])
//            5 -> return holder.bind(LastFragment_List[position])
            else -> return holder.bind(Other[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    // lưu sự kiện click listener
    private var onItemClick: ((Food) -> Unit)? = null

    // gán sự kiện click listener
    fun setOnItemClickListener(listener: (Food) -> Unit) {
        onItemClick = listener
    }
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Food) {
            binding.apply {
                tvfoodName.text = item.name
                imgFoods.setImageResource(item.img)
                if (item.name == getNameFood(foodtype)) {
                    checkbox.setChecked(true)
                }
                checkbox.setOnClickListener() {
                    if (checkbox.isChecked) {
                        when (foodtype) {
                            1 -> {
                                viewmodel.currentMain.value = item.name
                                viewmodel.currentMainImg.value = item.img
                            }
                            2 -> {
                                viewmodel.currentSubDish.value = item.name
                                viewmodel.currentSubDishImg.value = item.img
                            }
                            3 -> {
                                viewmodel.currentDrinks.value = item.name
                                viewmodel.currentDrinksImg.value = item.img
                            }
                            4 -> {
                                viewmodel.currentDessert.value = item.name
                                viewmodel.currentDessertImg.value = item.img
                            }
                            else -> Log.e("Error", "Not found foodtype!")
                        }
                    }
                }
            }
            itemView.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
    fun getNameFood(foodtype:Int) : String {
        var name: String = ""

        when (foodtype) {
            1 -> {
                viewmodel.currentMain.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }

            2 -> {
                viewmodel.currentSubDish.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }

            3 -> {
                viewmodel.currentDrinks.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }

            4 -> {
                viewmodel.currentDessert.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }

            else -> Log.e("Error", "Not found foodtype!")
        }
        return name
    }
}