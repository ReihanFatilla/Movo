package com.reift.movo.presentation.home.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.core.constant.Constant
import com.reift.movo.presentation.detail.fragments.OverviewFragment
import com.reift.movo.presentation.home.fragment.HomeTabFragment
import com.reift.movo.utils.HomeTabFragmentGenerator

class HomeViewPagerAdapter(
    fa: FragmentActivity
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {

        val topRatedMovie = HomeTabFragmentGenerator.generate(Constant.TOP_RATED_MOVIE)
        val topRatedTv = HomeTabFragmentGenerator.generate(Constant.TOP_RATED_TV)
        val airingTodayTv = HomeTabFragmentGenerator.generate(Constant.AIRING_TODAY_TV)
        val popularTv = HomeTabFragmentGenerator.generate(Constant.POPULAR_TV)

        return listOf(airingTodayTv, topRatedMovie, topRatedTv, popularTv)[position]
    }

}