package com.reift.movieapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.reift.movieapp.utils.HelperFunction
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.movieapp.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    private val viewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        HelperFunction.transparentStatusbar(this)

        val id = intent.getIntExtra(Constant.INTENT_TO_DETAIL, 0).toString()

        viewModel.getMovieDetail(id)
        viewModel.detailResponse.observe(this){
            setUpMovieDetail(it)
        }


    }

    private fun setUpMovieDetail(resource: Resource<MovieDetail>) {
        binding.apply {
            Log.i("YahaaErroLagi", "setUpMovieDetail: ${resource.message}")
            with(resource.data){
                if(this == null) return
                Glide.with(applicationContext)
                    .load(Constant.IMAGE_BASE_URL+posterPath)
                    .into(imgPoster)

                tvTitle.text = title
                collapsingToolbar.title = title
                tvRatingCount.text = voteAverage.toString().take(3)
                tvRatersCount.text = "($voteCount)"
                tvDurationOrEpisode.text = HelperFunction.durationFormatter(duration)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}