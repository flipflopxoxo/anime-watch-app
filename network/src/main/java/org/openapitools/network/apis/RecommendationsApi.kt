package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.Recommendations

interface RecommendationsApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns recent anime recommendations
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @return [Recommendations]
     */
    @GET("recommendations/anime")
    suspend fun getRecentAnimeRecommendations(@Query("page") page: Int? = null): Response<Recommendations>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns recent manga recommendations
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @return [Recommendations]
     */
    @GET("recommendations/manga")
    suspend fun getRecentMangaRecommendations(@Query("page") page: Int? = null): Response<Recommendations>

}
