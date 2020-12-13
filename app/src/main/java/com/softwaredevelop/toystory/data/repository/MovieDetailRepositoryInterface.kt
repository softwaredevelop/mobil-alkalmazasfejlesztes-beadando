package com.softwaredevelop.toystory.data.repository

import com.softwaredevelop.toystory.data.model.MovieModel
import com.softwaredevelop.toystory.data.model.ResultWrapper

interface MovieDetailRepositoryInterface {

    suspend fun getMovieDetail(movieId: String): ResultWrapper<MovieModel>
}