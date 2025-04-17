package com.ilyavorontsov.lab17

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navCtl = navHostFragment.navController
        val navBar = findViewById<BottomNavigationView>(R.id.bottomNavbar)

        val badge = navBar.getOrCreateBadge(R.id.menu_news)
        val timer = object : CountDownTimer(600_000, 2_000) {
            var isStopped: Boolean = false

            override fun onTick(millisUntilFinished: Long) {
                badge.number++
                badge.isVisible = true
            }

            override fun onFinish() {

            }
        }
        timer.start()

        navBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_music -> {
                    if (timer.isStopped) {
                        timer.start()
                        timer.isStopped = false
                    }
                    navCtl.navigate(R.id.musicFragment)
                    true
                }
                R.id.menu_books -> {
                    if (timer.isStopped) {
                        timer.start()
                        timer.isStopped = false
                    }
                    navCtl.navigate(R.id.bookFragment)
                    true
                }
                R.id.menu_news -> {
                    timer.cancel()
                    timer.isStopped = true
                    navCtl.navigate(R.id.newsFragment)
                    true
                }
                else -> false
            }
        }
    }
}