package com.clydelizardo.animeon_watch.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clydelizardo.animeon_watch.details.domain.GetAnimeDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    val getAnimeDetailsUseCase: GetAnimeDetailsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(AnimeDetailsViewStateModel())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            val result = getAnimeDetailsUseCase(55791)
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