package com.reift.movo.presentation.allmovietv

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.movo.R
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.movo.adapter.VerticalListAdapter
import com.reift.movo.databinding.ActivityMainBinding
import com.reift.movo.databinding.FragmentAllMovieTvBinding
import com.reift.movo.presentation.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class AllMovieTvFragment : Fragment() {

    private val viewModel: AllMovieTvViewModel by viewModel()

    private var _binding: FragmentAllMovieTvBinding? = null
    private val binding get() = _binding as FragmentAllMovieTvBinding

    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllMovieTvBinding.inflate(layoutInflater)

        category = arguments?.getString(Constant.BUNDLE_MOVIE_CATEGORY) ?: Constant.NOW_PLAYING

        setUpPageBar()

        return binding.root
    }

    private fun setUpPageBar() {
        TabLayoutMediator(binding.pageTabs, binding.vpPage){ tab, position ->
            tab.text = position.toString()
        }.attach()
    }


}