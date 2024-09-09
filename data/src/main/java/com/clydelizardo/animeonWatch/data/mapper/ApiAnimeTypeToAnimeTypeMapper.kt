package com.clydelizardo.animeonWatch.data.mapper

import com.clydelizardo.models.AnimeType
import org.openapitools.network.models.Anime
import javax.inject.Inject

class ApiAnimeTypeToAnimeTypeMapper @Inject constructor() {
    fun map(animeType: Anime.Type?): AnimeType = when (animeType) {
        Anime.Type.TV -> AnimeType.TV
        Anime.Type.OVA -> AnimeType.OVA
        Anime.Type.Movie -> AnimeType.Movie
        Anime.Type.Special -> AnimeType.Special
        Anime.Type.ONA -> AnimeType.ONA
        Anime.Type.Music -> AnimeType.Music
        null -> AnimeType.Unknown
    }
}