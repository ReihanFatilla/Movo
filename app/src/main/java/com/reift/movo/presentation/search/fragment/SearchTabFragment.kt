package com.reift.movo.presentation.search.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.movo.adapter.VerticalListAdapter
import com.reift.movo.databinding.FragmentSearchTabBinding
import com.reift.movo.presentation.search.SearchViewModel
import com.reift.movo.presentation.search.fragment.adapter.SearchMediaViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchTabFragment : Fragment() {

    private var _binding: FragmentSearchTabBinding? = null
    private val binding get() = _binding as FragmentSearchTabBinding

    private val viewModel: SearchViewModel by viewModel()

    private lateinit var query: String
    private var page = 1
    private lateinit var mediaType: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchTabBinding.inflate(layoutInflater)

        query = arguments?.getString(Constant.BUNDLE_SEARCH_QUERY) ?: ""
        page = arguments?.getInt(SearchMediaViewPagerAdapter.BUNDLE_SEARCH_PAGE) ?: 1
        mediaType = arguments?.getString(Constant.BUNDLE_MEDIA_TYPE) ?: ""

        initObserver()

        return binding.root
    }

    private fun initObserver() {
        when(mediaType){
            Constant.BUNDLE_MEDIA_MOVIE -> {
                viewModel.searchMovie(query, page.toString())
                Log.i("asdsadasda", "current page: $page")
                viewModel.movieResponse.observe(viewLifecycleOwner){
                    setUpSearchRV(it)
                }
            }
        }
    }

    private fun <T> setUpSearchRV(resource: Resource<T>?) {
        when(resource){
            is Resource.Success -> {
                when(resource.data){
                    is MovieResult -> {
                        val result = resource.data as MovieResult
                        binding.rvSearch.apply {
                            val mAdapter = VerticalListAdapter()
                            layoutManager = LinearLayoutManager(context)
                            adapter = mAdapter
                            mAdapter.setData(result.movie)
                        }
                    }
                }
            }
            else -> {}
        }
    }
}