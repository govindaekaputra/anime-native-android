package com.example.animeapp.home.utils

import com.example.animeapp.home.data.source.local.entity.AnimeEntity
import com.example.animeapp.home.data.source.remote.response.DataItem
import com.example.animeapp.home.domain.model.Anime

object DataMapper {
    fun mapResponseToEntities(input: List<DataItem>): List<AnimeEntity> =
        input.map {
            AnimeEntity(
                it.malId,
                it.title,
                it.images.webp.imageUrl,
                it.synopsis,
                it.type,
                it.episodes
            )
        }

    fun mapEntitiesToDomain(input: List<AnimeEntity>): List<Anime> =
        input.map {
            Anime(
                it.malId, it.title,
                it.image, it.synopsis, it.type, it.eps
            )
        }

    fun mapDomainToEntity(input: Anime): AnimeEntity =
        AnimeEntity(input.malId, input.title, input.type, input.image, input.synopsis, input.eps)
}