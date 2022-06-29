package com.reift.movieapp.presentation.home.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.reift.movieapp.R
import com.reift.movieapp.databinding.ItemCarouselHomeBinding

class CarouselAdapter(
    carouselItem: MutableList<CarouselItem>,
    viewPager2: ViewPager2
): RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    private val carouselItem: List<CarouselItem> = carouselItem
    private val viewPager2 = viewPager2

    class CarouselViewHolder(val binding: ItemCarouselHomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CarouselViewHolder(
        ItemCarouselHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(imgMovie.context)
                .load(carouselItem[position].image)
                .into(imgMovie)
            if(position == carouselItem.size - 2){
                viewPager2.post(runnable)
            }
        }
    }

    override fun getItemCount() = carouselItem.size

    private val runnable = Runnable {
        carouselItem.addAll(carouselItem)
        notifyDataSetChanged()
    }
}