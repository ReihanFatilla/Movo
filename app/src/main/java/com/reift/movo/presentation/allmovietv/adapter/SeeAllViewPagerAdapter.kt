package com.reift.movo.presentation.allmovietv.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.core.constant.Constant
import com.reift.movo.presentation.allmovietv.SeeAllTabFragment

class SeeAllViewPagerAdapter(
    fa: FragmentActivity,
    val category: String,
    val pageTotal: Int
) :FragmentStateAdapter(fa){

    override fun getItemCount() = pageTotal

    override fun createFragment(position: Int): Fragment {
        val seeAllTabFragment = SeeAllTabFragment()
        val bundle = Bundle()
        bundle.putString(Constant.BUNDLE_MOVIE_CATEGORY, category)
        bundle.putInt(Constant.BUNDLE_MOVIE_PAGE, position)
        seeAllTabFragment.arguments = bundle
        return seeAllTabFragment
    }
}