package com.example.myapplication.ui.carouselrecycler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CarouselFragment : Fragment(R.layout.fragment_carousel){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager : ViewPager2 = view.findViewById(R.id.viewPager2)
        val tabs : TabLayout = view.findViewById(R.id.tabsViewPager2)
        viewPager.adapter = CarouselRecyclerView()
        TabLayoutMediator(tabs,viewPager){_,_->}.attach()
    }
}