package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response
import com.google.gson.annotations.SerializedName

import org.openapitools.network.models.AnimeSearch

interface SeasonsApi {


    /**
    * enum for parameter filter
    */
    enum class FilterGetSeasonNow(val value: String) {
        @SerializedName(value = "tv") tv("tv"),
        @SerializedName(value = "movie") movie("movie"),
        @SerializedName(value = "ova") ova("ova"),
        @SerializedName(value = "special") special("special"),
        @SerializedName(value = "ona") ona("ona"),
        @SerializedName(value = "music") music("music")
    }

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns current seasonal anime
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param filter Entry types (optional)
     * @param sfw &#39;Safe For Work&#39;. This is a flag. When supplied it will filter out entries according to the SFW Policy. You do not need to pass a value to it. e.g usage: &#x60;?sfw&#x60; (optional)
     * @param unapproved This is a flag. When supplied it will include entries which are unapproved. Unapproved entries on MyAnimeList are those that are user submitted and have not yet been approved by MAL to show up on other pages. They will have their own specifc pages and are often removed resulting in a 404 error. You do not need to pass a value to it. e.g usage: &#x60;?unapproved&#x60; (optional)
     * @param continuing This is a flag. When supplied it will include entries which are continuing from previous seasons. MAL includes these items on the seasons view in the &amp;#8243;TV (continuing)&amp;#8243; section. (Example: https://myanimelist.net/anime/season/2024/winter) &lt;br /&gt;Example usage: &#x60;?continuing&#x60; (optional)
     * @param page  (optional)
     * @param limit  (optional)
     * @return [AnimeSearch]
     */
    @GET("seasons/now")
    suspend fun getSeasonNow(@Query("filter") filter: FilterGetSeasonNow? = null, @Query("sfw") sfw: Boolean? = null, @Query("unapproved") unapproved: Boolean? = null, @Query("continuing") continuing: Boolean? = null, @Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<AnimeSearch>


}
