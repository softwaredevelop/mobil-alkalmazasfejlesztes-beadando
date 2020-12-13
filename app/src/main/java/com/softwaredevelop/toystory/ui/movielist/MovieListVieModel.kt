package com.softwaredevelop.toystory.ui.movielist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softwaredevelop.toystory.data.model.MovieSearchModel
import com.softwaredevelop.toystory.data.model.ResultWrapper
import com.softwaredevelop.toystory.data.model.SearchMovieModel
import com.softwaredevelop.toystory.data.repository.MoviesListRepo

class MovieListVieModel @ViewModelInject constructor(private val repository: MoviesListRepo) :
        ViewModel() {

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    private val _movies = MutableLiveData<List<SearchMovieModel>>()
    val movies: LiveData<List<SearchMovieModel>>
        get() = _movies


    suspend fun fetchData() {
        when (val result = repository.getAllFromNetwork()) {
            is ResultWrapper.Success -> showSuccess(result.value)
            is ResultWrapper.NetworkError -> getFromDataBase()
        }
    }

    private suspend fun showSuccess(value: MovieSearchModel) {
        if (value.response == "True") {
            val models = value.searchMovieModels

            _movies.postValue(models)
            saveDataInDatabase(models)
        } else {
            getFromDataBase()
        }
    }

    private suspend fun saveDataInDatabase(models: List<SearchMovieModel>) {
        repository.deleteAll()
        repository.insertToDatabase(models)
    }


    private suspend fun getFromDataBase() {
        val models = repository.getMoviesFromNDatabase()
        if (models.isEmpty())
            showError()
        else
            _movies.postValue(models)

    }


    private fun showError() =
            _error.postValue(true)


}