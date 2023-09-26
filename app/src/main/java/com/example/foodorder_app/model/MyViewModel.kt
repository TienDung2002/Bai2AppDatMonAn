package com.example.foodorder_app.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


//class ViewModel(private val context: Context, private val listFood: ArrayList<Food>) : ViewModel() {
//    private val selectedFoodList: MutableLiveData<List<Food>?> = MutableLiveData()
//    private lateinit var sharedPreferences: SharedPreferences
//
//    fun addSelectedItem(food: Food) {
//        val curList = selectedFoodList.value?.toMutableList() ?: mutableListOf()
//        curList.add(food)
//        selectedFoodList.value = curList
//    }
//
//    fun removeSelectedItem(food: Food) {
//        val curList = selectedFoodList.value?.toMutableList() ?: mutableListOf()
//        curList.remove(food)
//        selectedFoodList.value = curList
//    }
//
//    // Lưu data trong SharedPreferences
//    fun saveData () {
//        sharedPreferences = context.getSharedPreferences("Storage", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putStringSet(
//            "key",
//            selectedFoodList.value?.map { it.name }?.toSet()
//        )
//        editor.apply()
//    }
//
//    // Phục hồi data từ SharedPreferences
//    fun restoreData() {
//        sharedPreferences = context.getSharedPreferences("Storage", Context.MODE_PRIVATE)
//        val restoredSet = sharedPreferences.getStringSet("key", null)
//        val restoredList = restoredSet?.mapNotNull { value ->
//            listFood.find { it.name == value }
//        }
//        if (selectedFoodList.value == null) selectedFoodList.value = restoredList ?: emptyList()
//        else selectedFoodList.value = restoredList
//    }
//}
//
//class SharedViewModelFactory(private val context: Context, private val listFood: ArrayList<Food>) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ViewModel::class.java)) {
//            return ViewModel(context, listFood) as T
//        }
//        throw Exception("Lỗi xử lí dữ liệu")
//    }
//}

class MyViewModel : ViewModel() {
    val currentMain = MutableLiveData<String>()
    val currentSubDish = MutableLiveData<String>()
    val currentDessert = MutableLiveData<String>()
    val currentDrinks = MutableLiveData<String>()

    val currentMainImg = MutableLiveData<Int>()
    val currentSubDishImg = MutableLiveData<Int>()
    val currentDessertImg = MutableLiveData<Int>()
    val currentDrinksImg = MutableLiveData<Int>()
}