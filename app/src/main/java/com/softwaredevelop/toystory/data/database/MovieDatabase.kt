package com.softwaredevelop.toystory.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.softwaredevelop.toystory.data.model.SearchMovieModel

@Database(entities = [SearchMovieModel::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getMovieSearchDao(): MovieSearchDao

}