package com.clydelizardo.animeonWatch.data.details

import com.clydelizardo.animeonWatch.data.mapper.AnimeFullToAnimeDetailsModelMapper
import com.clydelizardo.common.MainCoroutineRule
import com.clydelizardo.models.AnimeDetailsModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.openapitools.network.apis.AnimeApi
import org.openapitools.network.models.AnimeFull
import org.openapitools.network.models.GetAnimeFullById200Response
import retrofit2.Response

class AnimeDetailsRepositoryImplTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var repositoryImpl: AnimeDetailsRepositoryImpl

    @MockK
    lateinit var animeApi: AnimeApi

    @MockK
    lateinit var mapper: AnimeFullToAnimeDetailsModelMapper

    @Test
    fun `Given API is available, When requesting details, Then mapped result is returned`() =
        runTest {
            val mockAnimeFull = mockk<AnimeFull>()
            val successResponseBody =
                mockk<GetAnimeFullById200Response> {
                    every { data } returns mockAnimeFull
                }
            val mockAnimeDetailsModel = mockk<AnimeDetailsModel>()
            coEvery { animeApi.getAnimeFullById(1) } returns Response.success(successResponseBody)
            coEvery { mapper.map(mockAnimeFull) } returns mockAnimeDetailsModel

            repositoryImpl = AnimeDetailsRepositoryImpl(animeApi, mapper)
            val result = repositoryImpl.getAnimeDetails(1)
            assertEquals(Result.success(mockAnimeDetailsModel), result)
        }

    @Test
    fun `Given API is unavailable, When requesting details, Then failure result is returned`() =
        runTest {
            val mockAnimeFull = mockk<AnimeFull>()
            val failureResponse =
                mockk<Response<GetAnimeFullById200Response>> {
                    every { isSuccessful } returns false
                }
            val mockAnimeDetailsModel = mockk<AnimeDetailsModel>()
            coEvery { animeApi.getAnimeFullById(1) } returns failureResponse
            coEvery { mapper.map(mockAnimeFull) } returns mockAnimeDetailsModel

            repositoryImpl = AnimeDetailsRepositoryImpl(animeApi, mapper)
            val result = repositoryImpl.getAnimeDetails(1)
            assertTrue(result.isFailure)
        }

    @Test
    fun `Given API call throws exception, When requesting details, Then failure result is returned`() =
        runTest {
            val exception = Exception()
            coEvery { animeApi.getAnimeFullById(1) } throws exception

            repositoryImpl = AnimeDetailsRepositoryImpl(animeApi, mapper)
            val result = repositoryImpl.getAnimeDetails(1)
            assertEquals(Result.failure<AnimeDetailsModel>(exception), result)
        }
}
