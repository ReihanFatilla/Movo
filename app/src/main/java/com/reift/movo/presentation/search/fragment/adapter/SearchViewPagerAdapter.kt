package com.reift.movo.presentation.search.fragment.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.core.constant.Constant
import com.reift.movo.presentation.search.fragment.SearchMediaFragment

class SearchViewPagerAdapter(
    fa: FragmentActivity,
    val querySearch: String
)
    : FragmentStateAdapter(fa){
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        val movieTabFragment = SearchMediaFragment()
        val movieBundle = Bundle()
        movieBundle.putString(Constant.BUNDLE_MEDIA_TYPE, Constant.BUNDLE_MEDIA_MOVIE)
        movieBundle.putString(Constant.BUNDLE_SEARCH_QUERY, querySearch)
        movieTabFragment.arguments = movieBundle

        val tvTabFragment = SearchMediaFragment()
        val tvBundle = Bundle()
        tvBundle.putString(Constant.BUNDLE_MEDIA_TYPE, Constant.BUNDLE_MEDIA_TV)
        tvBundle.putString(Constant.BUNDLE_SEARCH_QUERY, querySearch)
        tvTabFragment.arguments = tvBundle
        return when(position){
            0 -> movieTabFragment
            else -> tvTabFragment
        }
    }


}