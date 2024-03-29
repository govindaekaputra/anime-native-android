package com.example.animeapp.core.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType>(private val appExecutor: AppExecutor) {
    private var result: Flow<Result<ResultType>> =
        flow {
            emit(Result.Loading)
            val dbSource = loadFromDB().first()
            if (shouldFetch(dbSource)) {
                emit(Result.Loading)
                when (val apiResponse = createCall().first()) {
                    is ApiResponse.Empty -> {
                        emitAll(loadFromDB().map { Result.Success(it) })
                    }

                    is ApiResponse.Error -> {
                        onFetchFailed()
                        emit(Result.Error(apiResponse.message))
                    }

                    is ApiResponse.Success -> {
                        saveCallResult(apiResponse.data)
                        emitAll(loadFromDB().map { Result.Success(it) })
                    }
                }
            } else {
                emitAll(loadFromDB().map { Result.Success(it) })
            }
        }

    protected open fun onFetchFailed() {}
    protected abstract fun loadFromDB(): Flow<ResultType>
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>
    protected abstract suspend fun saveCallResult(data: RequestType)
    fun asFlow(): Flow<Result<ResultType>> = result
}