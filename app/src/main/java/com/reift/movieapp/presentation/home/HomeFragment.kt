package com.reift.movieapp.presentation.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.reift.movieapp.R
import com.reift.movieapp.databinding.FragmentHomeBinding
import com.reift.movieapp.presentation.home.component.CarouselAdapter
import com.reift.movieapp.presentation.home.component.CarouselItem
import java.lang.Math.abs

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var _viewModel: HomeViewModel? = null
    private val viewModel get() = _viewModel!!

    private val carouselHandler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setUpTabBar()
        setUpCarousel()

        return binding.root
    }

    private fun setUpTabBar() {
    }

    private fun setUpCarousel() {
        val carouselItems: MutableList<CarouselItem> = ArrayList()
        carouselItems.add(CarouselItem(R.drawable.sample_movie_poster))
        carouselItems.add(CarouselItem(R.drawable.sample_movie_poster))
        carouselItems.add(CarouselItem(R.drawable.sample_movie_poster))
        carouselItems.add(CarouselItem(R.drawable.sample_movie_poster))

        binding.vpCarousel.apply {
            adapter = CarouselAdapter(carouselItems, binding.vpCarousel)
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.apply {
                addTransformer(MarginPageTransformer(30))
                addTransformer {
                        page, position ->
                    val r = 1 - abs(position)
                    page.scaleY = 0.85F + r * 0.1f
                }
            }

            setPageTransformer(compositePageTransformer)

            val carouselRunnable = Runnable {
                currentItem += 1
            }

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    carouselHandler.removeCallbacks(carouselRunnable)
                    carouselHandler.postDelayed(carouselRunnable, 3000)
                }
            })
        }

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}