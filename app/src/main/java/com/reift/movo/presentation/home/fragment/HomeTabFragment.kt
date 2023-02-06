package com.reift.movo.presentation.home.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.model.tv.TvResult
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.movo.adapter.VerticalListAdapter
import com.reift.movo.databinding.FragmentHomeTabBinding
import com.reift.movo.presentation.allmovietv.AllMovieTvViewModel
import com.reift.movo.presentation.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeTabFragment : Fragment() {

    private val viewModel: AllMovieTvViewModel by viewModel()

    private var _binding: FragmentHomeTabBinding? = null
    private val binding get() = _binding as FragmentHomeTabBinding

    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeTabBinding.inflate(layoutInflater)

        category = arguments?.getString(Constant.BUNDLE_MOVIE_CATEGORY) ?: Constant.NOW_PLAYING_MOVIE

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        if(isMovieType()){
            viewModel.getMoviesByCategory(category)
            viewModel.movieResponse.observe(viewLifecycleOwner){
                setUpHomeTabRv(it)
            }
        } else {
            viewModel.getTvByCategory(category)
            viewModel.tvResponse.observe(viewLifecycleOwner){
                setUpHomeTabRv(it)
            }
        }
    }

    private fun <T> setUpHomeTabRv(resource: Resource<T>) {
        when(resource){
            is Resource.Success -> {
                when(resource.data){
                    is MovieResult -> {
                        val result = resource.data as MovieResult
                        displayMovie(result)

                    }
                    is TvResult -> {
                        val result = resource.data as TvResult
                        displayTv(result)
                    }
                }
            }
            else -> {}
        }

    }

    private fun displayTv(result: TvResult) {
        binding.rvHomeTab.apply {
            val mAdapter = VerticalListAdapter<Tv>()
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
            mAdapter.setData(result.tv)
            mAdapter.setOnItemClickCallback(object: OnItemClickCallback{
                override fun onItemClicked(id: Int) {
                    startActivity(
                        Intent(context, DetailActivity::class.java)
                            .putExtra(Constant.EXTRA_DETAIl_ID, id)
                            .putExtra(Constant.EXTRA_MEDIA_TYPE, Constant.EXTRA_MEDIA_TV)
                    )
                }

            })
        }
    }

    private fun displayMovie(result: MovieResult) {
        binding.rvHomeTab.apply {
            val mAdapter = VerticalListAdapter<Movie>()
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
            mAdapter.setData(result.movie)
            mAdapter.setOnItemClickCallback(object: OnItemClickCallback{
                override fun onItemClicked(id: Int) {
                    startActivity(
                        Intent(context, DetailActivity::class.java)
                            .putExtra(Constant.EXTRA_DETAIl_ID, id)
                            .putExtra(Constant.EXTRA_MEDIA_TYPE, Constant.EXTRA_MEDIA_MOVIE)
                    )
                }

            })
        }
    }

    private fun isMovieType(): Boolean {
        return arguments?.getString(Constant.BUNDLE_MEDIA_TYPE) == Constant.BUNDLE_MEDIA_MOVIE
    }

}