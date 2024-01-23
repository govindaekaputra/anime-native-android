package com.example.animeapp.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.animeapp.home.domain.usecase.AnimeUseCase

class MainViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val topAnime = animeUseCase.getTopAnime().asLiveData()
}