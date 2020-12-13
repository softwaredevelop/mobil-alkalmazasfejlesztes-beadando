package com.softwaredevelop.toystory.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softwaredevelop.toystory.data.model.SearchMovieModel

@Dao
interface MovieSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(moviesList: List<SearchMovieModel>)


    @Query("select * from SearchMovieModel")
    suspend fun getAll(): List<SearchMovieModel>


    @Query("delete from SearchMovieModel")
    suspend fun deleteAll()

}