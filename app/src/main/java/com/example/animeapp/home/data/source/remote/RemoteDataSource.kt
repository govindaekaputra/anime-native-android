package com.example.animeapp.home.data.source.remote

import com.example.animeapp.home.data.source.remote.network.ApiService
import com.example.animeapp.home.data.source.remote.response.DataItem
import com.example.animeapp.core.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getTopAnime(): Flow<ApiResponse<List<DataItem>>> =
        flow {
            try {
                val response = apiService.getTopAnime()
                val anime = response.data
                if (anime.isNotEmpty()) {
                    emit(ApiResponse.Success(anime))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
}