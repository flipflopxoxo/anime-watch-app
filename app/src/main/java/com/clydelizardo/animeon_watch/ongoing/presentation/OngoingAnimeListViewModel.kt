package com.clydelizardo.animeon_watch.ongoing.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clydelizardo.animeon_watch.ongoing.domain.GetOngoingAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OngoingAnimeListViewModel @Inject constructor(
    private val getOngoingAnimeUseCase: GetOngoingAnimeUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(OngoingAnimeViewState(isLoading = true))
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val result = getOngoingAnimeUseCase.invoke()
            _state.update {
                if (result.isSuccess) it.copy(
                    isLoading = false,
                    animeList = result.getOrNull()?.content.orEmpty(),
                    pagesLoaded = 1,
                    hasNext = result.getOrNull()?.hasNext ?: false,
                )
                else it.copy(isLoading = false, errorMessage = "Unable to load list")
            }
        }
    }

    private fun loadNextPage() {
        _state.update {
            it.copy(isLoading = true, errorMessage = null)
        }
        viewModelScope.launch {
            val requestedPageNumber = _state.value.pagesLoaded + 1
            val result = getOngoingAnimeUseCase.invoke(requestedPageNumber)
            _state.updateAndGet {
                if (result.isSuccess) it.copy(
                    isLoading = false,
                    animeList = (it.animeList + result.getOrNull()?.content.orEmpty()).distinctBy { it.id },
                    pagesLoaded = requestedPageNumber,
                    hasNext = result.getOrNull()?.hasNext ?: false,
                )
                else it.copy(isLoading = false, errorMessage = "Unable to load list")
            }
        }
    }

    fun onAction(action: OngoingAnimeListAction) {
       when (action) {
           OngoingAnimeListAction.LoadMore -> {
               if (_state.value.isReadyToLoadMore) {
                   loadNextPage()
               }
           }
           OngoingAnimeListAction.Retry -> {
               if (_state.value.isReadyForRetry) {
                   loadNextPage()
               }
           }
       }
    }
}