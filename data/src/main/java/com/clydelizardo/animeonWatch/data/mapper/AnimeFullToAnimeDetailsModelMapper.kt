package com.clydelizardo.animeonWatch.data.mapper

import com.clydelizardo.models.AnimeDetailsModel
import com.clydelizardo.models.ImageSource
import org.openapitools.network.models.AnimeFull
import org.openapitools.network.models.AnimeImagesJpg
import javax.inject.Inject

class AnimeFullToAnimeDetailsModelMapper @Inject constructor(
    private val animeTypeMapper: AnimeFullTypeToAnimeTypeMapper,
) {
    fun map(animeFull: AnimeFull): AnimeDetailsModel =
        AnimeDetailsModel(
            id = animeFull.malId ?: -1,
            titleEnglish = animeFull.findTitleByType("English"),
            titleJapanese = animeFull.findTitleByType("Japanese"),
            genres = animeFull.genres?.mapNotNull { it.name }.orEmpty(),
            themes = animeFull.themes?.mapNotNull { it.name }.orEmpty(),
            type = animeTypeMapper.map(animeFull.type),
            episodes = animeFull.episodes,
            status = animeFull.status?.value ?: "",
            duration = animeFull.duration ?: "",
            source = animeFull.source ?: "",
            openingThemes = animeFull.theme?.openings.orEmpty(),
            endingThemes = animeFull.theme?.endings.orEmpty(),
            relatedMedia = mapRelatedMedia(animeFull),
            imageSource = mapImageSource(animeFull.images?.jpg),
        )

    private fun mapImageSource(jpg: AnimeImagesJpg?): ImageSource =
        ImageSource(
            smallUrl = jpg?.smallImageUrl ?: "",
            mediumUrl = jpg?.imageUrl ?: "",
            largeUrl = jpg?.largeImageUrl ?: "",
        )

    private fun mapRelatedMedia(animeFull: AnimeFull) =
        animeFull.relations
            ?.flatMap { relation ->
                relation.entry?.map { "${relation.relation} - ${it.name} ${it.type}" }.orEmpty()
            }.orEmpty()

    private fun AnimeFull.findTitleByType(type: String): String =
        titles?.firstOrNull { it.type == type }?.title ?: ""
}
