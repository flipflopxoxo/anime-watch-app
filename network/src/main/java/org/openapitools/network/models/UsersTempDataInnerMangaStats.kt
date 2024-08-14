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
 * Manga Stats
 *
 * @param daysRead Number of days spent reading Manga
 * @param meanScore Mean Score
 * @param reading Manga Reading
 * @param completed Manga Completed
 * @param onHold Manga On-Hold
 * @param dropped Manga Dropped
 * @param planToRead Manga Planned to Read
 * @param totalEntries Total Manga entries on User list
 * @param reread Manga re-read
 * @param chaptersRead Number of Manga Chapters Read
 * @param volumesRead Number of Manga Volumes Read
 */


data class UsersTempDataInnerMangaStats (

    /* Number of days spent reading Manga */
    @SerializedName("days_read")
    val daysRead: kotlin.Float? = null,

    /* Mean Score */
    @SerializedName("mean_score")
    val meanScore: kotlin.Float? = null,

    /* Manga Reading */
    @SerializedName("reading")
    val reading: kotlin.Int? = null,

    /* Manga Completed */
    @SerializedName("completed")
    val completed: kotlin.Int? = null,

    /* Manga On-Hold */
    @SerializedName("on_hold")
    val onHold: kotlin.Int? = null,

    /* Manga Dropped */
    @SerializedName("dropped")
    val dropped: kotlin.Int? = null,

    /* Manga Planned to Read */
    @SerializedName("plan_to_read")
    val planToRead: kotlin.Int? = null,

    /* Total Manga entries on User list */
    @SerializedName("total_entries")
    val totalEntries: kotlin.Int? = null,

    /* Manga re-read */
    @SerializedName("reread")
    val reread: kotlin.Int? = null,

    /* Number of Manga Chapters Read */
    @SerializedName("chapters_read")
    val chaptersRead: kotlin.Int? = null,

    /* Number of Manga Volumes Read */
    @SerializedName("volumes_read")
    val volumesRead: kotlin.Int? = null

)

