package com.example.foodorder_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.foodorder_app.model.MyViewModel
//import com.example.foodorder_app.model.listFood

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    lateinit var viewmodel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFrag = supportFragmentManager
            // fragmentContainerView ở activity_main gắn với home.xml từ ban đầu
            .findFragmentById(R.id.idHostFragment) as NavHostFragment
        navController = navHostFrag.navController

        setSupportActionBar(findViewById(R.id.toolbar))
        setupActionBarWithNavController(navController)
        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Tùy chỉnh tiêu đề trên toolbar
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Kiểm tra ID của destination và đặt tiêu đề tùy fragment đang đứng
            when (destination.id) {
                R.id.home_fragment -> supportActionBar?.title = ""
                R.id.mainDish -> supportActionBar?.title = "Món chính"
                R.id.subDish -> supportActionBar?.title = "Món phụ"
                R.id.drinks -> supportActionBar?.title = "Đồ uống"
                R.id.desserts -> supportActionBar?.title = "Tráng miệng"
                R.id.lastFragment_list -> supportActionBar?.title = "Các món đã chọn"
                else -> supportActionBar?.title = "Các fragment mới"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}