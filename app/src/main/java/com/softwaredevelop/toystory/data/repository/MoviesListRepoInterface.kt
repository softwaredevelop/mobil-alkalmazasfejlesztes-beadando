package com.softwaredevelop.toystory.data.repository

import com.softwaredevelop.toystory.data.model.MovieSearchModel
import com.softwaredevelop.toystory.data.model.ResultWrapper
import com.softwaredevelop.toystory.data.model.SearchMovieModel

interface MoviesListRepoInterface {

    suspend fun getAllFromNetwork(): ResultWrapper<MovieSearchModel>


    suspend fun insertToDatabase(movies: List<SearchMovieModel>)


    suspend fun getMoviesFromNDatabase(): List<SearchMovieModel>


    suspend fun deleteAll()

}