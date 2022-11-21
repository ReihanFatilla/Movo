package com.reift.movo.presentation.search.fragment

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
import com.reift.movo.databinding.FragmentSearchTabBinding
import com.reift.movo.presentation.detail.DetailActivity
import com.reift.movo.presentation.search.SearchViewModel
import com.reift.movo.presentation.search.fragment.adapter.SearchMediaViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchTabFragment : Fragment() {

    private var _binding: FragmentSearchTabBinding? = null
    private val binding get() = _binding as FragmentSearchTabBinding

    private val viewModel: SearchViewModel by viewModel()

    private lateinit var query: String
    private lateinit var page: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchTabBinding.inflate(layoutInflater)

        query = arguments?.getString(Constant.BUNDLE_SEARCH_QUERY) ?: ""
        page = arguments?.getString(SearchMediaViewPagerAdapter.BUNDLE_SEARCH_PAGE) ?: ""

        initObserver()

        return binding.root
    }

    private fun initObserver() {
        viewModel.searchMovie(query, page)
        viewModel.movieResponse.observe(viewLifecycleOwner){

        }

        viewModel.searchTv(query, page)
        viewModel.tvResponse.observe(viewLifecycleOwner){

        }
    }
}