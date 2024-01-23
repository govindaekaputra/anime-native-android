package com.example.animeapp.home.data.source.local

import com.example.animeapp.home.data.source.local.entity.AnimeEntity
import com.example.animeapp.home.data.source.local.room.AnimeDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val animeDao: AnimeDao) {
    fun getTopAnime(): Flow<List<AnimeEntity>> = animeDao.getTopAnime()
    suspend fun insetTopAnime(anime: List<AnimeEntity>) = animeDao.insertTopAnime(anime)
}