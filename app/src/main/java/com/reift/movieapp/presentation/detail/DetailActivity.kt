package com.reift.movieapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reift.movieapp.R
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
    }
}