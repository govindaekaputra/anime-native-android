package com.example.animeapp.home.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("anime")
data class AnimeEntity(
    @PrimaryKey
    @ColumnInfo("malId")
    val malId: Int,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("image")
    val image: String,
    @ColumnInfo("synopsis")
    val synopsis: String,
    @ColumnInfo("type")
    val type: String,
    @ColumnInfo("eps")
    val eps: Int,
)