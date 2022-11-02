package com.reift.movo.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.reift.movo.utils.HelperFunction
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.movo.R
import com.reift.movo.databinding.ActivityDetailBinding
import com.reift.movo.presentation.detail.fragments.adapter.DetailViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    private val viewModel: DetailViewModel by viewModel()

    private var _movieDetail: Resource<MovieDetail>? = null
    private val movieDetail get() = _movieDetail as Resource<MovieDetail>

    private lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        HelperFunction.transparentStatusbar(this)

        id = intent.getIntExtra(Constant.INTENT_TO_DETAIL, 0).toString()

        initView()
        initObserver()
    }

    private fun initView() {
        binding.toolbarDetail.apply {
            setNavigationIcon(R.drawable.ic_back)
            setSupportActionBar(this)
        }
    }

    private fun setUpTabBar() {
        if(movieDetail.data == null) return
        binding.vpOverviewAndOther.apply {
            adapter = movieDetail.data?.let { DetailViewPagerAdapter(this@DetailActivity, this@DetailActivity.id, it) }
            isUserInputEnabled = false;
        }

        TabLayoutMediator(binding.tabDetail, binding.vpOverviewAndOther) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.overview)
                1 -> tab.text = getString(R.string.others)
            }
        }.attach()
    }

    private fun setUpMovieDetail() {
        binding.apply {
            with(movieDetail.data){
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

    private fun initObserver() {

        viewModel.getMovieDetail(id)
        viewModel.detailResponse.observe(this){
            _movieDetail = it
            setUpMovieDetail()
            setUpTabBar()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}