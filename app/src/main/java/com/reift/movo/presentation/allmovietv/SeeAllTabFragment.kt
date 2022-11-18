package com.reift.movo.presentation.allmovietv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.movo.R
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.movo.adapter.VerticalListAdapter
import com.reift.movo.databinding.FragmentSeeAllTabBinding
import com.reift.movo.presentation.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SeeAllTabFragment : Fragment() {

    private val viewModel: AllMovieTvViewModel by viewModel()

    private var _binding: FragmentSeeAllTabBinding? = null
    private val binding get() = _binding as FragmentSeeAllTabBinding

    private lateinit var category: String
    private var page = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeeAllTabBinding.inflate(layoutInflater)

        category = arguments?.getString(Constant.BUNDLE_MOVIE_CATEGORY) ?: Constant.NOW_PLAYING
        page = arguments?.getInt(Constant.BUNDLE_MOVIE_PAGE) ?: 1

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        viewModel.getMoviesByCategory(category)
        viewModel.movieResponse.observe(viewLifecycleOwner){
            setUpHomeTabRv(it)
        }
    }

    private fun <T> setUpHomeTabRv(resource: Resource<T>) {
        when(resource){
            is Resource.Success -> {
                when(resource.data){
                    is MovieResult -> {
                        val result = resource.data as MovieResult
                        binding.rvSeeAllTab.apply {
                            val mAdapter = VerticalListAdapter()
                            layoutManager = LinearLayoutManager(context)
                            adapter = mAdapter
                            mAdapter.setData(result.movie)

                            mAdapter.setOnItemClickCallback(object: OnItemClickCallback {
                                override fun onItemClicked(id: Int) {
                                    startActivity(
                                        Intent(context, DetailActivity::class.java)
                                            .putExtra(Constant.EXTRA_MOVIE_ID, id)
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
}