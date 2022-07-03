package com.reift.movieapp.presentation.home.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.movieapp.HelperFunction
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.ItemHorizontalMovieBinding

class HorizontalListAdapter: RecyclerView.Adapter<HorizontalListAdapter.MyViewHolder>() {
    val listMovie = ArrayList<ResultsItem>()

    fun setData(data: List<ResultsItem>?) {
        if (data == null) return
        listMovie.clear()
        listMovie.addAll(data)
    }

    class MyViewHolder(val binding: ItemHorizontalMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        ItemHorizontalMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ratingCount = listMovie[position].voteAverage
        val ratingString = "(${ratingCount.toString().take(3)})"
        holder.binding.apply {
            Glide.with(imgMovie.context)
                .load(Constant.IMAGE_BASE_URL+listMovie[position].posterPath)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgMovie)
            tvTitle.text = listMovie[position].title ?: listMovie[position].originalName
            tvRating.text = ratingString
            HelperFunction.setUpRatingStars(
                holder.itemView.context,
                holder.binding,
                ratingCount!!
            )
        }
    }

    override fun getItemCount() = listMovie.size
}