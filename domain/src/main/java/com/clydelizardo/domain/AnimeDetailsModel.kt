package com.clydelizardo.domain

data class AnimeDetailsModel(
    val id: Int,
    val titleEnglish: String,
    val titleJapanese: String,
    val genres: List<String>,
    val themes: List<String>,
    val type: AnimeType,
    val episodes: Int?,
    val status: String,
    val duration: String,
    val source: String,
    val openingThemes: List<String>,
    val endingThemes: List<String>,
    val relatedMedia: List<String>,
    val imageSource: ImageSource,
)