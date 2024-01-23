package com.example.animeapp.home.data.source.remote.network

import com.example.animeapp.home.data.source.remote.response.AnimeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("top/anime")
    suspend fun getTopAnime(): AnimeResponse
}