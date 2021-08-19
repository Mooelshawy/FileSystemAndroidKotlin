package com.omran.accesssystemfile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
class MainActivity : AppCompatActivity() {

    private lateinit var  navController:  NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = this.findNavController(R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)


        }

    override fun onSupportNavigateUp(): kotlin.Boolean {
        val navController = this.findNavController(R.id.fragment)
        return navController.navigateUp()

    }

    }
