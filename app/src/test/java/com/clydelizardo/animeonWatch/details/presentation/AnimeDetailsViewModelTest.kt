package com.clydelizardo.animeonWatch.details.presentation

import androidx.lifecycle.SavedStateHandle
import com.clydelizardo.animeonWatch.MainCoroutineRule
import com.clydelizardo.animeonWatch.domain.details.GetAnimeDetailsUseCase
import com.clydelizardo.models.AnimeDetailsModel
import io.mockk.coEvery
import io.mockk.coJustAwait
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class AnimeDetailsViewModelTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var viewModel: AnimeDetailsViewModel

    @MockK
    lateinit var savedStateHandle: SavedStateHandle

    @MockK
    lateinit var mockUseCase: GetAnimeDetailsUseCase

    @Test
    fun `given view model is created, then state is loading`() =
        runTest {
            every { savedStateHandle.get<Int>("id") } returns 1
            coJustAwait { mockUseCase.invoke(any()) }
            viewModel = AnimeDetailsViewModel(mockUseCase, savedStateHandle)

            Assert.assertEquals(AnimeDetailsViewStateModel(isLoading = true), viewModel.state.first())
        }

    @Test
    fun `given view model is created and use case returns success, then state is populated`() =
        runTest {
            every { savedStateHandle.get<Int>("id") } returns 1
            val value = mockk<AnimeDetailsModel>()
            coEvery { mockUseCase.invoke(any()) } returns Result.success(value)
            viewModel = AnimeDetailsViewModel(mockUseCase, savedStateHandle)

            Assert.assertEquals(AnimeDetailsViewStateModel(animeDetails = value), viewModel.state.first())
        }

    @Test
    fun `given view model is created and use case returns failure, then state has error`() =
        runTest {
            every { savedStateHandle.get<Int>("id") } returns 1
            coEvery { mockUseCase.invoke(any()) } returns Result.failure(mockk())
            viewModel = AnimeDetailsViewModel(mockUseCase, savedStateHandle)

            Assert.assertEquals(AnimeDetailsViewStateModel(errorMessage = "Unable to get details"), viewModel.state.first())
        }
}
