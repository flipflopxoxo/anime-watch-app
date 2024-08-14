package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.AnimeSearch
import org.openapitools.network.models.AnimeSearchQueryRating
import org.openapitools.network.models.AnimeSearchQueryType
import org.openapitools.network.models.CharactersSearch
import org.openapitools.network.models.GetTopReviews200Response
import org.openapitools.network.models.MangaSearch
import org.openapitools.network.models.MangaSearchQueryType
import org.openapitools.network.models.PeopleSearch
import org.openapitools.network.models.TopAnimeFilter
import org.openapitools.network.models.TopMangaFilter
import org.openapitools.network.models.TopReviewsTypeEnum

interface TopApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns top anime
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param type  (optional)
     * @param filter  (optional)
     * @param rating  (optional)
     * @param sfw Filter out Adult entries (optional)
     * @param page  (optional)
     * @param limit  (optional)
     * @return [AnimeSearch]
     */
    @GET("top/anime")
    suspend fun getTopAnime(@Query("type") type: AnimeSearchQueryType? = null, @Query("filter") filter: TopAnimeFilter? = null, @Query("rating") rating: AnimeSearchQueryRating? = null, @Query("sfw") sfw: Boolean? = null, @Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<AnimeSearch>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns top characters
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @return [CharactersSearch]
     */
    @GET("top/characters")
    suspend fun getTopCharacters(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<CharactersSearch>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns top manga
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param type  (optional)
     * @param filter  (optional)
     * @param page  (optional)
     * @param limit  (optional)
     * @return [MangaSearch]
     */
    @GET("top/manga")
    suspend fun getTopManga(@Query("type") type: MangaSearchQueryType? = null, @Query("filter") filter: TopMangaFilter? = null, @Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<MangaSearch>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns top people
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @return [PeopleSearch]
     */
    @GET("top/people")
    suspend fun getTopPeople(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<PeopleSearch>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns top reviews
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param type  (optional)
     * @param preliminary Whether the results include preliminary reviews or not. Defaults to true. (optional)
     * @param spoilers Whether the results include reviews with spoilers or not. Defaults to true. (optional)
     * @return [GetTopReviews200Response]
     */
    @GET("top/reviews")
    suspend fun getTopReviews(@Query("page") page: Int? = null, @Query("type") type: TopReviewsTypeEnum? = null, @Query("preliminary") preliminary: Boolean? = null, @Query("spoilers") spoilers: Boolean? = null): Response<GetTopReviews200Response>

}
