package com.ilyavorontsov.lab17

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnClearNews = view.findViewById<Button>(R.id.btnClearNews)
        btnClearNews.setOnClickListener {
            val navBar = activity!!.findViewById<BottomNavigationView>(R.id.bottomNavbar)
            val badge = navBar.getOrCreateBadge(R.id.menu_news)
            badge.isVisible = false
            badge.number = 0
        }
    }
}