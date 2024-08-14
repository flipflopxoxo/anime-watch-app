package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response
import com.google.gson.annotations.SerializedName

import org.openapitools.network.models.Schedules

interface SchedulesApi {

    /**
    * enum for parameter filter
    */
    enum class FilterGetSchedules(val value: String) {
        @SerializedName(value = "monday") monday("monday"),
        @SerializedName(value = "tuesday") tuesday("tuesday"),
        @SerializedName(value = "wednesday") wednesday("wednesday"),
        @SerializedName(value = "thursday") thursday("thursday"),
        @SerializedName(value = "friday") friday("friday"),
        @SerializedName(value = "saturday") saturday("saturday"),
        @SerializedName(value = "sunday") sunday("sunday"),
        @SerializedName(value = "unknown") unknown("unknown"),
        @SerializedName(value = "other") other("other")
    }


    /**
    * enum for parameter kids
    */
    enum class KidsGetSchedules(val value: String) {
        @SerializedName(value = "true") `true`("true"),
        @SerializedName(value = "false") `false`("false")
    }


    /**
    * enum for parameter sfw
    */
    enum class SfwGetSchedules(val value: String) {
        @SerializedName(value = "true") `true`("true"),
        @SerializedName(value = "false") `false`("false")
    }

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns weekly schedule
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param filter Filter by day (optional)
     * @param kids When supplied, it will filter entries with the &#x60;Kids&#x60; Genre Demographic. When supplied as &#x60;kids&#x3D;true&#x60;, it will return only Kid entries and when supplied as &#x60;kids&#x3D;false&#x60;, it will filter out any Kid entries. Defaults to &#x60;false&#x60;. (optional)
     * @param sfw &#39;Safe For Work&#39;. When supplied, it will filter entries with the &#x60;Hentai&#x60; Genre. When supplied as &#x60;sfw&#x3D;true&#x60;, it will return only SFW entries and when supplied as &#x60;sfw&#x3D;false&#x60;, it will filter out any Hentai entries. Defaults to &#x60;false&#x60;. (optional)
     * @param unapproved This is a flag. When supplied it will include entries which are unapproved. Unapproved entries on MyAnimeList are those that are user submitted and have not yet been approved by MAL to show up on other pages. They will have their own specifc pages and are often removed resulting in a 404 error. You do not need to pass a value to it. e.g usage: &#x60;?unapproved&#x60; (optional)
     * @param page  (optional)
     * @param limit  (optional)
     * @return [Schedules]
     */
    @GET("schedules")
    suspend fun getSchedules(@Query("filter") filter: FilterGetSchedules? = null, @Query("kids") kids: KidsGetSchedules? = null, @Query("sfw") sfw: SfwGetSchedules? = null, @Query("unapproved") unapproved: Boolean? = null, @Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<Schedules>

}
