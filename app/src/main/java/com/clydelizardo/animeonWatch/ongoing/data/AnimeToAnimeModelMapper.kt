package com.clydelizardo.animeonWatch.ongoing.data

import com.clydelizardo.models.AnimeModel
import com.clydelizardo.models.AnimeType
import com.clydelizardo.models.ImageSource
import org.openapitools.network.models.Anime
import javax.inject.Inject

class AnimeToAnimeModelMapper
    @Inject
    constructor() {
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
                type = mapAnimeType(anime.type ?: Anime.Type.TV),
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

        private fun mapAnimeType(type: Anime.Type): AnimeType =
            when (type) {
                Anime.Type.TV -> AnimeType.TV
                Anime.Type.OVA -> AnimeType.OVA
                Anime.Type.Movie -> AnimeType.Movie
                Anime.Type.Special -> AnimeType.Special
                Anime.Type.ONA -> AnimeType.ONA
                Anime.Type.Music -> AnimeType.Music
            }
    }
