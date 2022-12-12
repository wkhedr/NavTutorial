package com.wik4apps.navtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.wik4apps.navtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //use view binding
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val drawer = binding.drawerLayout
        //binding.toolbar.setupWithNavController(navController)
        binding.toolbar.setupWithNavController(navController, drawer)
        //Bottom nav bar
         binding.bottomView.setupWithNavController(navController)
        //Drawer
        binding.navView.setupWithNavController(navController)
        //NavigationUI.setupWithNavController(binding.navView, navController)
    }

    //add menu to toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //add menu action
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return item.onNavDestinationSelected(navController)
        /*when(item.itemId){
            R.id.helpFragment -> {
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }*/
    }
}