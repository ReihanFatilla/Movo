package com.reift.movo.presentation.home.fragment.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.core.constant.Constant
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.movo.presentation.detail.fragments.OtherFragment
import com.reift.movo.presentation.detail.fragments.OverviewFragment
import com.reift.movo.presentation.home.fragment.HomeTabFragment

class HomeViewPagerAdapter(
    fa: FragmentActivity
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        val bundle = Bundle()

        val topRatedMovie = HomeTabFragment()
        bundle.putString(Constant.BUNDLE_MOVIE_CATEGORY, Constant.TOP_RATED_MOVIE)
        topRatedMovie.arguments = bundle

        return when(position) {
            0 -> topRatedMovie
            else -> topRatedMovie
        }
    }

}