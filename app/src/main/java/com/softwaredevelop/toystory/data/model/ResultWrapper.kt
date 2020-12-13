package com.softwaredevelop.toystory.data.model


sealed class ResultWrapper<out T> {

    data class Success<out T>(val value: T) : ResultWrapper<T>()
    object NetworkError : ResultWrapper<Nothing>()

}