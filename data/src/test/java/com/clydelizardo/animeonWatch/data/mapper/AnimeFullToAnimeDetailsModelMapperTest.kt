package com.clydelizardo.animeonWatch.data.mapper

import com.clydelizardo.models.AnimeDetailsModel
import com.clydelizardo.models.AnimeType
import com.clydelizardo.models.ImageSource
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.openapitools.network.models.AnimeFull
import org.openapitools.network.models.AnimeFullRelationsInner
import org.openapitools.network.models.AnimeFullTheme
import org.openapitools.network.models.AnimeImages
import org.openapitools.network.models.AnimeImagesJpg
import org.openapitools.network.models.MalUrl
import org.openapitools.network.models.Title

class AnimeFullToAnimeDetailsModelMapperTest {
    @get:Rule
    val rule = MockKRule(this)

    @MockK
    lateinit var mockAnimeTypeMapper: AnimeFullTypeToAnimeTypeMapper

    lateinit var mapper: AnimeFullToAnimeDetailsModelMapper

    @Before
    fun setup() {
        mapper = AnimeFullToAnimeDetailsModelMapper(mockAnimeTypeMapper)
    }

    @Test
    fun `Given AnimeFull instance, Then map to AnimeDetailsModel`() {
        every { mockAnimeTypeMapper.map(any()) } returns AnimeType.Unknown

        val animeFull =
            AnimeFull(
                malId = 1,
                titles =
                    listOf(
                        Title(type = "English", title = "[Oshi No Ko] Season 2"),
                        Title(type = "Japanese", title = "【推しの子】第2期"),
                    ),
                genres =
                    listOf(
                        MalUrl(name = "Drama"),
                        MalUrl(name = "Supernatural"),
                    ),
                themes =
                    listOf(
                        MalUrl(name = "Reincarnation"),
                        MalUrl(name = "Showbiz"),
                    ),
                type = AnimeFull.Type.TV,
                episodes = 13,
                status = AnimeFull.Status.Currently_Airing,
                duration = "25 min per ep",
                source = "Manga",
                theme =
                    AnimeFullTheme(
                        openings = listOf("\"Fatale (ファタール)\" by GEMN"),
                        endings = listOf("\"Burning\" by Hitsujibungaku (羊文学)"),
                    ),
                relations =
                    listOf(
                        AnimeFullRelationsInner(
                            relation = "Adaptation",
                            entry =
                                listOf(
                                    MalUrl(
                                        name = "\"Oshi no Ko\"",
                                        type = "manga",
                                    ),
                                ),
                        ),
                        AnimeFullRelationsInner(
                            relation = "Prequel",
                            entry =
                                listOf(
                                    MalUrl(
                                        name = "\"Oshi no Ko\"",
                                        type = "anime",
                                    ),
                                ),
                        ),
                    ),
                images =
                    AnimeImages(
                        jpg =
                            AnimeImagesJpg(
                                imageUrl = "imageUrl",
                                smallImageUrl = "smallImageUrl",
                                largeImageUrl = "largeImageUrl",
                            ),
                    ),
            )
        val expected =
            AnimeDetailsModel(
                id = 1,
                titleEnglish = "[Oshi No Ko] Season 2",
                titleJapanese = "【推しの子】第2期",
                genres = listOf("Drama", "Supernatural"),
                themes = listOf("Reincarnation", "Showbiz"),
                type = AnimeType.Unknown,
                episodes = 13,
                status = "Currently Airing",
                duration = "25 min per ep",
                source = "Manga",
                openingThemes = listOf("\"Fatale (ファタール)\" by GEMN"),
                endingThemes = listOf("\"Burning\" by Hitsujibungaku (羊文学)"),
                relatedMedia = listOf("Adaptation - \"Oshi no Ko\" manga", "Prequel - \"Oshi no Ko\" anime"),
                imageSource =
                    ImageSource(
                        smallUrl = "smallImageUrl",
                        mediumUrl = "imageUrl",
                        largeUrl = "largeImageUrl",
                    ),
            )

        val result = mapper.map(animeFull)
        assertEquals(expected, result)
    }
}
