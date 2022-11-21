package com.reift.movo.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.google.android.material.tabs.TabLayoutMediator
import com.reift.movo.R
import com.reift.movo.databinding.FragmentSearchBinding
import com.reift.movo.presentation.search.fragment.adapter.SearchViewPagerAdapter


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding as FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater)

        setUpMediaViewPager("")
        setUpSearchView()

        return binding.root
    }

    private fun setUpSearchView() {
        binding.svSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query == null) return false
                setUpMediaViewPager(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setUpMediaViewPager(query: String) {
        binding.apply {
            vpSearch.adapter = activity?.let { SearchViewPagerAdapter(it, query) }
            TabLayoutMediator(searchMediaTabs, vpSearch){ tab, position ->
                when (position) {
                    0 -> tab.text = "Movie"
                    1 -> tab.text = "Tv Show"
                }
            }.attach()
        }
    }
}