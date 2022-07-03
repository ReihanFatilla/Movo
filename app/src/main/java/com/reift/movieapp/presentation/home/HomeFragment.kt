package com.reift.movieapp.presentation.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.FragmentHomeBinding
import com.reift.movieapp.presentation.detail.DetailActivity
import com.reift.movieapp.presentation.home.component.CarouselAdapter
import com.reift.movieapp.presentation.home.component.GenreListAdapter


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

        viewModel.getNowPlayingMovie(Constant.NOW_PLAYING, Constant.UNITED_STATES, currentPage.toString())
        viewModel.nowPlayingResponse.observe(viewLifecycleOwner){
            setUpCarousel(it.results as List<ResultsItem>?)
        }

        setUpTabBar()
        return binding.root
    }

    private fun setUpTabBar() {
        binding.tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> viewModel.getNowPlayingMovie(Constant.NOW_PLAYING, Constant.UNITED_STATES, currentPage.toString())
                    1 -> viewModel.getAiringTodayTvShow(Constant.AIRING_TODAY, Constant.UNITED_STATES, currentPage.toString())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                currentPage += 1
                when(tab?.position){
                    0 -> viewModel.getNowPlayingMovie(Constant.NOW_PLAYING, Constant.UNITED_STATES, currentPage.toString())
                    1 -> viewModel.getAiringTodayTvShow(Constant.AIRING_TODAY, Constant.UNITED_STATES, currentPage.toString())
                }
            }
        })
    }

    private fun setUpCarousel(movie: List<ResultsItem>?) {

        binding.vpCarousel.apply {

            val mAdapter = CarouselAdapter(binding.vpCarousel)
            adapter = mAdapter
            mAdapter.setData(movie)
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            // make the first item in the carousel as the center item
            setCurrentItem(mAdapter.itemCount * 3, false)

            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.apply {
                addTransformer {
                        page, position ->
                    val r = 1 - kotlin.math.abs(position)
                    page.scaleY = 0.85F + r * 0.1f
                    page.scaleX = 0.85F + r * 0.1f
                    if(currentItem >= movie!!.size){
                        if(currentItem - movieLenght == movie.size){
                            movieLenght += movie.size
                            setUpCarouselMovieData(movie, currentItem - movieLenght)
                        } else {
                            setUpCarouselMovieData(movie, currentItem - movieLenght)
                        }
                    } else {
                        setUpCarouselMovieData(movie, currentItem)
                    }
                }
            }
            setPageTransformer(compositePageTransformer)

            carouselRunnable = Runnable {
                currentItem += 1
            }

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    carouselHandler.removeCallbacks(carouselRunnable)
                    carouselHandler.postDelayed(carouselRunnable, 3000)
                }
            })
        }
    }

    override fun onPause() {
        super.onPause()
        carouselHandler.removeCallbacks(carouselRunnable)
    }

    private fun setUpCarouselMovieData(movie: List<ResultsItem>?, currentItem: Int) {
        binding.tvTitle.text = movie?.get(currentItem)?.title ?: movie?.get(currentItem)?.originalName
        setUpGenreList(movie?.get(currentItem)?.genreIds as List<Int>?)
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