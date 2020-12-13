package com.softwaredevelop.toystory.data.repository

import com.softwaredevelop.toystory.data.database.MovieSearchDao
import com.softwaredevelop.toystory.data.model.MovieSearchModel
import com.softwaredevelop.toystory.data.model.ResultWrapper
import com.softwaredevelop.toystory.data.model.SearchMovieModel
import com.softwaredevelop.toystory.data.network.ApiService
import com.softwaredevelop.toystory.data.network.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MoviesListRepo @Inject constructor(
        private val movieSearchDao: MovieSearchDao,
        private val api: ApiService
) : MoviesListRepoInterface {

    override suspend fun getAllFromNetwork(): ResultWrapper<MovieSearchModel> {
        return safeApiCall(Dispatchers.IO)
        {
            api.getToyStoryMovies()
        }
    }

    override suspend fun insertToDatabase(movies: List<SearchMovieModel>) {
        movieSearchDao.insertAll(movies)
    }

    override suspend fun getMoviesFromNDatabase(): List<SearchMovieModel> =
            movieSearchDao.getAll()

    override suspend fun deleteAll() {
        movieSearchDao.deleteAll()
    }


}