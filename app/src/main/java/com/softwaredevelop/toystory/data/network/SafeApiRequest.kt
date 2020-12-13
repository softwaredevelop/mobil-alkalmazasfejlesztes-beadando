package com.softwaredevelop.toystory.data.network

import com.softwaredevelop.toystory.data.model.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher)
    {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            ResultWrapper.NetworkError
        }
    }
}


