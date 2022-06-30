package com.reift.movieapp.presentation.home.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.movieapp.R
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.ItemCarouselHomeBinding

class CarouselAdapter(
    viewPager2: ViewPager2
): RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    private val listMovie = ArrayList<ResultsItem>()
    private val viewPager2 = viewPager2

    fun setData(data: List<ResultsItem>?) {
        if (data == null) return
        listMovie.clear()
        listMovie.addAll(data)
    }

    class CarouselViewHolder(val binding: ItemCarouselHomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CarouselViewHolder(
        ItemCarouselHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(imgMovie.context)
                .load(Constant.IMAGE_BASE_URL+listMovie[position].posterPath)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgMovie)
            if(position == listMovie.size - 2){
                viewPager2.post(runnable)
            }
        }
    }

    override fun getItemCount() = listMovie.size

    private val runnable = Runnable {
        listMovie.addAll(listMovie)
        notifyDataSetChanged()
    }
}