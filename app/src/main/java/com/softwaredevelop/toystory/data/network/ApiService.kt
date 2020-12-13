package com.softwaredevelop.toystory.data.network

import com.softwaredevelop.toystory.data.model.MovieModel
import com.softwaredevelop.toystory.data.model.MovieSearchModel
import com.softwaredevelop.toystory.utility.ConstValue.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("/")
    suspend fun getToyStoryMovies(
            @Query("apikey") apiKey: String = API_KEY,
            @Query("s") name: String = "toy+story"
    ): MovieSearchModel

    @GET("/")
    suspend fun getMovieDetail(
            @Query("apikey") apiKey: String = API_KEY,
            @Query("i") movieId: String
    ): MovieModel

}
