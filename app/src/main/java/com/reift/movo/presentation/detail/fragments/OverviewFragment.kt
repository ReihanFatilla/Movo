package com.reift.movo.presentation.detail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.Actor
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.core.domain.model.detail.Video
import com.reift.core.domain.model.detail.Wallpaper
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

    private val viewModel: DetailViewModel by viewModel()

    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(layoutInflater)

        _movieDetail = arguments?.getParcelable(Constant.BUNDLE_MOVIE_DETAIL)
        id = arguments?.getString(Constant.BUNDLE_MOVIE_ID) ?: "0"

        initObserver()

        return binding.root
    }

    private fun setTrailerWebView(resource: Resource<List<Video>>) {
        binding.apply {
            if(resource.data == null) return
            val frameVideo =
"<html><body style=\"margin: 0\"><br><iframe  width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/${resource.data!![0].key}\" frameborder=\"0\" allowfullscreen></iframe></body></html>"

            val webSettings = webViewTrailer.settings
            webSettings.javaScriptEnabled = true;
            webViewTrailer.loadData(frameVideo, "text/html", "utf-8")
        }
    }

    private fun initObserver() {
        viewModel.getMovieActor(id)
        viewModel.actorResponse.observe(viewLifecycleOwner){
            setUpActorRV(it)
        }

        viewModel.getMovieWallpaper(id)
        viewModel.wallpaperResponse.observe(viewLifecycleOwner){
            setUpWallpaperRV(it)
        }

        viewModel.getMovieTrailer(id)
        viewModel.videoResponse.observe(viewLifecycleOwner){
            setTrailerWebView(it)
        }
    }

    private fun setUpWallpaperRV(resource: Resource<Wallpaper>?) {
        binding.rvWallpaper.apply {
            with(resource?.data){
                if(this == null) return
                val mAdapter = WallpaperAdapter()
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = mAdapter
                mAdapter.setData(this.wallpaperUrl)
            }
        }
    }

    private fun setUpActorRV(resource: Resource<List<Actor>>?) {
        binding.rvActors.apply {
            with(resource?.data){
                if (this == null) return
                val mAdapter = ActorAdapter()
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = mAdapter
                mAdapter.setData(this)
            }
        }
    }
}