package com.clydelizardo.animeonWatch.di

import com.clydelizardo.animeonWatch.domain.details.GetAnimeDetailsUseCase
import com.clydelizardo.animeonWatch.domain.details.GetAnimeDetailsUseCaseImpl
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
