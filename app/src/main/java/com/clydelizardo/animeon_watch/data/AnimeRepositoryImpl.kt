package com.clydelizardo.animeon_watch.data

import com.clydelizardo.animeon_watch.ongoing.domain.AnimeRepository
import com.clydelizardo.domain.AnimeModel
import org.openapitools.network.apis.SeasonsApi
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val seasonsApi: SeasonsApi,
    private val animeToAnimeModelMapper: AnimeToAnimeModelMapper,
) : AnimeRepository {
    override suspend fun getOngoingSeasonAnime(): Result<List<AnimeModel>> {
        val response = seasonsApi.getSeasonNow()
        return when {
            response.isSuccessful -> {
                Result.success(response.body()?.data?.map {
                    animeToAnimeModelMapper.map(it)
                }.orEmpty())
            }
            else -> Result.failure(Exception())
        }
    }
}