package com.example.animeapp.home.di

import com.example.animeapp.home.domain.usecase.AnimeInteractor
import com.example.animeapp.home.domain.usecase.AnimeUseCase
import com.example.animeapp.home.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> {
        AnimeInteractor(get())
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}