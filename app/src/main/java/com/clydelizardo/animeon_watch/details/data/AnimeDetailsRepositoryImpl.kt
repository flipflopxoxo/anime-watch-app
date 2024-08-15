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
        val result = animeApi.getAnimeFullById(animeId)
        if (result.isSuccessful) {
            return Result.success(mapper.map(result.body()!!.data!!))
        } else {
            return Result.failure(Exception())
        }
    }
}