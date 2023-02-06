package com.reift.movo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.movo.`interface`.OnItemClickCallback
import com.reift.core.constant.Constant
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import com.reift.movo.R
import com.reift.movo.databinding.ItemHorizontalMovieBinding

class HorizontalListAdapter<T>: RecyclerView.Adapter<HorizontalListAdapter.MyViewHolder>() {

    val listMovie = ArrayList<T>()

    private var onItemClickCallBack: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallBack = onItemClickCallback
    }

    fun setData(data: List<T>?) {
        if (data == null) return
        listMovie.clear()
        listMovie.addAll(data)
    }

    class MyViewHolder(val binding: ItemHorizontalMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        ItemHorizontalMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            when(listMovie[position]){
                is Movie -> {
                    with(listMovie[position] as Movie){
                        Glide.with(imgMovie.context)
                            .load(Constant.IMAGE_BASE_URL+posterPath)
                            .apply(RequestOptions())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .priority(Priority.HIGH)
                            .into(imgMovie)
                        tvTitle.text = title

                        holder.itemView.setOnClickListener {
                            onItemClickCallBack?.onItemClicked(id)
                        }
                    }
                }
                is Tv -> {
                    with(listMovie[position] as Tv){
                        Glide.with(imgMovie.context)
                            .load(Constant.IMAGE_BASE_URL+posterPath)
                            .apply(RequestOptions())
                            .override(300, 300)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .priority(Priority.HIGH)
                            .into(imgMovie)
                        tvTitle.text = name

                        holder.itemView.setOnClickListener {
                            onItemClickCallBack?.onItemClicked(id)
                        }
                    }
                }
                }
            }

    }

    override fun getItemCount() = listMovie.size
}