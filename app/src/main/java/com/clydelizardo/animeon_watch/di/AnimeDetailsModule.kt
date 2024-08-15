package com.clydelizardo.animeon_watch.di

import com.clydelizardo.animeon_watch.details.domain.GetAnimeDetailsUseCase
import com.clydelizardo.animeon_watch.details.domain.GetAnimeDetailsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AnimeDetailsModule {
    @Binds
    abstract fun useCase(getAnimeDetailsUseCase: GetAnimeDetailsUseCaseImpl): GetAnimeDetailsUseCase
}