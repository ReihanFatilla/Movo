package com.reift.core.data.local.source.room.tv

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.reift.core.data.local.source.room.movie.MovieEntity

@Dao
interface TvDao {
    @Query("SELECT * FROM MovieEntity")
    fun getAllBookmark(): LiveData<List<TvEntity>>

    @Insert
    suspend fun addBookmark(book: TvEntity)

    @Delete
    suspend fun deleteBookmark(book: TvEntity)
}