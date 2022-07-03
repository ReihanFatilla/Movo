package com.reift.movieapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.Window
import android.view.WindowManager
import com.reift.movieapp.databinding.ItemHorizontalMovieBinding

object HelperFunction {

    @SuppressLint("ObsoleteSdkInt")
    fun transparentStatusbar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = activity.window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    fun setUpRatingStars(context: Context, binding: ItemHorizontalMovieBinding, originRating: Double) {
        val rating = originRating / 2
        if(rating >= 0.5){
            binding.stars1.setColorFilter(getColor(context, R.color.yellow_star))
            if(rating >= 1.0){
                binding.stars1.setColorFilter(getColor(context, R.color.yellow_star))
                if(rating >= 1.5){
                    binding.stars2.setColorFilter(getColor(context, R.color.yellow_star))
                    if(rating >= 2.0){
                        binding.stars2.setColorFilter(getColor(context, R.color.yellow_star))
                        if(rating >= 2.5){
                            binding.stars3.setColorFilter(getColor(context, R.color.yellow_star))
                            if(rating >= 3.0){
                                binding.stars3.setColorFilter(getColor(context, R.color.yellow_star))
                                if(rating >= 3.5){
                                    binding.stars3.setColorFilter(getColor(context, R.color.yellow_star))
                                    if(rating >= 4.0){
                                        binding.stars4.setColorFilter(getColor(context, R.color.yellow_star))
                                        if(rating >= 4.5){
                                            binding.stars4.setColorFilter(getColor(context, R.color.yellow_star))
                                            if(rating == 5.0){
                                                binding.stars5.setColorFilter(getColor(context, R.color.yellow_star))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun getGenreById(id: String): String {
        return when(id){
            "28" -> "Action"
            "12" -> "Adventure"
            "16" -> "Animation"
            "35" -> "Comedy"
            "80" -> "Crime"
            "99" -> "Documentary"
            "18" -> "Drama"
            "10751" -> "Family"
            "14" -> "Fantasy"
            "36" -> "History"
            "27" -> "Horror"
            "10402" -> "Music"
            "9648" -> "Mystery"
            "10749" -> "Romance"
            "878" -> "Science Fiction"
            "10770" -> "TV Movie"
            "53" -> "Thriller"
            "10752" -> "War"
            "37" -> "Western"
            "10759" -> "Action & Adventure"
            "10762" -> "Kids"
            "10763" -> "News"
            "10764" -> "Reality"
            "10765" -> "Sci-Fi & Fantasy"
            "10766" -> "Soap"
            "10767" -> "Talk"
            "10768" -> "War & Politics"
            "37" -> "Western"
            else -> "animeh"
        }
    }

    fun getColor(context: Context, color: Any): Int {
        return when(color){
            is String -> context.resources.getColor(context.resources.getIdentifier(color, "color", context.packageName))
            is Int -> context.resources.getColor(color)
            else -> context.resources.getColor(context.resources.getIdentifier("colorPrimary", "color", context.packageName))
        }
    }
}