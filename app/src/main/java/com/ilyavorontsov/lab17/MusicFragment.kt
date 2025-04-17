package com.ilyavorontsov.lab17

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MusicViewPagerAdapter(val fragments: List<Fragment>, fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragments.size
    }
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}

class MusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabs = view.findViewById<TabLayout>(R.id.tabs)
        val pager = view.findViewById<ViewPager2>(R.id.pager)
        val adapter = MusicViewPagerAdapter(listOf(
            MusicInsideFragment("Музыка / " + resources.getString(R.string.tab_music_pop)),
            MusicInsideFragment("Музыка / " + resources.getString(R.string.tab_music_disco)),
            MusicInsideFragment("Музыка / " + resources.getString(R.string.tab_music_rock)),
            MusicInsideFragment("Музыка / " + resources.getString(R.string.tab_music_classic)),
            MusicInsideFragment("Музыка / " + resources.getString(R.string.tab_music_hiphop)),
            MusicInsideFragment("Музыка / " + resources.getString(R.string.tab_music_soundtrack))
        ), this)
        pager.adapter = adapter

        TabLayoutMediator(tabs, pager) { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.tab_music_pop)
                1 -> tab.text = resources.getString(R.string.tab_music_disco)
                2 -> tab.text = resources.getString(R.string.tab_music_rock)
                3 -> tab.text = resources.getString(R.string.tab_music_classic)
                4 -> tab.text = resources.getString(R.string.tab_music_hiphop)
                5 -> tab.text = resources.getString(R.string.tab_music_soundtrack)
            }
        }.attach()
    }
}