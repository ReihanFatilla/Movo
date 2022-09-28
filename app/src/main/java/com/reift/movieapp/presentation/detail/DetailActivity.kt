package com.reift.movieapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.reift.movieapp.utils.HelperFunction
import com.reift.core.constant.Constant
import com.reift.movieapp.databinding.ActivityDetailBinding


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
        val intentType = intent.getStringExtra(Constant.INTENT_TYPE)

        Log.i("intentType", "$intentType")

//        if(intentType == Constant.INTENT_TV) {
//            viewModel.getDetail(Constant.MEDIA_TV, id)
//            viewModel.getSimilarList(Constant.MEDIA_TV, id, Constant.UNITED_STATES, "1")
//            viewModel.getCreditList(Constant.MEDIA_TV, id, Constant.UNITED_STATES)
//            viewModel.getReviewList(Constant.MEDIA_TV, id, "1")
//        } else {
//            viewModel.getDetail(Constant.MEDIA_MOVIE, id)
//            viewModel.getSimilarList(Constant.MEDIA_MOVIE, id, Constant.UNITED_STATES, "1")
//            viewModel.getCreditList(Constant.MEDIA_MOVIE, id, Constant.UNITED_STATES)
//            viewModel.getReviewList(Constant.MEDIA_MOVIE, id, "1")
//        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}