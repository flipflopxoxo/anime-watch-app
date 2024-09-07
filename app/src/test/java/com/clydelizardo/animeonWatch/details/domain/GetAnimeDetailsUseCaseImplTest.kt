package com.clydelizardo.animeonWatch.details.domain

import com.clydelizardo.animeonWatch.MainCoroutineRule
import com.clydelizardo.animeonWatch.domain.details.AnimeDetailsRepository
import com.clydelizardo.animeonWatch.domain.details.GetAnimeDetailsUseCaseImpl
import com.clydelizardo.models.AnimeDetailsModel
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class GetAnimeDetailsUseCaseImplTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var getAnimeDetailsUseCaseImpl: GetAnimeDetailsUseCaseImpl

    @MockK
    lateinit var mockRepository: AnimeDetailsRepository

    @Test
    fun `Given anime id and repository available, When requesting anime details, Then successful result`() =
        runTest {
            val successValue = mockk<AnimeDetailsModel>()
            coEvery { mockRepository.getAnimeDetails(1) } returns Result.success(successValue)

            getAnimeDetailsUseCaseImpl = GetAnimeDetailsUseCaseImpl(mockRepository)

            val result = getAnimeDetailsUseCaseImpl.invoke(1)
            assertEquals(Result.success(successValue), result)
        }

    @Test
    fun `Given anime id and repository unavailable, When requesting anime details, Then failure result`() =
        runTest {
            val failureException = mockk<Exception>()
            coEvery { mockRepository.getAnimeDetails(1) } returns Result.failure(failureException)

            getAnimeDetailsUseCaseImpl = GetAnimeDetailsUseCaseImpl(mockRepository)

            val result = getAnimeDetailsUseCaseImpl.invoke(1)
            assertEquals(Result.failure<AnimeDetailsModel>(failureException), result)
        }
}
