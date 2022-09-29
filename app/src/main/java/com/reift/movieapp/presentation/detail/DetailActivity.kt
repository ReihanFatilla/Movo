package com.reift.movieapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        viewModel.detailResponse.observe(this){
            setUpMovieDetail(it)
        }


    }

    private fun setUpMovieDetail(resource: Resource<MovieDetail>) {
        binding.apply {
            with(resource.data){
                if(this == null) return
                Glide.with(applicationContext)
                    .load(posterPath)
                    .into(imgPoster)

                tvTitle.text = title
                tvRatingCount.text = voteAverage.toString()
                tvRatersCount.text = voteCount.toString()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}