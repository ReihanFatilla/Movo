package com.reift.movo.presentation.detail.fragments.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.core.constant.Constant
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.movo.presentation.detail.fragments.OtherFragment
import com.reift.movo.presentation.detail.fragments.OverviewFragment

class DetailViewPagerAdapter(
    fa: FragmentActivity,
    val id: String,
    val movieDetail: MovieDetail
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        val otherFragment = OtherFragment()
        val overviewFragment = OverviewFragment()
        val bundle = Bundle()
        bundle.putString(Constant.BUNDLE_MOVIE_ID, id)
        bundle.putParcelable(Constant.BUNDLE_MOVIE_DETAIL, movieDetail)
        otherFragment.arguments = bundle
        overviewFragment.arguments = bundle

        return when(position) {
            0 -> overviewFragment
            else -> otherFragment
        }
    }

}