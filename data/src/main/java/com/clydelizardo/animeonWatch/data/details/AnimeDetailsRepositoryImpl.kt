package com.clydelizardo.animeonWatch.data.details

import com.clydelizardo.animeonWatch.domain.details.AnimeDetailsRepository
import com.clydelizardo.models.AnimeDetailsModel
import org.openapitools.network.apis.AnimeApi
import javax.inject.Inject

class AnimeDetailsRepositoryImpl
    @Inject
    constructor(
        private val animeApi: AnimeApi,
        private val mapper: AnimeFullToAnimeDetailsModelMapper,
    ) : AnimeDetailsRepository {
        override suspend fun getAnimeDetails(animeId: Int): Result<AnimeDetailsModel> {
            try {
                val result = animeApi.getAnimeFullById(animeId)
                return if (result.isSuccessful) {
                    Result.success(mapper.map(result.body()!!.data!!))
                } else {
                    Result.failure(Exception())
                }
            } catch (e: Exception) {
                return Result.failure(e)
            }
        }
    }
