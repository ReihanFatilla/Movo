package com.reift.movieapp.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM Favorite")
    fun getAllBookmark(): LiveData<List<Favorite>>

    @Insert
    suspend fun addBookmark(book: Favorite)

    @Delete
    suspend fun deleteBookmark(book: Favorite)
}