package com.reift.core.data.local.source.room.movie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.reift.core.data.local.source.room.movie.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieEntity")
    fun getAllBookmark(): LiveData<List<MovieEntity>>

    @Insert
    suspend fun addBookmark(book: MovieEntity)

    @Delete
    suspend fun deleteBookmark(book: MovieEntity)
}