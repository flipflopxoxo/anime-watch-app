package com.clydelizardo.animeon_watch.di

import com.clydelizardo.animeon_watch.ongoing.domain.GetOngoingAnimeUseCase
import com.clydelizardo.animeon_watch.ongoing.domain.GetOngoingAnimeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class OngoingAnimeModule {
    @Binds
    abstract fun getOngoingAnimeUseCase(getOngoingAnimeUseCaseImpl: GetOngoingAnimeUseCaseImpl): GetOngoingAnimeUseCase
}