package com.reift.movieapp.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.Window
import android.view.WindowManager

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

    //    fun setUpRatingStars(context: Context, binding: ItemHorizontalMovieBinding, originRating: Double) {
//        val rating = originRating / 2
//        if(rating >= 0.5){
//            binding.stars1.setColorFilter(getColor(context, R.color.yellow_star))
//            if(rating >= 1.0){
//                binding.stars1.setColorFilter(getColor(context, R.color.yellow_star))
//                if(rating >= 1.5){
//                    binding.stars2.setColorFilter(getColor(context, R.color.yellow_star))
//                    if(rating >= 2.0){
//                        binding.stars2.setColorFilter(getColor(context, R.color.yellow_star))
//                        if(rating >= 2.5){
//                            binding.stars3.setColorFilter(getColor(context, R.color.yellow_star))
//                            if(rating >= 3.0){
//                                binding.stars3.setColorFilter(getColor(context, R.color.yellow_star))
//                                if(rating >= 3.5){
//                                    binding.stars3.setColorFilter(getColor(context, R.color.yellow_star))
//                                    if(rating >= 4.0){
//                                        binding.stars4.setColorFilter(getColor(context, R.color.yellow_star))
//                                        if(rating >= 4.5){
//                                            binding.stars4.setColorFilter(getColor(context, R.color.yellow_star))
//                                            if(rating == 5.0){
//                                                binding.stars5.setColorFilter(getColor(context, R.color.yellow_star))
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    fun durationFormatter(minute: Int): String {
        return "${minute / 60}h ${minute % 60}min"
    }

    fun dateFormatter(originalDate: String): String{
        var year = ""
        var month = ""
        var date = ""
        for(i in 0..3){
            year += originalDate[i]
        }
        for(i in 5..6){
            month += originalDate[i]
        }
        for(i in 8..9){
            date += originalDate[i]
        }
        month = monthNameGenerator(month)
        return "$date $month $year"
    }

    fun monthNameGenerator(month: String): String{
        return when(month){
             "01" -> "January";
               "02" -> "February";
                "03" -> "March";
                "04" -> "April";
                "05" -> "May";
                "06" -> "June";
                "07" -> "July";
                "08" -> "August";
                "09" -> "September";
                "10" -> "October";
                "11" -> "November";
                "12" -> "December";
            else -> "iya"
        }
    }

//    }

    fun getColor(context: Context, color: Any): Int {
        return when(color){
            is String -> context.resources.getColor(context.resources.getIdentifier(color, "color", context.packageName))
            is Int -> context.resources.getColor(color)
            else -> context.resources.getColor(context.resources.getIdentifier("colorPrimary", "color", context.packageName))
        }
    }
}