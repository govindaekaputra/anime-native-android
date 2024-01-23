package com.example.animeapp.home.domain.usecase

import com.example.animeapp.core.utils.Result
import com.example.animeapp.home.domain.model.Anime
import com.example.animeapp.home.domain.repository.IAnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeInteractor(private val animeRepository: IAnimeRepository) : AnimeUseCase {
    override fun getTopAnime(): Flow<Result<List<Anime>>> =
        animeRepository.getTopAnime()
}