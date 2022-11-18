package com.reift.movo.presentation.home.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
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
        viewModel.getMoviesByCategory(category)
        viewModel.movieResponse.observe(viewLifecycleOwner){
            setUpHomeTabRv(it)
        }
    }

    private fun setUpHomeTabRv(resource: Resource<MovieResult>) {
        when(resource){
            is Resource.Success -> {
                binding.rvHomeTab.apply {
                    val mAdapter = VerticalListAdapter()
                    layoutManager = LinearLayoutManager(context)
                    adapter = mAdapter
                    mAdapter.setData(resource.data?.movie)
                    mAdapter.setOnItemClickCallback(object: OnItemClickCallback{
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

}