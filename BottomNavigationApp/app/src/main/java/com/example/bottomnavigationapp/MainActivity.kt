package com.example.bottomnavigationapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottom = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replaceWithFragment(chat())

        bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item3 -> replaceWithFragment(chat())
                R.id.item1 -> replaceWithFragment(profile())
                R.id.item2 -> replaceWithFragment(android())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransition= fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.framelayout, fragment)
        fragmentTransition.commit()
    }
}