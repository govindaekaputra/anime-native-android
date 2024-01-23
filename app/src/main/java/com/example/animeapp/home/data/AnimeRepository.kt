package com.example.animeapp.home.data

import com.example.animeapp.core.utils.Result
import com.example.animeapp.home.data.source.local.LocalDataSource
import com.example.animeapp.home.data.source.remote.RemoteDataSource
import com.example.animeapp.home.data.source.remote.response.DataItem
import com.example.animeapp.home.domain.model.Anime
import com.example.animeapp.home.domain.repository.IAnimeRepository
import com.example.animeapp.home.utils.DataMapper
import com.example.animeapp.core.utils.ApiResponse
import com.example.animeapp.core.utils.AppExecutor
import com.example.animeapp.core.utils.NetworkBoundResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AnimeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutor
) : IAnimeRepository {
    override fun getTopAnime(): Flow<Result<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, List<DataItem>>(appExecutor) {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getTopAnime().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<DataItem>>> {
                return remoteDataSource.getTopAnime()
            }

            override suspend fun saveCallResult(data: List<DataItem>) {
                val anime = DataMapper.mapResponseToEntities(data)
                localDataSource.insetTopAnime(anime)
            }

            override fun shouldFetch(data: List<Anime>?): Boolean {
                return data.isNullOrEmpty()
            }

        }.asFlow()
}