package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response


interface ReviewsApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns recent anime reviews
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param preliminary Any reviews left during an ongoing anime/manga, those reviews are tagged as preliminary. NOTE: Preliminary reviews are not returned by default so if the entry is airing/publishing you need to add this otherwise you will get an empty list. e.g usage: &#x60;?preliminary&#x3D;true&#x60; (optional)
     * @param spoilers Any reviews that are tagged as a spoiler. Spoiler reviews are not returned by default. e.g usage: &#x60;?spoiler&#x3D;true&#x60; (optional)
     * @return [kotlin.Any]
     */
    @GET("reviews/anime")
    suspend fun getRecentAnimeReviews(@Query("page") page: Int? = null, @Query("preliminary") preliminary: Boolean? = null, @Query("spoilers") spoilers: Boolean? = null): Response<Any>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns recent manga reviews
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param preliminary Any reviews left during an ongoing anime/manga, those reviews are tagged as preliminary. NOTE: Preliminary reviews are not returned by default so if the entry is airing/publishing you need to add this otherwise you will get an empty list. e.g usage: &#x60;?preliminary&#x3D;true&#x60; (optional)
     * @param spoilers Any reviews that are tagged as a spoiler. Spoiler reviews are not returned by default. e.g usage: &#x60;?spoiler&#x3D;true&#x60; (optional)
     * @return [kotlin.Any]
     */
    @GET("reviews/manga")
    suspend fun getRecentMangaReviews(@Query("page") page: Int? = null, @Query("preliminary") preliminary: Boolean? = null, @Query("spoilers") spoilers: Boolean? = null): Response<Any>

}
