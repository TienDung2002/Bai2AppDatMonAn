package com.example.foodorder_app.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val currentMain = MutableLiveData<String>()
    val currentSubDish = MutableLiveData<String>()
    val currentDessert = MutableLiveData<String>()
    val currentDrinks = MutableLiveData<String>()

    val currentMainImg = MutableLiveData<Int>()
    val currentSubDishImg = MutableLiveData<Int>()
    val currentDessertImg = MutableLiveData<Int>()
    val currentDrinksImg = MutableLiveData<Int>()

    val selectedFoods: MutableList<Food> = mutableListOf()
}