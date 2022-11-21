package com.reift.movo.presentation.search.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.reift.core.constant.Constant
import com.reift.movo.R
import com.reift.movo.databinding.FragmentSearchMediaBinding
import com.reift.movo.databinding.FragmentSearchTabBinding
import com.reift.movo.presentation.search.SearchViewModel
import com.reift.movo.presentation.search.fragment.adapter.SearchMediaViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchMediaFragment : Fragment() {

    private var _binding: FragmentSearchMediaBinding? = null
    private val binding get() = _binding as FragmentSearchMediaBinding

    private val viewModel: SearchViewModel by viewModel()

    private lateinit var mediaType: String
    private lateinit var query: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMediaBinding.inflate(layoutInflater)

        mediaType = arguments?.getString(Constant.BUNDLE_MEDIA_TYPE).orEmpty()
        query = arguments?.getString(Constant.BUNDLE_SEARCH_QUERY).orEmpty()

        setUpSearchTabViewPager(0, mediaType)
        initObserver()

        return binding.root
    }

    private fun initObserver() {
        when(mediaType){
            Constant.BUNDLE_MEDIA_MOVIE -> {
                viewModel.searchMovie(query)
                viewModel.movieResponse.observe(viewLifecycleOwner){
                    setUpSearchTabViewPager(it.data?.totalPages ?: 1, mediaType)
                }
            }
        }
    }

    private fun setUpSearchTabViewPager(pageTotal: Int, mediaType: String) {
        binding.apply {
            vpSearchPage.adapter = activity?.let { SearchMediaViewPagerAdapter(it, mediaType, query, pageTotal) }

            TabLayoutMediator(tabSearchPage, vpSearchPage){ tab, position ->
                tab.text = (position+1).toString()
            }
        }
    }

}