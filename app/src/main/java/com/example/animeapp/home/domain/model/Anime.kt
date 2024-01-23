package com.example.animeapp.home.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val malId: Int,
    val title: String,
    val image: String,
    val synopsis: String,
    val type: String,
    val eps: Int,
) : Parcelable
