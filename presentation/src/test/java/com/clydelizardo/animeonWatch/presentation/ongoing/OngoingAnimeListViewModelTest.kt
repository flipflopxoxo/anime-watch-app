package com.clydelizardo.animeonWatch.presentation.ongoing

import com.clydelizardo.animeonWatch.domain.ongoing.GetOngoingAnimeUseCase
import com.clydelizardo.common.MainCoroutineRule
import com.clydelizardo.models.AnimeModel
import io.mockk.coEvery
import io.mockk.coJustAwait
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class OngoingAnimeListViewModelTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var viewModel: OngoingAnimeListViewModel

    @MockK
    lateinit var mockUseCase: GetOngoingAnimeUseCase

    @Test
    fun `given view model is created, then state is loading`() =
        runTest {
            coJustAwait { mockUseCase.invoke() }

            viewModel = OngoingAnimeListViewModel(mockUseCase)

            Assert.assertEquals(OngoingAnimeViewState(isLoading = true), viewModel.state.first())
        }

    @Test
    fun `given view model is created and use case returns success, then state is populated`() =
        runTest {
            val value = mockk<List<AnimeModel>>()
            coEvery { mockUseCase.invoke() } returns Result.success(value)

            viewModel = OngoingAnimeListViewModel(mockUseCase)

            Assert.assertEquals(
                OngoingAnimeViewState(isLoading = false, animeList = value),
                viewModel.state.first()
            )
        }

    @Test
    fun `given view model is created and use case returns failure, then state has error`() =
        runTest {
            coEvery { mockUseCase.invoke() } returns Result.failure(mockk())

            viewModel = OngoingAnimeListViewModel(mockUseCase)

            Assert.assertEquals(
                OngoingAnimeViewState(
                    isLoading = false,
                    errorMessage = "Unable to load list"
                ), viewModel.state.first()
            )
        }
}