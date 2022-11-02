package com.reift.movo.presentation.detail.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.core.domain.model.detail.Review
import com.reift.movo.adapter.ReviewAdapter
import com.reift.movo.databinding.FragmentOtherBinding
import com.reift.movo.presentation.detail.DetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class OtherFragment : Fragment() {

    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding as FragmentOtherBinding

    private var _movieDetail: MovieDetail? = null
    private val movieDetail get() = _movieDetail as MovieDetail

    private val viewModel: DetailViewModel by viewModel()

    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(layoutInflater)

        _movieDetail = arguments?.getParcelable(Constant.BUNDLE_MOVIE_DETAIL)
        id = arguments?.getString(Constant.BUNDLE_MOVIE_ID) ?: "0"

        initObserver()

        return binding.root
    }

    private fun initObserver() {
        viewModel.getMovieReviews(id)
        viewModel.reviewResponse.observe(viewLifecycleOwner) {
            setUpReviews(it)
        }
    }

    private fun setUpReviews(resource: Resource<List<Review>>?) {
        when (resource) {
            is Resource.Success -> {
                if (resource.data == null) return
                binding.rvReviews.apply {
                    val mAdapter = ReviewAdapter()
                    adapter = mAdapter
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    mAdapter.setData(resource.data)
                }
            }
        }

    }
}