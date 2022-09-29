package com.reift.core.data.local.source.room.tv

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class TvEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val numberOfEpisodes: Int,
    val genres: String,
    val numberOfSeasons: Int,
    val voteCount: Int,
    val firstAirDate: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
): Parcelable
