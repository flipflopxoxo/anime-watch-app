package com.clydelizardo.animeon_watch.details.data

import com.clydelizardo.animeon_watch.details.domain.AnimeDetailsRepository
import com.clydelizardo.domain.AnimeDetailsModel
import org.openapitools.network.apis.AnimeApi
import javax.inject.Inject

class AnimeDetailsRepositoryImpl @Inject constructor(
    private val animeApi: AnimeApi,
    private val mapper: AnimeFullToAnimeDetailsModelMapper,
): AnimeDetailsRepository {
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