package com.softwaredevelop.toystory.data.model

import com.google.gson.annotations.SerializedName

data class MovieSearchModel(
        @SerializedName("Search")
        val searchMovieModels: List<SearchMovieModel>,
        @SerializedName("totalResults")
        val totalResults: String,
        @SerializedName("Response")
        val response: String
)