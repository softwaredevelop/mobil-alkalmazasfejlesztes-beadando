package com.softwaredevelop.toystory.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class SearchMovieModel(
        @SerializedName("Title")
        val title: String,
        @SerializedName("Year")
        val year: String,
        @SerializedName("imdbID")
        @PrimaryKey
        val imdbId: String,
        @SerializedName("Type")
        val type: String,
        @SerializedName("Poster")
        val poster: String
)