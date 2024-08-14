package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response
import com.google.gson.annotations.SerializedName

import org.openapitools.network.models.EntryRecommendations
import org.openapitools.network.models.ExternalLinks
import org.openapitools.network.models.Forum
import org.openapitools.network.models.GetAnimeRelations200Response
import org.openapitools.network.models.GetMangaById200Response
import org.openapitools.network.models.GetMangaFullById200Response
import org.openapitools.network.models.MangaCharacters
import org.openapitools.network.models.MangaNews
import org.openapitools.network.models.MangaPictures
import org.openapitools.network.models.MangaReviews
import org.openapitools.network.models.MangaSearch
import org.openapitools.network.models.MangaSearchQueryOrderby
import org.openapitools.network.models.MangaSearchQueryStatus
import org.openapitools.network.models.MangaSearchQueryType
import org.openapitools.network.models.MangaStatistics
import org.openapitools.network.models.MangaUserupdates
import org.openapitools.network.models.Moreinfo
import org.openapitools.network.models.SearchQuerySort

interface MangaApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns pictures related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetMangaById200Response]
     */
    @GET("manga/{id}")
    suspend fun getMangaById(@Path("id") id: Int): Response<GetMangaById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga characters resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [MangaCharacters]
     */
    @GET("manga/{id}/characters")
    suspend fun getMangaCharacters(@Path("id") id: Int): Response<MangaCharacters>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga external links
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [ExternalLinks]
     */
    @GET("manga/{id}/external")
    suspend fun getMangaExternal(@Path("id") id: Int): Response<ExternalLinks>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns complete manga resource data
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetMangaFullById200Response]
     */
    @GET("manga/{id}/full")
    suspend fun getMangaFullById(@Path("id") id: Int): Response<GetMangaFullById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga moreinfo
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [Moreinfo]
     */
    @GET("manga/{id}/moreinfo")
    suspend fun getMangaMoreInfo(@Path("id") id: Int): Response<Moreinfo>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of manga news topics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @return [MangaNews]
     */
    @GET("manga/{id}/news")
    suspend fun getMangaNews(@Path("id") id: Int, @Query("page") page: Int? = null): Response<MangaNews>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of manga pictures
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [MangaPictures]
     */
    @GET("manga/{id}/pictures")
    suspend fun getMangaPictures(@Path("id") id: Int): Response<MangaPictures>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga recommendations
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [EntryRecommendations]
     */
    @GET("manga/{id}/recommendations")
    suspend fun getMangaRecommendations(@Path("id") id: Int): Response<EntryRecommendations>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga relations
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetAnimeRelations200Response]
     */
    @GET("manga/{id}/relations")
    suspend fun getMangaRelations(@Path("id") id: Int): Response<GetAnimeRelations200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga reviews
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @param preliminary Any reviews left during an ongoing anime/manga, those reviews are tagged as preliminary. NOTE: Preliminary reviews are not returned by default so if the entry is airing/publishing you need to add this otherwise you will get an empty list. e.g usage: &#x60;?preliminary&#x3D;true&#x60; (optional)
     * @param spoilers Any reviews that are tagged as a spoiler. Spoiler reviews are not returned by default. e.g usage: &#x60;?spoiler&#x3D;true&#x60; (optional)
     * @return [MangaReviews]
     */
    @GET("manga/{id}/reviews")
    suspend fun getMangaReviews(@Path("id") id: Int, @Query("page") page: Int? = null, @Query("preliminary") preliminary: Boolean? = null, @Query("spoilers") spoilers: Boolean? = null): Response<MangaReviews>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns search results for manga
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param unapproved This is a flag. When supplied it will include entries which are unapproved. Unapproved entries on MyAnimeList are those that are user submitted and have not yet been approved by MAL to show up on other pages. They will have their own specifc pages and are often removed resulting in a 404 error. You do not need to pass a value to it. e.g usage: &#x60;?unapproved&#x60; (optional)
     * @param page  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @param type  (optional)
     * @param score  (optional)
     * @param minScore Set a minimum score for results. (optional)
     * @param maxScore Set a maximum score for results (optional)
     * @param status  (optional)
     * @param sfw Filter out Adult entries (optional)
     * @param genres Filter by genre(s) IDs. Can pass multiple with a comma as a delimiter. e.g 1,2,3 (optional)
     * @param genresExclude Exclude genre(s) IDs. Can pass multiple with a comma as a delimiter. e.g 1,2,3 (optional)
     * @param orderBy  (optional)
     * @param sort  (optional)
     * @param letter Return entries starting with the given letter (optional)
     * @param magazines Filter by magazine(s) IDs. Can pass multiple with a comma as a delimiter. e.g 1,2,3 (optional)
     * @param startDate Filter by starting date. Format: YYYY-MM-DD. e.g &#x60;2022&#x60;, &#x60;2005-05&#x60;, &#x60;2005-01-01&#x60; (optional)
     * @param endDate Filter by ending date. Format: YYYY-MM-DD. e.g &#x60;2022&#x60;, &#x60;2005-05&#x60;, &#x60;2005-01-01&#x60; (optional)
     * @return [MangaSearch]
     */
    @GET("manga")
    suspend fun getMangaSearch(@Query("unapproved") unapproved: Boolean? = null, @Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("type") type: MangaSearchQueryType? = null, @Query("score") score: java.math.BigDecimal? = null, @Query("min_score") minScore: java.math.BigDecimal? = null, @Query("max_score") maxScore: java.math.BigDecimal? = null, @Query("status") status: MangaSearchQueryStatus? = null, @Query("sfw") sfw: Boolean? = null, @Query("genres") genres: String? = null, @Query("genres_exclude") genresExclude: String? = null, @Query("order_by") orderBy: MangaSearchQueryOrderby? = null, @Query("sort") sort: SearchQuerySort? = null, @Query("letter") letter: String? = null, @Query("magazines") magazines: String? = null, @Query("start_date") startDate: String? = null, @Query("end_date") endDate: String? = null): Response<MangaSearch>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime statistics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [MangaStatistics]
     */
    @GET("manga/{id}/statistics")
    suspend fun getMangaStatistics(@Path("id") id: Int): Response<MangaStatistics>


    /**
    * enum for parameter filter
    */
    enum class FilterGetMangaTopics(val value: String) {
        @SerializedName(value = "all") all("all"),
        @SerializedName(value = "episode") episode("episode"),
        @SerializedName(value = "other") other("other")
    }

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of manga forum topics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param filter Filter topics (optional)
     * @return [Forum]
     */
    @GET("manga/{id}/forum")
    suspend fun getMangaTopics(@Path("id") id: Int, @Query("filter") filter: FilterGetMangaTopics? = null): Response<Forum>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga user updates
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @return [MangaUserupdates]
     */
    @GET("manga/{id}/userupdates")
    suspend fun getMangaUserUpdates(@Path("id") id: Int, @Query("page") page: Int? = null): Response<MangaUserupdates>

}
