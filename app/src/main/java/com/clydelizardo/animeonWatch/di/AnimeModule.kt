package com.clydelizardo.animeonWatch.di

import com.clydelizardo.animeonWatch.details.data.AnimeDetailsRepositoryImpl
import com.clydelizardo.animeonWatch.details.domain.AnimeDetailsRepository
import com.clydelizardo.animeonWatch.ongoing.data.AnimeRepositoryImpl
import com.clydelizardo.animeonWatch.ongoing.domain.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AnimeModule {
    @Binds
    abstract fun animeRepository(animeRepositoryImpl: AnimeRepositoryImpl): AnimeRepository

    @Binds
    abstract fun animeDetailsRepository(animeDetailsRepositoryImpl: AnimeDetailsRepositoryImpl): AnimeDetailsRepository
}
