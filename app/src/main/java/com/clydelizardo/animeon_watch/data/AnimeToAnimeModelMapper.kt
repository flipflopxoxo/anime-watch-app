package com.clydelizardo.animeon_watch.data

import com.clydelizardo.domain.AnimeModel
import org.openapitools.network.models.Anime
import javax.inject.Inject

class AnimeToAnimeModelMapper @Inject constructor() {
    fun map(anime: Anime): AnimeModel {
        return AnimeModel(
            id = anime.malId ?: -1,
            name = anime.titles?.firstOrNull()?.title.orEmpty()
        )
    }
}