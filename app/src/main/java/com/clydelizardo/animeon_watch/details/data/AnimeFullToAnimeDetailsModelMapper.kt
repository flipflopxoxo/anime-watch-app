package com.clydelizardo.animeon_watch.details.data

import com.clydelizardo.domain.AnimeDetailsModel
import com.clydelizardo.domain.AnimeType
import org.openapitools.network.models.AnimeFull
import javax.inject.Inject

class AnimeFullToAnimeDetailsModelMapper @Inject constructor() {
    fun map(animeFull: AnimeFull): AnimeDetailsModel {
        return AnimeDetailsModel(
            id = animeFull.malId ?: -1,
            titleEnglish = animeFull.findTitleByType("English"),
            titleJapanese = animeFull.findTitleByType("Japanese"),
            genres = animeFull.genres?.mapNotNull { it.name }.orEmpty(),
            themes = animeFull.themes?.mapNotNull { it.name }.orEmpty(),
            type = mapAnimeType(animeFull.type ?: AnimeFull.Type.TV),
            episodes = animeFull.episodes,
            status = animeFull.status?.value ?: "",
            duration = animeFull.duration ?: "",
            source = animeFull.source ?: "",
            openingThemes = animeFull.theme?.openings.orEmpty(),
            endingThemes = animeFull.theme?.endings.orEmpty(),
            relatedMedia = mapRelatedMedia(animeFull)
        )
    }

    private fun mapRelatedMedia(animeFull: AnimeFull) =
        animeFull.relations?.flatMap { relation ->
            relation.entry?.map { "${relation.relation} - ${it.name} ${it.type}" }.orEmpty()
        }.orEmpty()

    private fun mapAnimeType(type: AnimeFull.Type) = when (type) {
        AnimeFull.Type.TV -> AnimeType.TV
        AnimeFull.Type.OVA -> AnimeType.OVA
        AnimeFull.Type.Movie -> AnimeType.Movie
        AnimeFull.Type.Special -> AnimeType.Special
        AnimeFull.Type.ONA -> AnimeType.ONA
        AnimeFull.Type.Music -> AnimeType.Music
    }

    private fun AnimeFull.findTitleByType(type: String): String =
        titles?.firstOrNull { it.type == type }?.title ?: ""
}