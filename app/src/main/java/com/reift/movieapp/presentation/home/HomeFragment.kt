package com.reift.movieapp.presentation.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.reift.movieapp.`interface`.OnItemClickCallback
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.FragmentHomeBinding
import com.reift.movieapp.presentation.detail.DetailActivity
import com.reift.movieapp.adapter.CarouselAdapter
import com.reift.movieapp.presentation.home.component.CenterItemLayoutManager
import com.reift.movieapp.adapter.GenreListAdapter
import com.reift.movieapp.adapter.HorizontalListAdapter


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var _viewModel: HomeViewModel? = null
    private val viewModel get() = _viewModel!!

    private val carouselHandler = Handler()

    private var currentPage = 1
    private lateinit var carouselRunnable: Runnable
    private var movieLenght: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.getNowPlayingMovie(Constant.UNITED_STATES, currentPage.toString())
        viewModel.nowPlayingResponse.observe(viewLifecycleOwner){
            setUpCarousel(it.results as List<ResultsItem>?)
        }

        viewModel.getTrendingList(Constant.MEDIA_MOVIE, Constant.UNITED_STATES, currentPage.toString())
        viewModel.trendingResponse.observe(viewLifecycleOwner){
            setUpTrending(it.results as List<ResultsItem>?)
        }

        viewModel.getUpcomingMovie(Constant.UNITED_STATES, currentPage.toString())
        viewModel.upcomingResponse.observe(viewLifecycleOwner){
        }

        setUpTabBar()
        return binding.root
    }

    private fun setUpTrending(list: List<ResultsItem>?) {
        binding.rvTrendingHome.apply {
            val mAdapter = HorizontalListAdapter()
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            mAdapter.setData(list)

            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: ResultsItem) {
                    val intent = Intent(context, DetailActivity::class.java)
                    if(data.title == null){
                        intent.putExtra(Constant.INTENT_TO_DETAIL, data.id)
                        intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_TV)
                    } else {
                        intent.putExtra(Constant.INTENT_TO_DETAIL, data.id)
                        intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_MOVIE)
                    }
                    startActivity(intent)
                }
            })
        }
    }

    private fun setUpTabBar() {
        binding.tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> viewModel.getNowPlayingMovie(Constant.UNITED_STATES, currentPage.toString())
                    1 -> viewModel.getAiringTodayTvShow(Constant.UNITED_STATES, currentPage.toString())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                currentPage += 1
                when(tab?.position){
                    0 -> viewModel.getNowPlayingMovie(Constant.UNITED_STATES, currentPage.toString())
                    1 -> viewModel.getAiringTodayTvShow(Constant.UNITED_STATES, currentPage.toString())
                }
            }
        })
    }

    private fun setUpCarousel(movie: List<ResultsItem>?) {

        binding.rvCarousel.apply {

            val mAdapter = CarouselAdapter()
            adapter = mAdapter
            val mLayoutManager = CenterItemLayoutManager(context, RecyclerView.HORIZONTAL, false)
            layoutManager = mLayoutManager
            mAdapter.setData(movie)
            setUpCarouselMovieData(movie, 0)
            LinearSnapHelper().attachToRecyclerView(this)

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val position: Int = getCurrentItem()
                        setUpCarouselMovieData(movie, position + 1)
                    }
                }
            })


        }
    }

    private fun getCurrentItem(): Int {
        return (binding.rvCarousel.layoutManager as CenterItemLayoutManager)
            .findFirstVisibleItemPosition()
    }

    private fun setUpCarouselMovieData(movie: List<ResultsItem>?, currentItem: Int) {
        setUpGenreList(movie?.get(currentItem)?.genreIds as List<Int>?)
        binding.tvTitle.text = movie?.get(currentItem)?.title ?: movie?.get(currentItem)?.originalName
    }

    private fun setUpGenreList(movie: List<Int>?) {
        binding.rvGenre.apply {
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