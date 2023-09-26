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
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder_app.databinding.FoodItemBinding
import com.example.foodorder_app.model.Food
import androidx.lifecycle.ViewModelProvider
import com.example.foodorder_app.model.MyViewModel


//class MyAdapter(
//    val context: Context, private var listArrayFood: ArrayList<Food>, var selected: List<Food>
//) : BaseAdapter() {
//
//    inner class ViewHolder(row: View) {
//        var imgFoods: ImageView
//        var tvFoodName: TextView
//        var checkBox: CheckBox
//
//        init {
//            imgFoods = row.findViewById(R.id.img_foods)
//            tvFoodName = row.findViewById(R.id.tvfoodName)
//            checkBox = row.findViewById(R.id.checkbox)
//        }
//    }
//
//    override fun getCount(): Int {
//        return listArrayFood.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return listArrayFood[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    fun updateSelectedFoodList(selectedList: List<Food>) {
//        selected = selectedList
//        notifyDataSetChanged()
//    }
//
//    fun CheckBox.setCheckedWithCallback(checked: Boolean, callback: (Boolean) -> Unit) {
//        setOnCheckedChangeListener { _, isChecked -> callback(isChecked) }
//        isChecked = checked
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        var view: View?
//        var viewHolder: ViewHolder
//        if (convertView == null) {
//            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
//            view = layoutInflater.inflate(R.layout.food_item, null)
//            viewHolder = ViewHolder(view)
//            view.tag = viewHolder
//        } else {
//            view = convertView
//            viewHolder = convertView.tag as ViewHolder
//        }
//
//        var food: Food = getItem(position) as Food
//        viewHolder.checkBox.setOnCheckedChangeListener(null)
//        viewHolder.checkBox.isChecked = selected.contains(food)
////        viewHolder.checkBox.setOnCheckedChangeListener { button, isChecked ->
////            OnFoodCheckedChangeListener?.invoke(food, isChecked)
////        }
//        viewHolder.checkBox.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                addSelectedItem()
//            } else {
//                // Xử lý khi CheckBox bị bỏ chọn
//            }
//        }
//        viewHolder.tvFoodName.text = food.name
//        viewHolder.imgFoods.setImageResource(food.img)
//        return view as View
//    }
//}

class MyAdapter(var foodtype : Int, private val lifecycleOwner: LifecycleOwner, val viewmodel: MyViewModel) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private lateinit var binding : FoodItemBinding
    private lateinit var context: Context
    companion object {
        var MainDishList : MutableList<Food> = mutableListOf()
        var SubDishList : MutableList<Food> = mutableListOf()
        var DrinksList : MutableList<Food> = mutableListOf()
        var DessertList : MutableList<Food> = mutableListOf()
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
            else -> return Other.size
        }
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        when (foodtype) {
            1 -> return holder.bind(MainDishList[position])
            2 -> return holder.bind(SubDishList[position])
            3 -> return holder.bind(DrinksList[position])
            4 -> return holder.bind(DessertList[position])
            else -> return holder.bind(Other[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
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
        }
    }
    fun getNameFood(foodtype:Int) : String {
        var name : String = ""

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