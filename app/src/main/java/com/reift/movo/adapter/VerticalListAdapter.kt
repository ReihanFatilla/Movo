package com.reift.movo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.core.constant.Constant
import com.reift.core.domain.model.movie.Movie
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.movo.databinding.ItemVerticalMovieBinding
import com.reift.movo.utils.HelperFunction

class VerticalListAdapter: RecyclerView.Adapter<VerticalListAdapter.VerticalViewholder>() {

    val listMovie = ArrayList<Movie>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(list: List<Movie>?){
        if(list == null) return
        listMovie.clear()
        listMovie.addAll(list)
    }

    inner class VerticalViewholder(val binding: ItemVerticalMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= VerticalViewholder(
        ItemVerticalMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VerticalViewholder, position: Int) {
        holder.binding.apply {
            with(listMovie[position]){
                tvTitle.text = title
                tvGenre.text = HelperFunction.genreComaFormatter(genre)
                HelperFunction.setUpRatingStars(this@apply, voteAverage)
                Glide.with(imgPoster.context)
                    .load(Constant.IMAGE_BASE_URL+posterPath)
                    .apply(RequestOptions())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .into(imgPoster)

                holder.itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(id)
                }
            }
        }


    }

    override fun getItemCount() = listMovie.size
}