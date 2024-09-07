package com.clydelizardo.models

data class AnimeModel(
    val id: Int,
    val name: String,
    val image: ImageSource,
    val synopsis: String,
    val genres: List<String>,
    val type: AnimeType,
    val episodes: Int?,
    val duration: String?,
)

enum class AnimeType(
    val displayName: String,
) {
    TV("TV"),
    OVA("OVA"),
    Movie("Movie"),
    Special("Special"),
    ONA("ONA"),
    Music("Music"),
}
