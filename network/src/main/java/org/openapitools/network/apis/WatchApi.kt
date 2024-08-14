package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.WatchEpisodes
import org.openapitools.network.models.WatchPromos

interface WatchApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Popular Episodes
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [WatchEpisodes]
     */
    @GET("watch/episodes/popular")
    suspend fun getWatchPopularEpisodes(): Response<WatchEpisodes>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Popular Promotional Videos
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [WatchPromos]
     */
    @GET("watch/promos/popular")
    suspend fun getWatchPopularPromos(): Response<WatchPromos>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Recently Added Episodes
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [WatchEpisodes]
     */
    @GET("watch/episodes")
    suspend fun getWatchRecentEpisodes(): Response<WatchEpisodes>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Recently Added Promotional Videos
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @return [WatchPromos]
     */
    @GET("watch/promos")
    suspend fun getWatchRecentPromos(@Query("page") page: Int? = null): Response<WatchPromos>

}
