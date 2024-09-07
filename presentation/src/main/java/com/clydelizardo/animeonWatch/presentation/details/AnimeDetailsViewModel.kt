package com.clydelizardo.animeonWatch.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clydelizardo.animeonWatch.domain.details.GetAnimeDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel
    @Inject
    constructor(
        val getAnimeDetailsUseCase: GetAnimeDetailsUseCase,
        val savedStateHandle: SavedStateHandle,
    ) : ViewModel() {
        private val _state = MutableStateFlow(AnimeDetailsViewStateModel())
        val state = _state.asStateFlow()

        init {
            viewModelScope.launch {
                _state.update {
                    it.copy(isLoading = true)
                }
                val result = getAnimeDetailsUseCase(savedStateHandle.get<Int>("id") ?: 0)
                _state.update {
                    if (result.isSuccess) {
                        it.copy(isLoading = false, animeDetails = result.getOrThrow())
                    } else {
                        it.copy(isLoading = false, errorMessage = "Unable to get details")
                    }
                }
            }
        }
    }
