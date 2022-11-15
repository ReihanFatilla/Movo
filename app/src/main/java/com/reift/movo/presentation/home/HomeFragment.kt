package com.reift.movo.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.reift.core.constant.Constant
import com.reift.movo.R
import com.reift.movo.adapter.CarouselAdapter
import com.reift.movo.adapter.GenreListAdapter
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.movo.adapter.HorizontalListAdapter
import com.reift.movo.databinding.FragmentHomeBinding
import com.reift.movo.presentation.detail.DetailActivity
import com.reift.movo.presentation.home.component.CenterItemLayoutManager
import com.reift.movo.presentation.home.fragment.adapter.HomeViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    private var currentPage = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initObserver()
        setUpView()
        setUpTabBar()

        return binding.root
    }

    private fun setUpView() {
        binding.svHomeClick.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_search)
        }
    }

    private fun initObserver() {
        viewModel.getNowPlayingMovies()
        viewModel.nowPlayingResponse.observe(viewLifecycleOwner){
            setUpCarousel(it)
        }

        viewModel.getPopularMovies()
        viewModel.popularResponse.observe(viewLifecycleOwner){
            setUpPopularMovies(it)
        }

        viewModel.getUpComingMovies()
        viewModel.upcomingResponse.observe(viewLifecycleOwner){
            setUpUpcomingMovies(it)
        }
    }

    private fun setUpUpcomingMovies(resource: Resource<MovieResult>?) {
        when(resource){
            is Resource.Success -> {
                binding.rvPopularMovies.apply {
                    val mAdapter = HorizontalListAdapter()
                    adapter = mAdapter
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    mAdapter.setData(resource.data?.movie)

                    mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                        override fun onItemClicked(id: Int) {
                            startActivity(
                                Intent(context, DetailActivity::class.java)
                                    .putExtra(Constant.EXTRA_MOVIE_ID, id)
                            )
                        }

                    })
                }
            }
            else -> {}
        }
    }

    private fun setUpPopularMovies(resource: Resource<MovieResult>?) {
        when(resource){
            is Resource.Success -> {
                binding.rvUpcomingMovies.apply {
                    val mAdapter = HorizontalListAdapter()
                    adapter = mAdapter
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    mAdapter.setData(resource.data?.movie)

                    mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                        override fun onItemClicked(id: Int) {
                            startActivity(
                                Intent(context, DetailActivity::class.java)
                                    .putExtra(Constant.EXTRA_MOVIE_ID, id)
                            )
                        }

                    })
                }
            }
            else -> {}
        }
    }

    private fun setUpCarouselMovieData(movie: List<Movie>, currentItem: Int) {
        setUpGenreList(movie[currentItem].genre)
        binding.tvCarouselTitle.text = movie[currentItem].title
    }

    private fun setUpCarousel(movie: Resource<MovieResult>) {
        binding.rvCarousel.apply {
            val mAdapter = CarouselAdapter()
            adapter = mAdapter
            val mLayoutManager = CenterItemLayoutManager(context, RecyclerView.HORIZONTAL, false)
            layoutManager = mLayoutManager
            movie.data?.let { setUpCarouselMovieData(it.movie, 0) }
            mAdapter.setData(movie.data?.movie)

            PagerSnapHelper().attachToRecyclerView(this)
            onFlingListener = null

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val position: Int = getCurrentItem()
                        movie.data?.let { setUpCarouselMovieData(it.movie, position) }
                    }
                }
            })


        }
    }

    private fun setUpTabBar() {
        binding.vpHome.apply {
            adapter = activity?.let { HomeViewPagerAdapter(it) }
        }

        TabLayoutMediator(binding.tabLayout, binding.vpHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Top Rated Movie"
                1 -> tab.text = "Latest Movie"
            }
        }.attach()
    }


    private fun getCurrentItem(): Int {
        return (binding.rvCarousel.layoutManager as CenterItemLayoutManager)
            .findFirstVisibleItemPosition()
    }

    private fun setUpGenreList(movie: List<String>) {
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