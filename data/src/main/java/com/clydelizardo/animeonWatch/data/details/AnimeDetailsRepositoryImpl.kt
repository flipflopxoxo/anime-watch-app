package com.clydelizardo.animeonWatch.data.details

import com.clydelizardo.animeonWatch.data.common.convertResponseToResult
import com.clydelizardo.animeonWatch.data.mapper.AnimeFullToAnimeDetailsModelMapper
import com.clydelizardo.animeonWatch.domain.details.AnimeDetailsRepository
import com.clydelizardo.models.AnimeDetailsModel
import org.openapitools.network.apis.AnimeApi
import javax.inject.Inject

class AnimeDetailsRepositoryImpl @Inject constructor(
    private val animeApi: AnimeApi,
    private val mapper: AnimeFullToAnimeDetailsModelMapper,
) : AnimeDetailsRepository {
    override suspend fun getAnimeDetails(animeId: Int): Result<AnimeDetailsModel> {
        return convertResponseToResult(
            requestCall = {
                animeApi.getAnimeFullById(animeId)
            },
            mapOutput = {
                mapper.map(it!!.data!!)
            }
        )
    }
}
