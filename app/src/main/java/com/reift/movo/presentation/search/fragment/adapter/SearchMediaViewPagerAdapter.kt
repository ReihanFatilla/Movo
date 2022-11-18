package com.reift.movo.presentation.search.fragment.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.core.constant.Constant
import com.reift.movo.presentation.search.fragment.SearchTabFragment

class SearchMediaViewPagerAdapter(
    fa: FragmentActivity,
    val querySearch: String
)
    : FragmentStateAdapter(fa){
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        val searchTabFragment = SearchTabFragment()
        val bundle = Bundle()
        bundle.putString(BUNDLE_SEARCH_QUERY, querySearch)
        searchTabFragment.arguments = bundle

        return searchTabFragment
    }

    companion object{
        const val BUNDLE_SEARCH_QUERY = "BUNDLE_SEARCH_QUERY"
    }
}