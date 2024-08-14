package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response
import com.google.gson.annotations.SerializedName

import org.openapitools.network.models.ExternalLinks
import org.openapitools.network.models.GetRandomUsers200Response
import org.openapitools.network.models.GetTopReviews200Response
import org.openapitools.network.models.GetUserById200Response
import org.openapitools.network.models.GetUserFavorites200Response
import org.openapitools.network.models.GetUserFullProfile200Response
import org.openapitools.network.models.Recommendations
import org.openapitools.network.models.UserAbout
import org.openapitools.network.models.UserAnimeListStatusFilter
import org.openapitools.network.models.UserClubs
import org.openapitools.network.models.UserFriends
import org.openapitools.network.models.UserHistory
import org.openapitools.network.models.UserMangaListStatusFilter
import org.openapitools.network.models.UserStatistics
import org.openapitools.network.models.UserUpdates
import org.openapitools.network.models.UsersSearch
import org.openapitools.network.models.UsersSearchQueryGender

interface UsersApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user about in raw HTML
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @return [UserAbout]
     */
    @GET("users/{username}/about")
    suspend fun getUserAbout(@Path("username") username: String): Response<UserAbout>

    /**
     * 
     * User Anime lists have been discontinued since May 1st, 2022. &lt;a href&#x3D;&#39;https://docs.google.com/document/d/1-6H-agSnqa8Mfmw802UYfGQrceIEnAaEh4uCXAPiX5A&#39;&gt;Read more&lt;/a&gt;
     * Responses:
     *  - 200: Returns user anime list
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @param status  (optional)
     * @return [kotlin.Any]
     */
    @Deprecated("This api was deprecated")
    @GET("users/{username}/animelist")
    suspend fun getUserAnimelist(@Path("username") username: String, @Query("status") status: UserAnimeListStatusFilter? = null): Response<Any>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns username by ID search
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetUserById200Response]
     */
    @GET("users/userbyid/{id}")
    suspend fun getUserById(@Path("id") id: Int): Response<GetUserById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user clubs
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @param page  (optional)
     * @return [UserClubs]
     */
    @GET("users/{username}/clubs")
    suspend fun getUserClubs(@Path("username") username: String, @Query("page") page: Int? = null): Response<UserClubs>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user's external links
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @return [ExternalLinks]
     */
    @GET("users/{username}/external")
    suspend fun getUserExternal(@Path("username") username: String): Response<ExternalLinks>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user favorites
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @return [GetUserFavorites200Response]
     */
    @GET("users/{username}/favorites")
    suspend fun getUserFavorites(@Path("username") username: String): Response<GetUserFavorites200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user friends
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @param page  (optional)
     * @return [UserFriends]
     */
    @GET("users/{username}/friends")
    suspend fun getUserFriends(@Path("username") username: String, @Query("page") page: Int? = null): Response<UserFriends>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns complete user resource data
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @return [GetUserFullProfile200Response]
     */
    @GET("users/{username}/full")
    suspend fun getUserFullProfile(@Path("username") username: String): Response<GetUserFullProfile200Response>


    /**
    * enum for parameter type
    */
    enum class TypeGetUserHistory(val value: String) {
        @SerializedName(value = "anime") anime("anime"),
        @SerializedName(value = "manga") manga("manga")
    }

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user history (past 30 days)
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @param type  (optional)
     * @return [UserHistory]
     */
    @GET("users/{username}/history")
    suspend fun getUserHistory(@Path("username") username: String, @Query("type") type: TypeGetUserHistory? = null): Response<UserHistory>

    /**
     * 
     * User Manga lists have been discontinued since May 1st, 2022. &lt;a href&#x3D;&#39;https://docs.google.com/document/d/1-6H-agSnqa8Mfmw802UYfGQrceIEnAaEh4uCXAPiX5A&#39;&gt;Read more&lt;/a&gt;
     * Responses:
     *  - 200: Returns user manga list
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @param status  (optional)
     * @return [kotlin.Any]
     */
    @Deprecated("This api was deprecated")
    @GET("users/{username}/mangalist")
    suspend fun getUserMangaList(@Path("username") username: String, @Query("status") status: UserMangaListStatusFilter? = null): Response<Any>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user profile
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @return [GetRandomUsers200Response]
     */
    @GET("users/{username}")
    suspend fun getUserProfile(@Path("username") username: String): Response<GetRandomUsers200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Recent Anime Recommendations
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @param page  (optional)
     * @return [Recommendations]
     */
    @GET("users/{username}/recommendations")
    suspend fun getUserRecommendations(@Path("username") username: String, @Query("page") page: Int? = null): Response<Recommendations>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user reviews
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @param page  (optional)
     * @return [GetTopReviews200Response]
     */
    @GET("users/{username}/reviews")
    suspend fun getUserReviews(@Path("username") username: String, @Query("page") page: Int? = null): Response<GetTopReviews200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user statistics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @return [UserStatistics]
     */
    @GET("users/{username}/statistics")
    suspend fun getUserStatistics(@Path("username") username: String): Response<UserStatistics>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns user updates
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param username 
     * @return [UserUpdates]
     */
    @GET("users/{username}/userupdates")
    suspend fun getUserUpdates(@Path("username") username: String): Response<UserUpdates>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns search results for users
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @param gender  (optional)
     * @param location  (optional)
     * @param maxAge  (optional)
     * @param minAge  (optional)
     * @return [UsersSearch]
     */
    @GET("users")
    suspend fun getUsersSearch(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("gender") gender: UsersSearchQueryGender? = null, @Query("location") location: String? = null, @Query("maxAge") maxAge: Int? = null, @Query("minAge") minAge: Int? = null): Response<UsersSearch>

}
