package com.clydelizardo.animeonWatch.ongoing.data

import com.clydelizardo.animeonWatch.ongoing.domain.AnimeRepository
import com.clydelizardo.models.AnimeModel
import org.openapitools.network.apis.SeasonsApi
import javax.inject.Inject

class AnimeRepositoryImpl
    @Inject
    constructor(
        private val seasonsApi: SeasonsApi,
        private val animeToAnimeModelMapper: AnimeToAnimeModelMapper,
    ) : AnimeRepository {
        override suspend fun getOngoingSeasonAnime(): Result<List<AnimeModel>> {
            try {
                val response = seasonsApi.getSeasonNow()
                return when {
                    response.isSuccessful -> {
                        Result.success(
                            response
                                .body()
                                ?.data
                                ?.map {
                                    animeToAnimeModelMapper.map(it)
                                }.orEmpty(),
                        )
                    }
                    else -> Result.failure(Exception())
                }
            } catch (e: Exception) {
                return Result.failure(e)
            }
        }
    }
