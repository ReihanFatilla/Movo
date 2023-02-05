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
import com.reift.core.domain.model.detail.*
import com.reift.movo.adapter.ActorAdapter
import com.reift.movo.adapter.WallpaperAdapter
import com.reift.movo.databinding.FragmentOverviewBinding
import com.reift.movo.presentation.detail.DetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding as FragmentOverviewBinding

    private var _movieDetail: MovieDetail? = null
    private val movieDetail get() = _movieDetail as MovieDetail

    private var _tvDetail: TvDetail? = null
    private val tvDetail get() = _tvDetail as TvDetail

    private val viewModel: DetailViewModel by viewModel()

    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(layoutInflater)

        id = arguments?.getString(Constant.BUNDLE_MOVIE_ID) ?: "0"

        initObserver()
        setUpView()

        return binding.root
    }

    private fun setUpView() {
        if(isMovieType()){
            _movieDetail = arguments?.getParcelable(Constant.BUNDLE_MOVIE_DETAIL)
            binding.tvSynopsis.text = movieDetail.overview
        } else {
            _tvDetail = arguments?.getParcelable(Constant.BUNDLE_MOVIE_DETAIL)
            binding.tvSynopsis.text = tvDetail.overview
        }
    }

    private fun setTrailerWebView(resource: Resource<List<Video>>) {
        binding.apply {
            when (resource) {
                is Resource.Success -> {
                    if(resource.data?.isEmpty() == true) {

                    } else {
                        val frameVideo = "<html><body style=\"margin: 0;margin-top: -30px;\"><br><iframe  width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/${
                            resource.data?.get(
                                0
                            )?.key
                        }\" frameborder=\"0\" allowfullscreen></iframe></body></html>"

                        val webSettings = webViewTrailer.settings
                        webSettings.javaScriptEnabled = true;
                        webViewTrailer.loadData(frameVideo, "text/html", "utf-8")
                    }

                }
                else -> {}
            }
        }
    }

    private fun initObserver() {
        if(isMovieType()){
            viewModel.getMovieActor(id)
            viewModel.actorResponse.observe(viewLifecycleOwner) {
                setUpActorRV(it)
            }

            viewModel.getMovieWallpaper(id)
            viewModel.wallpaperResponse.observe(viewLifecycleOwner) {
                setUpWallpaperRV(it)
            }

            viewModel.getMovieTrailer(id)
            viewModel.videoResponse.observe(viewLifecycleOwner) {
                setTrailerWebView(it)
            }
        } else {
            viewModel.getTvActor(id)
            viewModel.actorResponse.observe(viewLifecycleOwner) {
                setUpActorRV(it)
            }

            viewModel.getTvTrailer(id)
            viewModel.wallpaperResponse.observe(viewLifecycleOwner) {
                setUpWallpaperRV(it)
            }

            viewModel.getTvTrailer(id)
            viewModel.videoResponse.observe(viewLifecycleOwner) {
                setTrailerWebView(it)
            }
        }
    }

    private fun setUpWallpaperRV(resource: Resource<Wallpaper>?) {
        when (resource) {
            is Resource.Success -> {
                binding.rvWallpaper.apply {
                    val mAdapter = WallpaperAdapter()
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    adapter = mAdapter
                    resource.data?.wallpaperUrl?.let { mAdapter.setData(it) }
                }
            }
            else -> {}
        }

    }

    private fun setUpActorRV(resource: Resource<List<Actor>>?) {
        when (resource) {
            is Resource.Success -> {
                binding.rvActors.apply {
                    val mAdapter = ActorAdapter()
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    adapter = mAdapter
                    mAdapter.setData(resource.data)
                }
            }
            else -> {}
        }

    }

    private fun isMovieType(): Boolean {
        return when (arguments?.getString(Constant.BUNDLE_MEDIA_TYPE)) {
            Constant.BUNDLE_MEDIA_MOVIE -> {
                true
            }
            Constant.BUNDLE_MEDIA_TV -> {
                false
            }
            else -> {
                true
            }
        }
    }
}