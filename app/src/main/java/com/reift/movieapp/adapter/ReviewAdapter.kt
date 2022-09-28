package com.reift.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.core.domain.model.detail.Review
import com.reift.movieapp.databinding.ItemReviewDetailBinding

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.MyViewHolder>() {
    private var listReview = ArrayList<Review>()

    fun setData(list: List<Review>?) {
        if (list == null) return
        listReview.clear()
        listReview.addAll(list)
    }

    class MyViewHolder(val binding: ItemReviewDetailBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemReviewDetailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            tvNameReview.text = listReview[position].name
            tvUsernameReview.text = "@"+listReview[position].username
            tvMessage.text = listReview[position].content
            Glide.with(imgProfileReview.context)
                .load(listReview[position].avatarPath.drop(1))
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgProfileReview)
        }
    }

    override fun getItemCount() = listReview.size
}