package com.clydelizardo.animeonWatch.data.mapper

import com.clydelizardo.models.AnimeType
import org.openapitools.network.models.AnimeFull
import javax.inject.Inject

class AnimeFullTypeToAnimeTypeMapper @Inject constructor() {
    fun map(animeFullType: AnimeFull.Type?): AnimeType = when (animeFullType) {
        AnimeFull.Type.TV -> AnimeType.TV
        AnimeFull.Type.OVA -> AnimeType.OVA
        AnimeFull.Type.Movie -> AnimeType.Movie
        AnimeFull.Type.Special -> AnimeType.Special
        AnimeFull.Type.ONA -> AnimeType.ONA
        AnimeFull.Type.Music -> AnimeType.Music
        null -> AnimeType.Unknown
    }
}