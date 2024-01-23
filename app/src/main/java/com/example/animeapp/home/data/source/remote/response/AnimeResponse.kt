package com.example.animeapp.home.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AnimeResponse(

    @field:SerializedName("pagination")
    val pagination: Pagination,

    @field:SerializedName("data")
    val data: List<DataItem>
)

data class To(

    @field:SerializedName("month")
    val month: Int,

    @field:SerializedName("year")
    val year: Int,

    @field:SerializedName("day")
    val day: Int
)

data class Trailer(

    @field:SerializedName("embed_url")
    val embedUrl: String,

    @field:SerializedName("youtube_id")
    val youtubeId: String,

    @field:SerializedName("url")
    val url: String
)

data class StudiosItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String
)

data class TitlesItem(

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("title")
    val title: String
)

data class DemographicsItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String
)

data class Broadcast(

    @field:SerializedName("string")
    val string: String,

    @field:SerializedName("timezone")
    val timezone: String,

    @field:SerializedName("time")
    val time: String,

    @field:SerializedName("day")
    val day: String
)

data class ThemesItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String
)

data class LicensorsItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String
)

data class Jpg(

    @field:SerializedName("large_image_url")
    val largeImageUrl: String,

    @field:SerializedName("small_image_url")
    val smallImageUrl: String,

    @field:SerializedName("image_url")
    val imageUrl: String
)

data class Images(

    @field:SerializedName("jpg")
    val jpg: Jpg,

    @field:SerializedName("webp")
    val webp: Webp
)

data class Aired(

    @field:SerializedName("prop")
    val prop: Prop,

    @field:SerializedName("from")
    val from: String,

    @field:SerializedName("to")
    val to: String
)

data class ExplicitGenresItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String
)

data class Items(

    @field:SerializedName("per_page")
    val perPage: Int,

    @field:SerializedName("total")
    val total: Int,

    @field:SerializedName("count")
    val count: Int
)

data class From(

    @field:SerializedName("month")
    val month: Int,

    @field:SerializedName("year")
    val year: Int,

    @field:SerializedName("day")
    val day: Int
)

data class ProducersItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String
)

data class Pagination(

    @field:SerializedName("has_next_page")
    val hasNextPage: Boolean,

    @field:SerializedName("last_visible_page")
    val lastVisiblePage: Int,

    @field:SerializedName("items")
    val items: Items
)

data class Webp(

    @field:SerializedName("large_image_url")
    val largeImageUrl: String,

    @field:SerializedName("small_image_url")
    val smallImageUrl: String,

    @field:SerializedName("image_url")
    val imageUrl: String
)

data class Prop(

    @field:SerializedName("string")
    val string: String,

    @field:SerializedName("from")
    val from: From,

    @field:SerializedName("to")
    val to: To
)

data class GenresItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String
)

data class DataItem(

    @field:SerializedName("title_japanese")
    val titleJapanese: String,

    @field:SerializedName("favorites")
    val favorites: Int,

    @field:SerializedName("broadcast")
    val broadcast: Broadcast,

    @field:SerializedName("year")
    val year: Int,

    @field:SerializedName("rating")
    val rating: String,

    @field:SerializedName("scored_by")
    val scoredBy: Int,

    @field:SerializedName("title_synonyms")
    val titleSynonyms: List<String>,

    @field:SerializedName("source")
    val source: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("trailer")
    val trailer: Trailer,

    @field:SerializedName("duration")
    val duration: String,

    @field:SerializedName("score")
    val score: Double,

    @field:SerializedName("themes")
    val themes: List<ThemesItem>,

    @field:SerializedName("approved")
    val approved: Boolean,

    @field:SerializedName("genres")
    val genres: List<GenresItem>,

    @field:SerializedName("popularity")
    val popularity: Int,

    @field:SerializedName("members")
    val members: Int,

    @field:SerializedName("title_english")
    val titleEnglish: String,

    @field:SerializedName("rank")
    val rank: Int,

    @field:SerializedName("season")
    val season: String,

    @field:SerializedName("airing")
    val airing: Boolean,

    @field:SerializedName("episodes")
    val episodes: Int,

    @field:SerializedName("aired")
    val aired: Aired,

    @field:SerializedName("images")
    val images: Images,

    @field:SerializedName("studios")
    val studios: List<StudiosItem>,

    @field:SerializedName("mal_id")
    val malId: Int,

    @field:SerializedName("titles")
    val titles: List<TitlesItem>,

    @field:SerializedName("synopsis")
    val synopsis: String,

    @field:SerializedName("explicit_genres")
    val explicitGenres: List<ExplicitGenresItem>,

    @field:SerializedName("licensors")
    val licensors: List<LicensorsItem>,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("producers")
    val producers: List<ProducersItem>,

    @field:SerializedName("background")
    val background: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("demographics")
    val demographics: List<DemographicsItem>
)
