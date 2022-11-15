package com.reift.movo.presentation.home.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.reift.core.constant.Constant
import com.reift.movo.R
import com.reift.movo.databinding.FragmentHomeBinding
import com.reift.movo.databinding.FragmentHomeTabBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeTabFragment : Fragment() {

    private val viewModel: HomeTabViewModel by viewModel()

    private var _binding: FragmentHomeTabBinding? = null
    private val binding get() = _binding as FragmentHomeTabBinding

    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeTabBinding.inflate(layoutInflater)

        category = arguments?.getString(Constant.BUNDLE_MOVIE_CATEGORY) ?: Constant.NOW_PLAYING

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        viewModel.getMoviesByCategory(category)
        viewModel.movieResponse.observe(viewLifecycleOwner){
            setUpHomeTabRv()
        }
    }

    private fun setUpHomeTabRv() {
        binding.rvHomeTab.apply {
            layoutManager = LinearLayoutManager(context)

        }
    }

}