package com.reift.movieapp.presentation.home.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.reift.movieapp.databinding.ItemCarouselHomeBinding

class CarouselAdapter(
    carouselItem: MutableList<CarouselItem>,
    viewPager: ViewPager
): RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    private val carouselItem: List<CarouselItem> = carouselItem

    class CarouselViewHolder(val binding: ItemCarouselHomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CarouselViewHolder(
        ItemCarouselHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(imgMovie.context)
                .load(carouselItem[position].image)
                .into(imgMovie)
        }
    }

    override fun getItemCount() = carouselItem.size
}