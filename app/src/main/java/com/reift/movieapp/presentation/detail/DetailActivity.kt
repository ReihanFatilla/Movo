package com.reift.movieapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.reift.movieapp.HelperFunction
import com.reift.movieapp.R
import com.reift.movieapp.databinding.ActivityDetailBinding
import jp.wasabeef.glide.transformations.BlurTransformation


class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    private var _viewModel: DetailViewModel? = null
    private val viewModel get() = _viewModel as DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_detail);


        HelperFunction.transparentStatusbar(this)


        Glide.with(this)
            .load(R.drawable.sample_movie_poster)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(35, 5)))
            .into(binding.imgDetailBackground)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}