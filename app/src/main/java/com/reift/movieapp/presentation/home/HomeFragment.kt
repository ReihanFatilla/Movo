package com.reift.movieapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.reift.movieapp.R
import com.reift.movieapp.adapter.CarouselAdapter
import com.reift.movieapp.adapter.GenreListAdapter
import com.reift.core.constant.Constant
import com.reift.movieapp.databinding.FragmentHomeBinding
import com.reift.movieapp.presentation.home.component.CenterItemLayoutManager
import com.reift.movieapp.presentation.home.component.MovieTypeData


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var _viewModel: HomeViewModel? = null
    private val viewModel get() = _viewModel!!

    private var currentPage = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

//        binding.includedShimmer.frameShimmer.startShimmer()

//        setUpMovieTypeList()
//
//        viewModel.getNowPlayingMovie(Constant.UNITED_STATES, currentPage.toString())
//        viewModel.nowPlayingResponse.observe(viewLifecycleOwner){
//            setUpCarousel(it.results as List<ResultsItem>?)
//        }

        binding.svHome.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_search)
        }

//        setUpTabBar()
        return binding.root
    }


//    private fun setUpMovieTypeList() {
//        val mAdapter = MovieTypeAdapter()
//
//        viewModel.getListByType(Constant.MEDIA_MOVIE, Constant.TOP_RATED, Constant.UNITED_STATES, currentPage.toString())
//        viewModel.topRatedResponse.observe(viewLifecycleOwner){
//            mAdapter.setData(MovieTypeData(
//                "Top Rated",
//                "See what's Top Rated",
//                it.results as List<ResultsItem>?
//            ))
//            Log.i("setUpMovieTypeList", it.results.toString())
//        }
//
//        viewModel.getTrendingList(Constant.MEDIA_MOVIE, Constant.UNITED_STATES, currentPage.toString())
//        viewModel.trendingResponse.observe(viewLifecycleOwner){
//            mAdapter.setData(MovieTypeData(
//                "Trending",
//                "See what's Trending",
//                it.results as List<ResultsItem>?
//            ))
//            Log.i("setUpMovieTypeList2", it.results.toString())
//
//        }
//
//        viewModel.getListByType(Constant.MEDIA_MOVIE, Constant.UPCOMING, Constant.UNITED_STATES, currentPage.toString())
//        viewModel.upcomingResponse.observe(viewLifecycleOwner){
//            mAdapter.setData(MovieTypeData(
//                "Upcoming",
//                "See what's Upcoming",
//                it.results as List<ResultsItem>?
//            ))
//        }
//    }

//    private fun setUpTabBar() {
//        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                when(tab.position){
////                    0 -> viewModel.getNowPlayingMovie(Constant.UNITED_STATES, currentPage.toString())
////                    1 -> viewModel.getAiringTodayTvShow(Constant.UNITED_STATES, currentPage.toString())
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                currentPage += 1
//                when(tab?.position){
//                    0 -> viewModel.getNowPlayingMovie(Constant.UNITED_STATES, currentPage.toString())
//                    1 -> viewModel.getAiringTodayTvShow(Constant.UNITED_STATES, currentPage.toString())
//                }
//            }
//        })
//    }

    private fun setUpCarousel(movie: List<ResultsItem>?) {
        binding.rvCarousel.apply {
            val mAdapter = CarouselAdapter()
            adapter = mAdapter
            val mLayoutManager = CenterItemLayoutManager(context, RecyclerView.HORIZONTAL, false)
            layoutManager = mLayoutManager
            setUpCarouselMovieData(movie, 0)
            mAdapter.setData(movie)
            PagerSnapHelper().attachToRecyclerView(this)

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val position: Int = getCurrentItem()
                        setUpCarouselMovieData(movie, position + 1)
                    }
                }
            })

//            Handler().postDelayed({
//                binding.includedShimmer.frameShimmer.stopShimmer()
//                binding.includedShimmer.frameShimmer.visibility = View.INVISIBLE
//                binding.contraintHome.visibility = View.VISIBLE
//            }, 1000)


        }
    }

    private fun getCurrentItem(): Int {
        return (binding.rvCarousel.layoutManager as CenterItemLayoutManager)
            .findFirstVisibleItemPosition()
    }

    private fun setUpCarouselMovieData(movie: List<ResultsItem>?, currentItem: Int) {
        setUpGenreList(movie?.get(currentItem)?.genreIds as List<Int>?)
        binding.tvCarouselTitle.text = movie?.get(currentItem)?.title ?: movie?.get(currentItem)?.originalName
    }

    private fun setUpGenreList(movie: List<String>?) {
        binding.rvCarouselGenre.apply {
            val mAdapter = GenreListAdapter()
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            mAdapter.setData(movie)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}