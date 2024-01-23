package com.example.animeapp.home.domain.repository

import com.example.animeapp.core.utils.Result
import com.example.animeapp.home.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {
    fun getTopAnime(): Flow<Result<List<Anime>>>
}