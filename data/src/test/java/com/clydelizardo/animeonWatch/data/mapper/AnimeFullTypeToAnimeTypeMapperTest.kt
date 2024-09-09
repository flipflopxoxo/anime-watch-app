package com.clydelizardo.animeonWatch.data.mapper

import com.clydelizardo.models.AnimeType
import org.junit.Assert.*
import org.junit.Test
import org.openapitools.network.models.AnimeFull

class AnimeFullTypeToAnimeTypeMapperTest {
    private val mapper = AnimeFullTypeToAnimeTypeMapper()

    @Test
    fun `mapper returns corresponding type`() {
        assertEquals(AnimeType.TV, mapper.map(AnimeFull.Type.TV))
        assertEquals(AnimeType.OVA, mapper.map(AnimeFull.Type.OVA))
        assertEquals(AnimeType.Movie, mapper.map(AnimeFull.Type.Movie))
        assertEquals(AnimeType.Special, mapper.map(AnimeFull.Type.Special))
        assertEquals(AnimeType.ONA, mapper.map(AnimeFull.Type.ONA))
        assertEquals(AnimeType.Music, mapper.map(AnimeFull.Type.Music))
        assertEquals(AnimeType.Unknown, mapper.map(null))
    }
}