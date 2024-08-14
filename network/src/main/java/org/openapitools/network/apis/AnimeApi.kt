package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response
import com.google.gson.annotations.SerializedName

import org.openapitools.network.models.AnimeCharacters
import org.openapitools.network.models.AnimeEpisodes
import org.openapitools.network.models.AnimeNews
import org.openapitools.network.models.AnimeReviews
import org.openapitools.network.models.AnimeSearch
import org.openapitools.network.models.AnimeSearchQueryOrderby
import org.openapitools.network.models.AnimeSearchQueryRating
import org.openapitools.network.models.AnimeSearchQueryStatus
import org.openapitools.network.models.AnimeSearchQueryType
import org.openapitools.network.models.AnimeStaff
import org.openapitools.network.models.AnimeStatistics
import org.openapitools.network.models.AnimeThemes
import org.openapitools.network.models.AnimeUserupdates
import org.openapitools.network.models.AnimeVideos
import org.openapitools.network.models.AnimeVideosEpisodes
import org.openapitools.network.models.EntryRecommendations
import org.openapitools.network.models.ExternalLinks
import org.openapitools.network.models.Forum
import org.openapitools.network.models.GetAnimeById200Response
import org.openapitools.network.models.GetAnimeEpisodeById200Response
import org.openapitools.network.models.GetAnimeFullById200Response
import org.openapitools.network.models.GetAnimeRelations200Response
import org.openapitools.network.models.Moreinfo
import org.openapitools.network.models.PicturesVariants
import org.openapitools.network.models.SearchQuerySort

