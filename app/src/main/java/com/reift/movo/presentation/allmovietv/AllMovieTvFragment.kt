package com.reift.movo.presentation.allmovietv

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.movo.R
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.movo.adapter.VerticalListAdapter
import com.reift.movo.databinding.ActivityMainBinding
import com.reift.movo.databinding.FragmentAllMovieTvBinding
import com.reift.movo.presentation.allmovietv.adapter.SeeAllViewPagerAdapter
import com.reift.movo.presentation.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class AllMovieTvFragment : Fragment() {

    private var _binding: FragmentAllMovieTvBinding? = null
    private val binding get() = _binding as FragmentAllMovieTvBinding

    private lateinit var category: String
    private var totalPages = 1

    val args: AllMovieTvFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllMovieTvBinding.inflate(layoutInflater)

        category = args.category
        totalPages = args.totalPages

        setUpPageBar()
        setUpSeeAllTitle()
        setUpView()

        return binding.root
    }

    private fun setUpView() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.tvBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setUpSeeAllTitle() {
        binding.tvMovieTvCategory.text = categoryTextFormatter()
    }

    private fun categoryTextFormatter(): String {
        return when(category){
            Constant.POPULAR_MOVIE -> "Popular Movie"
            Constant.TOP_RATED_MOVIE -> "Top Rated Movie"
            Constant.UPCOMING_MOVIE -> "Upcoming Movie"
            Constant.NOW_PLAYING_MOVIE -> "Now Playing Movie"
            Constant.LATEST_MOVIE -> "Latest Movie"
            Constant.AIRING_TODAY_TV -> "Airing Today Tv"
            Constant.POPULAR_TV -> "Popular Tv Show"
            Constant.TOP_RATED_TV -> "Top Rated Tv"
            Constant.ON_THE_AIR_TV -> "On The Air Tv"
            else -> category
        }
    }

    private fun setUpPageBar() {
        binding.apply {
            Log.i("setUpPageBarASDasdas", "setUpPageBar: $totalPages")
            vpPage.adapter = activity?.let { SeeAllViewPagerAdapter(it, category, totalPages) }
            TabLayoutMediator(pageTabs, vpPage){ tab, position ->
                tab.text = (position+1).toString()
            }.attach()
        }
    }


}