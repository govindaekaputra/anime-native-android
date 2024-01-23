package com.example.animeapp.home.domain.usecase

import com.example.animeapp.core.utils.Result
import com.example.animeapp.home.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {
    fun getTopAnime(): Flow<Result<List<Anime>>>
}