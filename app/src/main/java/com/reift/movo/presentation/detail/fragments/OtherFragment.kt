package com.reift.movo.presentation.detail.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.Review
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.model.tv.TvResult
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.movo.adapter.HorizontalListAdapter
import com.reift.movo.adapter.ReviewAdapter
import com.reift.movo.databinding.FragmentOtherBinding
import com.reift.movo.presentation.detail.DetailActivity
import com.reift.movo.presentation.detail.DetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class OtherFragment : Fragment() {

    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding as FragmentOtherBinding

    private val viewModel: DetailViewModel by viewModel()

    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(layoutInflater)

        id = arguments?.getString(Constant.BUNDLE_MOVIE_ID) ?: "0"

        initObserver()

        return binding.root
    }

    private fun initObserver() {
        if (isMovieType()) {
            viewModel.getMovieReviews(id)
            viewModel.reviewResponse.observe(viewLifecycleOwner) {
                setUpReviews(it)
            }

            viewModel.getSimilarMovies(id)
            viewModel.movieSimilarResponse.observe(viewLifecycleOwner) {
                setUpSimilarMovies(it)
            }

            viewModel.getRecommendationsMovies(id)
            viewModel.movieRecommendationsResponse.observe(viewLifecycleOwner) {
                setUpRecommendationsMovies(it)
            }
        } else {
            viewModel.getTvDetail(id)
            viewModel.reviewResponse.observe(viewLifecycleOwner) {
                setUpReviews(it)
            }

            viewModel.getSimilarTv(id)
            viewModel.tvSimilarResponse.observe(viewLifecycleOwner) {
                setUpSimilarMovies(it)
            }

            viewModel.getSimilarTv(id)
            viewModel.tvRecommendationsResponse.observe(viewLifecycleOwner) {
                setUpRecommendationsMovies(it)
            }
        }

    }

    private fun <T> setUpRecommendationsMovies(resource: Resource<T>?) {
        when (resource) {
            is Resource.Success -> {
                when (resource.data) {
                    is MovieResult -> {
                        val result = resource.data as MovieResult
                        binding.rvRecommendations.apply {
                            val mAdapter = HorizontalListAdapter<Movie>()
                            adapter = mAdapter
                            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                            mAdapter.setData(result.movie)

                            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                                override fun onItemClicked(id: Int) {
                                    startActivity(
                                        Intent(context, DetailActivity::class.java)
                                            .putExtra(Constant.EXTRA_DETAIl_ID, id)
                                    )
                                }
                            })
                        }
                    }
                    is TvResult -> {
                        val result = resource.data as TvResult
                        binding.rvRecommendations.apply {
                            val mAdapter = HorizontalListAdapter<Tv>()
                            adapter = mAdapter
                            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                            mAdapter.setData(result.tv)

                            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                                override fun onItemClicked(id: Int) {
                                    startActivity(
                                        Intent(context, DetailActivity::class.java)
                                            .putExtra(Constant.EXTRA_DETAIl_ID, id)
                                    )
                                }
                            })
                        }
                    }

                }
            }
            else -> {}
        }
    }

    private fun <T> setUpSimilarMovies(resource: Resource<T>?) {
        when (resource) {
            is Resource.Success -> {
                when(resource.data){
                    is MovieResult -> {
                        val result = resource.data as MovieResult
                        binding.rvSimilar.apply {
                            val mAdapter = HorizontalListAdapter<Movie>()
                            adapter = mAdapter
                            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                            mAdapter.setData(result.movie)

                            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                                override fun onItemClicked(id: Int) {
                                    startActivity(
                                        Intent(context, DetailActivity::class.java)
                                            .putExtra(Constant.EXTRA_DETAIl_ID, id)
                                    )
                                }

                            })
                        }
                    }
                    is TvResult -> {
                        val result = resource.data as TvResult
                        binding.rvSimilar.apply {
                            val mAdapter = HorizontalListAdapter<Tv>()
                            adapter = mAdapter
                            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                            mAdapter.setData(result.tv)

                            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                                override fun onItemClicked(id: Int) {
                                    startActivity(
                                        Intent(context, DetailActivity::class.java)
                                            .putExtra(Constant.EXTRA_DETAIl_ID, id)
                                    )
                                }

                            })
                        }
                    }
                }

            }
            else -> {}
        }
    }

    private fun setUpReviews(resource: Resource<List<Review>>?) {
        when (resource) {
            is Resource.Success -> {
                binding.rvReviews.apply {
                    val mAdapter = ReviewAdapter()
                    adapter = mAdapter
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    mAdapter.setData(resource.data)
                }
            }
            else -> {}
        }

    }

    private fun isMovieType(): Boolean {
        return when (arguments?.getString(Constant.BUNDLE_MEDIA_TYPE)) {
            Constant.INTENT_MEDIA_MOVIE -> {
                true
            }
            Constant.INTENT_MEDIA_TV -> {
                false
            }
            else -> {
                true
            }
        }
    }
}