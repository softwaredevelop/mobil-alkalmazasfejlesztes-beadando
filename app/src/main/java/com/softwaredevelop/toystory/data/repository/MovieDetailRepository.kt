package com.softwaredevelop.toystory.data.repository

import com.softwaredevelop.toystory.data.model.MovieModel
import com.softwaredevelop.toystory.data.model.ResultWrapper
import com.softwaredevelop.toystory.data.network.ApiService
import com.softwaredevelop.toystory.data.network.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(private val api: ApiService) :
        MovieDetailRepositoryInterface {

    override suspend fun getMovieDetail(movieId: String): ResultWrapper<MovieModel> {
        return safeApiCall(Dispatchers.Main) {
            api.getMovieDetail(movieId = movieId)
        }
    }

}