interface AnimeApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetAnimeById200Response]
     */
    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: Int): Response<GetAnimeById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime characters resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [AnimeCharacters]
     */
    @GET("anime/{id}/characters")
    suspend fun getAnimeCharacters(@Path("id") id: Int): Response<AnimeCharacters>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a single anime episode resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param episode 
     * @return [GetAnimeEpisodeById200Response]
     */
    @GET("anime/{id}/episodes/{episode}")
    suspend fun getAnimeEpisodeById(@Path("id") id: Int, @Path("episode") episode: Int): Response<GetAnimeEpisodeById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of anime episodes
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @return [AnimeEpisodes]
     */
    @GET("anime/{id}/episodes")
    suspend fun getAnimeEpisodes(@Path("id") id: Int, @Query("page") page: Int? = null): Response<AnimeEpisodes>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime external links
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [ExternalLinks]
     */
    @GET("anime/{id}/external")
    suspend fun getAnimeExternal(@Path("id") id: Int): Response<ExternalLinks>


    /**
    * enum for parameter filter
    */
    enum class FilterGetAnimeForum(val value: String) {
        @SerializedName(value = "all") all("all"),
        @SerializedName(value = "episode") episode("episode"),
        @SerializedName(value = "other") other("other")
    }

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of forum topics related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param filter Filter topics (optional)
     * @return [Forum]
     */
    @GET("anime/{id}/forum")
    suspend fun getAnimeForum(@Path("id") id: Int, @Query("filter") filter: FilterGetAnimeForum? = null): Response<Forum>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns complete anime resource data
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetAnimeFullById200Response]
     */
    @GET("anime/{id}/full")
    suspend fun getAnimeFullById(@Path("id") id: Int): Response<GetAnimeFullById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime statistics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [Moreinfo]
     */
    @GET("anime/{id}/moreinfo")
    suspend fun getAnimeMoreInfo(@Path("id") id: Int): Response<Moreinfo>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of news articles related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @return [AnimeNews]
     */
    @GET("anime/{id}/news")
    suspend fun getAnimeNews(@Path("id") id: Int, @Query("page") page: Int? = null): Response<AnimeNews>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns pictures related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [PicturesVariants]
     */
    @GET("anime/{id}/pictures")
    suspend fun getAnimePictures(@Path("id") id: Int): Response<PicturesVariants>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime recommendations
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [EntryRecommendations]
     */
    @GET("anime/{id}/recommendations")
    suspend fun getAnimeRecommendations(@Path("id") id: Int): Response<EntryRecommendations>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime relations
     *
     * @param id 
     * @return [GetAnimeRelations200Response]
     */
    @GET("anime/{id}/relations")
    suspend fun getAnimeRelations(@Path("id") id: Int): Response<GetAnimeRelations200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime reviews
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @param preliminary Any reviews left during an ongoing anime/manga, those reviews are tagged as preliminary. NOTE: Preliminary reviews are not returned by default so if the entry is airing/publishing you need to add this otherwise you will get an empty list. e.g usage: &#x60;?preliminary&#x3D;true&#x60; (optional)
     * @param spoilers Any reviews that are tagged as a spoiler. Spoiler reviews are not returned by default. e.g usage: &#x60;?spoiler&#x3D;true&#x60; (optional)
     * @return [AnimeReviews]
     */
    @GET("anime/{id}/reviews")
    suspend fun getAnimeReviews(@Path("id") id: Int, @Query("page") page: Int? = null, @Query("preliminary") preliminary: Boolean? = null, @Query("spoilers") spoilers: Boolean? = null): Response<AnimeReviews>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns search results for anime
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
     * @param rating  (optional)
     * @param sfw Filter out Adult entries (optional)
     * @param genres Filter by genre(s) IDs. Can pass multiple with a comma as a delimiter. e.g 1,2,3 (optional)
     * @param genresExclude Exclude genre(s) IDs. Can pass multiple with a comma as a delimiter. e.g 1,2,3 (optional)
     * @param orderBy  (optional)
     * @param sort  (optional)
     * @param letter Return entries starting with the given letter (optional)
     * @param producers Filter by producer(s) IDs. Can pass multiple with a comma as a delimiter. e.g 1,2,3 (optional)
     * @param startDate Filter by starting date. Format: YYYY-MM-DD. e.g &#x60;2022&#x60;, &#x60;2005-05&#x60;, &#x60;2005-01-01&#x60; (optional)
     * @param endDate Filter by ending date. Format: YYYY-MM-DD. e.g &#x60;2022&#x60;, &#x60;2005-05&#x60;, &#x60;2005-01-01&#x60; (optional)
     * @return [AnimeSearch]
     */
    @GET("anime")
    suspend fun getAnimeSearch(@Query("unapproved") unapproved: Boolean? = null, @Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("type") type: AnimeSearchQueryType? = null, @Query("score") score: java.math.BigDecimal? = null, @Query("min_score") minScore: java.math.BigDecimal? = null, @Query("max_score") maxScore: java.math.BigDecimal? = null, @Query("status") status: AnimeSearchQueryStatus? = null, @Query("rating") rating: AnimeSearchQueryRating? = null, @Query("sfw") sfw: Boolean? = null, @Query("genres") genres: String? = null, @Query("genres_exclude") genresExclude: String? = null, @Query("order_by") orderBy: AnimeSearchQueryOrderby? = null, @Query("sort") sort: SearchQuerySort? = null, @Query("letter") letter: String? = null, @Query("producers") producers: String? = null, @Query("start_date") startDate: String? = null, @Query("end_date") endDate: String? = null): Response<AnimeSearch>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime staff resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [AnimeStaff]
     */
    @GET("anime/{id}/staff")
    suspend fun getAnimeStaff(@Path("id") id: Int): Response<AnimeStaff>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime statistics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [AnimeStatistics]
     */
    @GET("anime/{id}/statistics")
    suspend fun getAnimeStatistics(@Path("id") id: Int): Response<AnimeStatistics>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime streaming links
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [ExternalLinks]
     */
    @GET("anime/{id}/streaming")
    suspend fun getAnimeStreaming(@Path("id") id: Int): Response<ExternalLinks>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime themes
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [AnimeThemes]
     */
    @GET("anime/{id}/themes")
    suspend fun getAnimeThemes(@Path("id") id: Int): Response<AnimeThemes>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of users who have added/updated/removed the entry on their list
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @return [AnimeUserupdates]
     */
    @GET("anime/{id}/userupdates")
    suspend fun getAnimeUserUpdates(@Path("id") id: Int, @Query("page") page: Int? = null): Response<AnimeUserupdates>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns videos related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [AnimeVideos]
     */
    @GET("anime/{id}/videos")
    suspend fun getAnimeVideos(@Path("id") id: Int): Response<AnimeVideos>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns episode videos related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @return [AnimeVideosEpisodes]
     */
    @GET("anime/{id}/videos/episodes")
    suspend fun getAnimeVideosEpisodes(@Path("id") id: Int, @Query("page") page: Int? = null): Response<AnimeVideosEpisodes>

}
