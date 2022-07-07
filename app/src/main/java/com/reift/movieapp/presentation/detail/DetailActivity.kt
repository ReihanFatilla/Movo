package com.reift.movieapp.presentation.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.movieapp.HelperFunction
import com.reift.movieapp.`interface`.OnItemClickCallback
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.data.response.CastItem
import com.reift.movieapp.data.response.DetailResponse
import com.reift.movieapp.data.response.ResultsItemReview
import com.reift.movieapp.databinding.ActivityDetailBinding
import com.reift.movieapp.presentation.detail.component.CreditAdapter
import com.reift.movieapp.presentation.detail.component.ReviewAdapter
import com.reift.movieapp.presentation.home.component.HorizontalListAdapter
import jp.wasabeef.glide.transformations.BlurTransformation


class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    private var _viewModel: DetailViewModel? = null
    private val viewModel get() = _viewModel as DetailViewModel

//    private lateinit var intentType: String

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

        if(intentType == Constant.INTENT_TV) {
            viewModel.getDetail(Constant.MEDIA_TV, id)
            viewModel.getSimilarList(Constant.MEDIA_TV, id, Constant.UNITED_STATES, "1")
            viewModel.getCreditList(Constant.MEDIA_TV, id, Constant.UNITED_STATES)
            viewModel.getReviewList(Constant.MEDIA_TV, id, "1")
        } else {
            viewModel.getDetail(Constant.MEDIA_MOVIE, id)
            viewModel.getSimilarList(Constant.MEDIA_MOVIE, id, Constant.UNITED_STATES, "1")
            viewModel.getCreditList(Constant.MEDIA_MOVIE, id, Constant.UNITED_STATES)
            viewModel.getReviewList(Constant.MEDIA_MOVIE, id, "1")
        }
        viewModel.detailResponse.observe(this){
            setUpDetailView(it, intentType)
        }

        viewModel.similarResponse.observe(this){
            setUpSimilarRecyclerView(it.results as List<ResultsItem>?)
        }

        viewModel.creditResponse.observe(this){
            setUpCreditRecyclerView(it.cast as List<CastItem>?)
        }


        viewModel.reviewResponse.observe(this){
            setUpReviewRecyclerView(it.results as List<ResultsItemReview>?)
        }

    }

    private fun setUpReviewRecyclerView(list: List<ResultsItemReview>?) {
        binding.rvReviews.apply {
            val mAdapter = ReviewAdapter()
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@DetailActivity, RecyclerView.HORIZONTAL, false)
            mAdapter.setData(list)
        }
    }

    private fun setUpCreditRecyclerView(credit: List<CastItem>?) {
        binding.rvCredits.apply {
            val mAdapter = CreditAdapter()
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@DetailActivity, RecyclerView.HORIZONTAL, false)
            mAdapter.setData(credit)
        }
    }

    private fun setUpSimilarRecyclerView(movie: List<ResultsItem>?) {
        binding.rvSimilar.apply {
            val mAdapter = HorizontalListAdapter()
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@DetailActivity, RecyclerView.HORIZONTAL, false)
            mAdapter.setData(movie)

            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: ResultsItem) {
                    val intent = Intent(this@DetailActivity, DetailActivity::class.java)
                    if(data.title == null){
                        intent.putExtra(Constant.INTENT_TO_DETAIL, data.id)
                        intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_TV)
                    } else {
                        intent.putExtra(Constant.INTENT_TO_DETAIL, data.id)
                        intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_MOVIE)
                    }
                    startActivity(intent)
                }
            })
        }
    }

    private fun setUpDetailView(it: DetailResponse?, intentType: String?) {
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

            tvOverview.text = it?.overview
            tvRatingCount.text = it?.voteAverage.toString()
            tvRatersCount.text = it?.voteCount.toString()
            tvMinOrEpisode.text= it?.runtime.toString()
            if(intentType == Constant.INTENT_TV){
                tvMinOrEpisode.text = it?.numberOfEpisodes.toString()
                tvDurationOrEpisode.text = "Episodes"
                tvMin.text = ""
            } else {
                tvMinOrEpisode.text= it?.runtime.toString()
                tvDurationOrEpisode.text = "Duration"
                tvMin.text = "min"
            }
            tvReleaseDate.text = HelperFunction.dateFormatter(it?.releaseDate ?: it?.firstRelease.toString())
            collapsingToolbar.title = it?.title ?: it?.name
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}