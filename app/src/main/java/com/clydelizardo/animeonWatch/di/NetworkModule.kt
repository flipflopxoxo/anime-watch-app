package com.clydelizardo.animeonWatch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.openapitools.network.apis.AnimeApi
import org.openapitools.network.apis.SeasonsApi
import org.openapitools.network.infrastructure.ApiClient

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun apiClient(): ApiClient = ApiClient()

    @Provides
    fun seasonsApi(apiClient: ApiClient): SeasonsApi = apiClient.createService(SeasonsApi::class.java)

    @Provides
    fun animeApi(apiClient: ApiClient): AnimeApi = apiClient.createService(AnimeApi::class.java)
}
