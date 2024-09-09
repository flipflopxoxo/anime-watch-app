package com.clydelizardo.animeonWatch.data.mapper

import com.clydelizardo.models.AnimeType
import org.junit.Assert.*
import org.junit.Test
import org.openapitools.network.models.Anime

class ApiAnimeTypeToAnimeTypeMapperTest {
    private val mapper = ApiAnimeTypeToAnimeTypeMapper()

    @Test
    fun `mapper returns corresponding type`() {
        assertEquals(AnimeType.TV, mapper.map(Anime.Type.TV))
        assertEquals(AnimeType.OVA, mapper.map(Anime.Type.OVA))
        assertEquals(AnimeType.Movie, mapper.map(Anime.Type.Movie))
        assertEquals(AnimeType.Special, mapper.map(Anime.Type.Special))
        assertEquals(AnimeType.ONA, mapper.map(Anime.Type.ONA))
        assertEquals(AnimeType.Music, mapper.map(Anime.Type.Music))
        assertEquals(AnimeType.Unknown, mapper.map(null))
    }
}