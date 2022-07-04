package com.reift.movieapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.movieapp.HelperFunction
import com.reift.movieapp.R
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.response.DetailResponse
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

        _viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        HelperFunction.transparentStatusbar(this)

        val id = intent.getIntExtra(Constant.INTENT_TO_DETAIL, 0).toString()

        viewModel.getMovieDetail(id)
        viewModel.detailResponse.observe(this){
            setUpDetailView(it)
            Log.i("setUpDetailView", "setUpDetailView: ${it?.title}")
        }
    }

    private fun setUpDetailView(it: DetailResponse?) {
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(Constant.IMAGE_BASE_URL+it?.posterPath)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgMoviePoster)
            Glide.with(this@DetailActivity)
                .load(Constant.IMAGE_BASE_URL+it?.posterPath)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 5)))
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(binding.imgDetailBackground)

            collapsingToolbar.title = it?.title
            Log.i("setUpDetailView", "setUpDetailView: ${it?.title}")
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}