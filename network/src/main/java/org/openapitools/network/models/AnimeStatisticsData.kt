/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.network.models

import com.google.gson.annotations.SerializedName

/**
 * 
 *
 * @param watching Number of users watching the resource
 * @param completed Number of users who have completed the resource
 * @param onHold Number of users who have put the resource on hold
 * @param dropped Number of users who have dropped the resource
 * @param planToWatch Number of users who have planned to watch the resource
 * @param total Total number of users who have the resource added to their lists
 * @param scores 
 */


data class AnimeStatisticsData (

    /* Number of users watching the resource */
    @SerializedName("watching")
    val watching: Int? = null,

    /* Number of users who have completed the resource */
    @SerializedName("completed")
    val completed: Int? = null,

    /* Number of users who have put the resource on hold */
    @SerializedName("on_hold")
    val onHold: Int? = null,

    /* Number of users who have dropped the resource */
    @SerializedName("dropped")
    val dropped: Int? = null,

    /* Number of users who have planned to watch the resource */
    @SerializedName("plan_to_watch")
    val planToWatch: Int? = null,

    /* Total number of users who have the resource added to their lists */
    @SerializedName("total")
    val total: Int? = null,

    @SerializedName("scores")
    val scores: List<AnimeStatisticsDataScoresInner>? = null

)

