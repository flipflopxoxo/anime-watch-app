package com.clydelizardo.animeonWatch.data.ongoing

import com.clydelizardo.animeonWatch.data.mapper.ApiAnimeTypeToAnimeTypeMapper
import com.clydelizardo.models.AnimeModel
import com.clydelizardo.models.ImageSource
import org.openapitools.network.models.Anime
import javax.inject.Inject

class AnimeToAnimeModelMapper @Inject constructor(
    private val animeTypeMapper: ApiAnimeTypeToAnimeTypeMapper,
) {
    fun map(anime: Anime): AnimeModel =
        AnimeModel(
            id = anime.malId ?: -1,
            name =
            anime.titles
                ?.first {
                    it.type == "English"
                }?.title
                .orEmpty(),
            genres = anime.genres?.mapNotNull { it.name }.orEmpty(),
            synopsis = anime.synopsis.orEmpty(),
            type = animeTypeMapper.map(anime.type),
            episodes = anime.episodes,
            duration = anime.duration,
            image =
            ImageSource(
                smallUrl =
                anime.images
                    ?.jpg
                    ?.smallImageUrl
                    .orEmpty(),
                mediumUrl =
                anime.images
                    ?.jpg
                    ?.imageUrl
                    .orEmpty(),
                largeUrl =
                anime.images
                    ?.jpg
                    ?.largeImageUrl
                    .orEmpty(),
            ),
        )
}
